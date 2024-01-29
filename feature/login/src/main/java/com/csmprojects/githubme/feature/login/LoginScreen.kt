package com.csmprojects.githubme.feature.login

import android.app.Activity.RESULT_OK
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.csmprojects.feature.githubme.login.R
import kotlinx.coroutines.launch

@Composable
internal fun LoginRoute(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    navigateToUsers: () -> Unit
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult(),
        onResult = { result ->
            if (result.resultCode == RESULT_OK && result.data != null) {
                viewModel.saveSignInData(result.data!!)

            } else {
                viewModel.logInFailed()
            }
        }
    )
    val loginUiState by viewModel.loginUiState.collectAsStateWithLifecycle()
    when (loginUiState) {
        LoginUiState.Fail -> {
            Toast.makeText(
                context,
                stringResource(R.string.login_failed_please_try_again), Toast.LENGTH_LONG
            ).show()
        }

        is LoginUiState.Success -> {
            navigateToUsers()
        }

        LoginUiState.Loading -> {}
    }

    if (viewModel.isSignedIn()) {
        navigateToUsers()
    } else {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = modifier
                    .padding(5.dp)
                    .width(300.dp)
                    .height(300.dp),
                painter = painterResource(id = R.drawable.github_icon),
                contentDescription = null
            )
            Button(modifier = modifier
                .width(200.dp)
                .padding(5.dp),
                onClick = {
                    coroutineScope.launch {
                        val sender = viewModel.initLogIn()
                        launcher.launch(
                            IntentSenderRequest.Builder(
                                sender ?: return@launch
                            ).build()
                        )
                    }

                }
            ) {
                Text(
                    text = stringResource(R.string.sign_in), fontSize = 20.sp
                )
            }
        }
    }


}
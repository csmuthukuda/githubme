package com.csmprojects.feature.login

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun LoginRoute(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val isLoading = remember { mutableStateOf(false) }
//    val summaryUiState by viewModel.summaryUiState.collectAsStateWithLifecycle()
//    when (summaryUiState) {
//        SummaryUiState.Fail -> {
//            isLoading.value = false
//            Toast.makeText(context,
//                stringResource(R.string.failed_please_try_again), Toast.LENGTH_LONG).show()
//        }
//
//        SummaryUiState.Loading -> {
//            isLoading.value = true
//        }
//
//        is SummaryUiState.Success -> {
//            isLoading.value = false
//            MaterialTheme {
//                SummaryScreen(
//                    weatherData = (summaryUiState as SummaryUiState.Success).weatherData,
//                    layoutData = (summaryUiState as SummaryUiState.Success).uiLayout,
//                    context = context
//                )
//            }
//
//        }
//    }

//    AnimatedVisibility(
//        visible = isLoading.value,
//        modifier = Modifier
//            .fillMaxSize()
//            .zIndex(1f)
//    ) {
//        CircularProgIndicator(
//            modifier = modifier
//        )
//
//    }
    Text(text = "Success")
}
package com.csmprojects.githubme.feature.users

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.csmprojects.githubme.core.common.model.UsersDataModel

@Composable
internal fun UsersRoute(
    navigateToProfile: (loginId: String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: UsersViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val isLoading = remember { mutableStateOf(false) }
    val usersUiState by viewModel.usersUiState.collectAsStateWithLifecycle()
    when (val state = usersUiState) {
        UsersUiState.Fail -> {
            isLoading.value = false
            Toast.makeText(
                context,
                stringResource(R.string.failed_please_try_again), Toast.LENGTH_LONG
            ).show()
        }

        UsersUiState.Loading -> {
            isLoading.value = true
        }

        is UsersUiState.Success -> {
            isLoading.value = false
            UsersScreen(
                modifier = modifier,
                usersData = state.usersData,
                onItemClick = navigateToProfile
            )
        }
    }

    AnimatedVisibility(
        visible = isLoading.value,
        modifier = Modifier
            .fillMaxSize()
            .zIndex(1f)
    ) {
        CircularProgIndicator(
            modifier = modifier
        )

    }
}

@Composable
private fun UsersScreen(
    modifier: Modifier,
    usersData: List<UsersDataModel>,
    onItemClick: (loginId: String) -> Unit
) {
    LazyColumn {
        itemsIndexed(usersData) { _, item ->
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(all = 5.dp)
                    .clickable {
                        onItemClick(item.login)
                    },

                ) {
                AsyncImage(
                    modifier = modifier
                        .width(100.dp)
                        .padding(5.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Inside,
                    model = item.avatarUrl,
                    contentDescription = null,
                )
                Text(
                    modifier = modifier
                        .padding(all = 5.dp)
                        .padding(start = 20.dp)
                        .weight(1f, fill = true)
                        .align(Alignment.CenterVertically),

                    text = item.login,
                    textAlign = TextAlign.Left,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )

            }
        }
    }
}

@Composable
private fun CircularProgIndicator(
    modifier: Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .clickable(enabled = false) { },
        contentAlignment = Alignment.Center,

        ) {
        CircularProgressIndicator(
            modifier.fillMaxSize(0.12f),
        )
    }
}
package com.csmprojects.githubme.feature.profile

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.RssFeed
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.csmprojects.githubme.core.common.model.ProfileDataModel

@Composable
internal fun ProfileRoute(
    navigateToUsers: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val isLoading = remember { mutableStateOf(false) }
    val profileUiState by viewModel.profileUiState.collectAsStateWithLifecycle()
    when (val state = profileUiState) {
        ProfileUiState.Fail -> {
            isLoading.value = false
            Toast.makeText(
                context,
                stringResource(R.string.failed_please_try_again), Toast.LENGTH_LONG
            ).show()
        }

        ProfileUiState.Loading -> {
            isLoading.value = true
        }

        is ProfileUiState.Success -> {
            isLoading.value = false
            ProfileScreen(
                modifier = modifier,
                usersData = state.data,
                navigateToUsers = navigateToUsers
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProfileScreen(
    modifier: Modifier,
    usersData: ProfileDataModel,
    navigateToUsers: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(text = usersData.name ?: "")

                },
                navigationIcon = {
                    IconButton(
                        onClick = navigateToUsers
                    ) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        ProfileBody(modifier = modifier.padding(innerPadding), data = usersData)
    }
}

@Composable
private fun ProfileBody(
    modifier: Modifier,
    data: ProfileDataModel
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = modifier
                .width(300.dp)
                .padding(5.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            model = data.avatarUrl,
            contentDescription = null,
        )
        if (!data.name.isNullOrBlank()) {
            Row {
                Icon(
                    modifier = modifier
                        .padding(5.dp)
                        .align(Alignment.CenterVertically),
                    imageVector = Icons.Filled.Badge,
                    contentDescription = null
                )
                Text(
                    modifier = modifier
                        .padding(5.dp),
                    text = data.name ?: "",
                    style = MaterialTheme.typography.titleLarge
                )
            }

        }
        if (!data.location.isNullOrBlank()) {
            Row {
                Icon(
                    modifier = modifier
                        .padding(5.dp)
                        .align(Alignment.CenterVertically),
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = null
                )
                Text(
                    modifier = modifier
                        .padding(5.dp),
                    text = data.location ?: "",
                    style = MaterialTheme.typography.titleMedium
                )
            }

        }
        if (!data.twitterUsername.isNullOrBlank()) {
            Row {
                Icon(
                    modifier = modifier
                        .padding(5.dp)
                        .align(Alignment.CenterVertically),
                    imageVector = Icons.Filled.AlternateEmail,
                    contentDescription = null
                )
                Text(
                    modifier = modifier
                        .padding(5.dp),
                    text = "@${data.twitterUsername}" ?: "",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
        if (!data.blog.isNullOrBlank()) {
            Row {
                Icon(
                    modifier = modifier
                        .padding(5.dp)
                        .align(Alignment.CenterVertically),
                    imageVector = Icons.Filled.RssFeed,
                    contentDescription = null
                )
                Text(
                    modifier = modifier
                        .padding(5.dp),
                    text = data.blog ?: "",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }

        if (!data.company.isNullOrBlank()) {
            Row {
                Icon(
                    modifier = modifier
                        .padding(5.dp)
                        .align(Alignment.CenterVertically),
                    imageVector = Icons.Filled.Work,
                    contentDescription = null
                )
                Text(
                    modifier = modifier
                        .padding(5.dp),
                    text = data.company ?: "",
                    style = MaterialTheme.typography.titleMedium,
                    softWrap = true
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
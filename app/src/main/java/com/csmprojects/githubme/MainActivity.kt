package com.csmprojects.githubme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.csmprojects.githubme.navigation.GitHubMeNavHost
import com.csmprojects.githubme.ui.theme.GitHubMeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitHubMeTheme {
                GitHubMeNavHost(navController = rememberNavController())
            }
        }
    }
}


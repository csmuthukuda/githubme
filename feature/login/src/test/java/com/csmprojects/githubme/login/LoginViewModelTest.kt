package com.csmprojects.githubme.login

import android.content.Intent
import com.csmprojects.githubme.core.data.repository.fake.FakeLoginRepository
import com.csmprojects.githubme.feature.login.LoginUiState
import com.csmprojects.githubme.feature.login.LoginViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class LoginViewModelTest {
    private lateinit var viewModel: LoginViewModel
    private val loginRepository = FakeLoginRepository()

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    @Test
    fun successful_saveSignInData_set_status_success() = runTest {
        viewModel = LoginViewModel(loginRepository)
        viewModel.saveSignInData(Intent())
        val collectJob =
            launch(UnconfinedTestDispatcher()) { viewModel.loginUiState.collect() }
        assertEquals(
            viewModel.loginUiState.value,
            LoginUiState.Success(loginRepository.getFakeUserData())
        )

        collectJob.cancel()
    }

    @Test
    fun logInFailed_set_status_fail() = runTest {
        viewModel = LoginViewModel(loginRepository)
        viewModel.logInFailed()
        val collectJob =
            launch(UnconfinedTestDispatcher()) { viewModel.loginUiState.collect() }
        assertEquals(
            viewModel.loginUiState.value,
            LoginUiState.Fail
        )

        collectJob.cancel()
    }

    @Test
    fun isSignedIn_returns_boolean() {
        viewModel = LoginViewModel(loginRepository)
        assertIs<Boolean>(viewModel.isSignedIn())

    }


}
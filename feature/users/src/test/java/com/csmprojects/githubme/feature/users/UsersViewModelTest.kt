package com.csmprojects.githubme.feature.users

import com.csmprojects.githubme.core.data.repository.fake.FakeUsersDataRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class UsersViewModelTest {
    private lateinit var viewModel: UsersViewModel
    private val usersRepository = FakeUsersDataRepository()

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    @Test
    fun failed_Data_call_sets_failed_status() = runTest {
        usersRepository.setListEmpty(true)
        viewModel = UsersViewModel(
            usersDataRepository = usersRepository

        )
        val collectJob =
            launch(UnconfinedTestDispatcher()) { viewModel.usersUiState.collect() }
        assertEquals(viewModel.usersUiState.value, UsersUiState.Fail)
        collectJob.cancel()

    }

    @Test
    fun successful_Data_call_sets_success_status() = runTest {
        usersRepository.setListEmpty(false)
        viewModel = UsersViewModel(
            usersDataRepository = usersRepository

        )
        val collectJob =
            launch(UnconfinedTestDispatcher()) { viewModel.usersUiState.collect() }
        assertEquals(
            viewModel.usersUiState.value,
            UsersUiState.Success(listOf(usersRepository.getTestData()))
        )
        collectJob.cancel()

    }
}
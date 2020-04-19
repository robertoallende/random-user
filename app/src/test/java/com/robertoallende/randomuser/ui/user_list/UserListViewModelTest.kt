package com.robertoallende.randomuser.ui.user_list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.robertoallende.randomuser.RandomUserKoinTest
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.inject
import org.koin.test.get
import com.jraska.livedata.test
import com.robertoallende.randomuser.data.RandomUserRepository
import com.robertoallende.randomuser.model.Name
import com.robertoallende.randomuser.model.User
import com.robertoallende.randomuser.model.UserSearchResult
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.mockito.Mockito.*


class UserListViewModelTest : RandomUserKoinTest() {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun beforeTest() {
        val repositoryMock = mock(RandomUserRepository::class.java)
        val userListViewModel = UserListViewModel(repositoryMock)
        val userListViewModelModule = module {
            viewModel { userListViewModel }
        }
        `when`(repositoryMock.getUsers(userListViewModel.getViewModelScope())).thenReturn(
            UserSearchResult(
                MutableLiveData<PagedList<User>>(), MutableLiveData<String>()
            )
        )

        startKoin {
            modules(userListViewModelModule)
        }
    }

    @After
    fun afterTest() {
        stopKoin()
    }

    @Test
    fun `Given UserList is shown, when user taps on a person, then onUserClicked is triggered`() {
        val viewModel: UserListViewModel = get()
        val testObserver = viewModel.events.test()

        val mickey = User(
            "", null, "", "male", null, null, null,
            Name("mickey", "disney", "mr"), "", "", null, null
        )

        viewModel.onUserClicked(mickey, 1)

        testObserver
            .assertHasValue()
            .assertValue {
                it is UserListEvent.GoToUserDetail
            }
            .assertValue {
                (it as UserListEvent.GoToUserDetail).user.name.fullName() == "mr mickey disney"
            }
    }

    @Test
    fun `Given UserList is shown, when there is an error, then DisplayError is triggered`() {
        val message = "Message"
        val viewModel: UserListViewModel = get()
        val testObserver = viewModel.events.test()

        viewModel.onNetworkError(message)

        testObserver
            .assertHasValue()
            .assertValue {
                it is UserListEvent.DisplayError
            }
            .assertValue {
                (it as UserListEvent.DisplayError).message == message
            }
    }

}

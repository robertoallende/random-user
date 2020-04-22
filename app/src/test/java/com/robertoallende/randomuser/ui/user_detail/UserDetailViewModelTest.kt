package com.robertoallende.randomuser.ui.user_detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.robertoallende.randomuser.RandomUserKoinTest
import com.robertoallende.randomuser.model.Name
import com.robertoallende.randomuser.model.User
import org.junit.*
import org.junit.rules.TestRule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.get

class UserDetailViewModelTest : RandomUserKoinTest() {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun beforeTest() {
        val mickey = User(
            "", null, "", "male", null, null, null,
            Name("mickey", "disney", "mr"), "", "", null, null
        )

        val userDetailViewModel = UserDetailViewModel(mickey)
        val userDetailViewModelModule = module {
            viewModel { userDetailViewModel }
        }

        startKoin {
            modules(userDetailViewModelModule)
        }
    }

    @After
    fun afterTest() {
        stopKoin()
    }

    // Unnecessary
    @Test
    fun `Given UserDetailViewModel, When it is initialized with a given user, then it has the right name`() {
        val viewModel: UserDetailViewModel = get()
        Assert.assertEquals(viewModel.user.name.fullName(), "mr mickey disney")
    }

}

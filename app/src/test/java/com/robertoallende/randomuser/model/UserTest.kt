package com.robertoallende.randomuser.model

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UserTest {

    var mickey: User? = null
    var unknown: User? = null

    @Before
    fun beforeTest() {
        mickey = User(
            "", null, "", "male", null, null, null,
            Name("mickey", "disney", "mr"), "", "", null, null
        )

        unknown = User(
            "", null, "", "", null, null, null,
            Name("", "", ""), "", "", null, null
        )
    }

    @Test
    fun `empty after genderCapitalized is empty`() {
        assertEquals("", unknown?.genderCapitalized())
    }

    @Test
    fun `male after genderCapitalized is Male`() {
        assertEquals("Male", mickey?.genderCapitalized())
    }
}
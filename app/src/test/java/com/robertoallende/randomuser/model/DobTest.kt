package com.robertoallende.randomuser.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DobTest {

    var mickey: Dob? = null
    var unknown: Dob? = null

    @Before
    fun beforeTest() {
        mickey = Dob(92, "1928-01-01T12:30:00.111Z")
        unknown = Dob(null, "")
    }

    @Test
    fun `an invalid date is parsed correctly`() {
        Assert.assertEquals("", unknown?.asString())
    }

    @Test
    fun `a valid date is parsed correctly`() {
        Assert.assertEquals("Jan 01, 1928", mickey?.asString())
    }
}
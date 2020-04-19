package com.robertoallende.randomuser.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class NameTest {

    var mickey: Name? = null
    var unknown: Name? = null
    var nullable: Name? = null

    @Before
    fun beforeTest() {
        mickey = Name("Mickey", "Mouse", "Mr")
        unknown = Name("", "", "")
        nullable = Name("", "", null)
    }

    @Test
    fun `empty name with null title returns a fullName correctly`() {
        Assert.assertEquals("", nullable?.fullName())
    }

    @Test
    fun `empty name returns a fullName correctly`() {
        Assert.assertEquals("", unknown?.fullName())
    }

    @Test
    fun `Mickey returns a fullName correctly`() {
        Assert.assertEquals("Mr Mickey Mouse", mickey?.fullName())
    }
}
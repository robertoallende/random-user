package com.robertoallende.randomuser.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class LocationTest {

    var mickey: Location? = null
    var unknown: Location? = null

    @Before
    fun beforeTest() {
        mickey = Location(
            "Springfield",
            Coordinates("0", "0"),
            "USA",
            "90210",
            "California",
            Street("Siempre Viva", 123),
            Timezone("UTC", "0")
        )
        unknown = Location("", null, "", "", "", Street("", 0), Timezone("", ""))
    }

    @Test
    fun `an invalid location is parsed correctly`() {
        Assert.assertEquals("", unknown?.fullAddress())
    }

    @Test
    fun `a valid location is parsed correctly`() {
        Assert.assertEquals("123 Siempre Viva, Springfield, USA", mickey?.fullAddress())
    }
}
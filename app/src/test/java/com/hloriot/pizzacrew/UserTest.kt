package com.hloriot.pizzacrew

import com.hloriot.pizzacrew.model.User
import com.hloriot.pizzacrew.model.interfaces.IUser
import org.junit.Assert
import org.junit.Test

class UserTest {
    @Test
    fun createUser_isNameCorrect() {
        val user: IUser = User.Factory.createUser(
            "name",
            "password"
        )

        Assert.assertEquals(
            "The energy in kcal of the ingredient is incorrect",
            "name",
            user.getName()
        )
    }

    @Test
    fun createUser_isPasswordHashed() {
        val user: IUser = User.Factory.createUser(
            "name",
            "password"
        )

        Assert.assertNotEquals(
            "The user's password must not be stored without being hashed",
            "password",
            user.getPassword()
        )
    }
}
package com.hloriot.pizzacrew.model

import com.hloriot.pizzacrew.model.interfaces.IIngredient
import com.hloriot.pizzacrew.model.interfaces.IUser

class User : IUser {
    override fun getName(): String {
        TODO("Not yet implemented")
    }

    override fun getPassword(): String {
        TODO("Not yet implemented")
    }

    /**
     * Factory object to create a User
     */
    object Factory {
        fun createUser(
            name: String,
            password: String
        ): IUser {
            TODO("Not yet implemented")
        }
    }
}
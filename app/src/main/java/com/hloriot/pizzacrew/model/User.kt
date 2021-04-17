package com.hloriot.pizzacrew.model

import com.hloriot.pizzacrew.model.interfaces.IIngredient
import com.hloriot.pizzacrew.model.interfaces.IUser

class User(private val name: String, private val password: String) : IUser {

    override fun getName(): String {
        return name
    }

    override fun getPassword(): String {
        return password
    }

    /**
     * Factory object to create a User
     */
    object Factory {
        fun createUser(
            name: String,
            password: String
        ): IUser {
            return User(name, password)
        }
    }
}
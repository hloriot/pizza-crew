package com.hloriot.pizzacrew.database

import android.content.SharedPreferences
import com.hloriot.pizzacrew.model.interfaces.IUser

class UserDatabase(private val sharedPreferences: SharedPreferences) {

    fun storeUser(user: IUser) {
        sharedPreferences
            .edit()
            .putString(user.getName(), user.getPassword())
            .apply()
    }

    fun hasUser(user: IUser): Boolean {
        return sharedPreferences.getString(user.getName(), null) == user.getPassword()
    }

    companion object {
        const val SHARED_PREFERENCES_NAME = "UserDatabase"
    }
}
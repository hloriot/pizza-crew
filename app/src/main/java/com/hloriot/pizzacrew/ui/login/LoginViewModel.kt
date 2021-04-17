package com.hloriot.pizzacrew.ui.login

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.hloriot.pizzacrew.database.UserDatabase
import com.hloriot.pizzacrew.model.interfaces.IIngredient
import com.hloriot.pizzacrew.model.interfaces.IPizza
import com.hloriot.pizzacrew.model.interfaces.IUser
import com.hloriot.pizzacrew.model.interfaces.PizzaDough
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single

class LoginViewModel(
    private val userDatabase: UserDatabase
) : ViewModel() {

    fun hasUser(user: IUser): Single<Boolean> {
        return userDatabase.hasUser(user).observeOn(AndroidSchedulers.mainThread())
    }

    class Factory(private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return LoginViewModel(
                UserDatabase(
                    context.getSharedPreferences(
                        UserDatabase.SHARED_PREFERENCES_NAME,
                        Context.MODE_PRIVATE
                    )
                )
            ) as T
        }
    }

}
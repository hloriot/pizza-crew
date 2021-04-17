package com.hloriot.pizzacrew.ui.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hloriot.pizzacrew.database.UserDatabase
import com.hloriot.pizzacrew.model.interfaces.IUser
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable

class CreateAccountViewModel(
    private val userDatabase: UserDatabase
) : ViewModel() {

    fun storeUser(user: IUser): Completable {
        return userDatabase.storeUser(user).observeOn(AndroidSchedulers.mainThread())
    }

    class Factory(private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CreateAccountViewModel(
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
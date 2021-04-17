package com.hloriot.pizzacrew.database

import android.content.SharedPreferences
import com.hloriot.pizzacrew.model.interfaces.IUser
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class UserDatabase(private val sharedPreferences: SharedPreferences) {

    fun storeUser(user: IUser): Completable {
        return Completable.create {
            sharedPreferences
                .edit()
                .putString(user.getName(), user.getPassword())
                .apply()
            it.onComplete()
        }
            .delay(1, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
    }

    fun hasUser(user: IUser): Single<Boolean> {
        return Single.create<Boolean> {
            it.onSuccess(sharedPreferences.getString(user.getName(), null) == user.getPassword())
        }
            .delay(1, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
    }

    companion object {
        const val SHARED_PREFERENCES_NAME = "UserDatabase"
    }
}
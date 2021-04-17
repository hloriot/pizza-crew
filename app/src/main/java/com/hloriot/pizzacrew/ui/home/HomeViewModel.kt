package com.hloriot.pizzacrew.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hloriot.pizzacrew.model.interfaces.IIngredient
import com.hloriot.pizzacrew.model.interfaces.IPizza
import com.hloriot.pizzacrew.model.interfaces.PizzaDough

class HomeViewModel : ViewModel() {

    private val ingredient1 = object : IIngredient {
        override fun getName(): String = "Mozzarella"
        override fun getEnergyInKCal(): Double = 302.0
        override fun getEnergyInKj(): Double = 1263.568
        override fun getFatInG(): Double = 22.0
        override fun getCarbohydrateInG(): Double = 1.0
        override fun getProteinInG(): Double = 25.0
        override fun getSaltInG(): Double = 1.4
        override fun compareTo(other: IIngredient): Int = getName().compareTo(other.getName())
    }

    private val ingredient2 = object : IIngredient {
        override fun getName(): String = "Goat cheese"
        override fun getEnergyInKCal(): Double = 309.0
        override fun getEnergyInKj(): Double = 1292.856
        override fun getFatInG(): Double = 25.0
        override fun getCarbohydrateInG(): Double = 1.0
        override fun getProteinInG(): Double = 20.0
        override fun getSaltInG(): Double = 1.8
        override fun compareTo(other: IIngredient): Int = getName().compareTo(other.getName())
    }

    private val pizza1 = object : IPizza{
        override fun getName(): String = "Calzone"
        override fun getPriceInEuro(): Double = 11.0
        override fun getPizzaDough(): PizzaDough = PizzaDough.THICK
        override fun getIngredients(): List<IIngredient> = listOf(ingredient1, ingredient2)
        override fun compareTo(other: IPizza): Int = getName().compareTo(other.getName())
    }

    private val _pizzaList = MutableLiveData<List<IPizza>>(listOf(pizza1, pizza1, pizza1, pizza1, pizza1, pizza1))
    val pizzaList: LiveData<List<IPizza>> = _pizzaList
}
package com.hloriot.pizzacrew.model.interfaces

interface IPizza : Comparable<IPizza> {
    fun getName(): String
    fun getPriceInEuro(): Double
    fun getPizzaDough(): PizzaDough
    fun getIngredients(): List<IIngredient>
}
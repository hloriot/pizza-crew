package com.hloriot.pizzacrew.model.interfaces

interface IIngredient : Comparable<IIngredient> {
    fun getName(): String
    fun getEnergyInKCal(): Double
    fun getEnergyInKj(): Double
    fun getFatInG(): Double
    fun getCarbohydrateInG(): Double
    fun getProteinInG(): Double
    fun getSaltInG(): Double
}
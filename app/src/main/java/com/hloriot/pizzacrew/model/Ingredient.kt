package com.hloriot.pizzacrew.model

import com.hloriot.pizzacrew.model.interfaces.IIngredient

class Ingredient : IIngredient {
    override fun getName(): String {
        TODO("Not yet implemented")
    }

    override fun getEnergyInKCal(): Double {
        TODO("Not yet implemented")
    }

    override fun getEnergyInKj(): Double {
        TODO("Not yet implemented")
    }

    override fun getFatInG(): Double {
        TODO("Not yet implemented")
    }

    override fun getCarbohydrateInG(): Double {
        TODO("Not yet implemented")
    }

    override fun getProteinInG(): Double {
        TODO("Not yet implemented")
    }

    override fun getSaltInG(): Double {
        TODO("Not yet implemented")
    }

    override fun compareTo(other: IIngredient): Int {
        TODO("Not yet implemented")
    }

    override fun equals(other: Any?): Boolean {
        TODO("Not yet implemented")
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    /**
     * Factory object to create an ingredient of a Pizza
     */
    object Factory {
        fun createIngredient(
            name: String,
            energyInKCal: Double,
            fatInG: Double,
            carbohydrateInG: Double,
            proteinInG: Double,
            saltInG: Double,
        ): IIngredient {
            TODO("Not yet implemented")
        }
    }
}
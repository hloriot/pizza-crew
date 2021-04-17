package com.hloriot.pizzacrew.model

import com.hloriot.pizzacrew.model.interfaces.IIngredient
import com.hloriot.pizzacrew.model.interfaces.IPizza
import com.hloriot.pizzacrew.model.interfaces.PizzaDough

class Pizza : IPizza {
    /**
     * Returns the name of the Pizza
     */
    override fun getName(): String {
        TODO("Not yet implemented")
    }

    /**
     * Returns the price of the Pizza
     */
    override fun getPriceInEuro(): Double {
        TODO("Not yet implemented")
    }

    /**
     * Returns the dough of the Pizza
     */
    override fun getPizzaDough(): PizzaDough {
        TODO("Not yet implemented")
    }

    /**
     * Returns the list of ingredients of the Pizza
     */
    override fun getIngredients(): List<IIngredient> {
        TODO("Not yet implemented")
    }

    override fun compareTo(other: IPizza): Int {
        TODO("Not yet implemented")
    }

    override fun equals(other: Any?): Boolean {
        TODO("Not yet implemented")
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    /**
     * Factory object to create Pizza
     */
    object Factory {
        fun createPizza(
            name: String,
            price: Double,
            dough: PizzaDough,
            ingredients: List<IIngredient>
        ): IPizza {
            TODO("Not yet implemented")
        }
    }
}
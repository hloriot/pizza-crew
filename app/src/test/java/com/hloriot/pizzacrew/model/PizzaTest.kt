package com.hloriot.pizzacrew.model

import com.hloriot.pizzacrew.model.interfaces.IIngredient
import com.hloriot.pizzacrew.model.interfaces.PizzaDough
import org.junit.Assert.assertEquals
import org.junit.Test

class PizzaTest {

    @Test
    fun createPizza_isCorrect() {
        val ingredient1: IIngredient = Ingredient.Factory.createIngredient(
            "mozzarella",
            302.0,
            22.0,
            1.0,
            25.0,
            1.4
        )
        val ingredient2: IIngredient = Ingredient.Factory.createIngredient(
            "goat cheese",
            309.0,
            25.0,
            1.0,
            20.0,
            1.8
        )
        val ingredients = listOf(ingredient1, ingredient2)
        val pizza = Pizza.Factory.createPizza(
            "Calzone",
            11.50,
            PizzaDough.THICK,
            ingredients
        )

        assertEquals("The name of the pizza is incorrect", "Calzone", pizza.getName())
        assertEquals("The price of the pizza is incorrect", 11.50, pizza.getPriceInEuro(), 0.01)
        assertEquals(PizzaDough.THICK, pizza.getPizzaDough())
        assertEquals(
            "The size of the ingredients doesn't match",
            "An ingredient was not found in the right place in this pizza",
            ingredients,
            pizza.getIngredients()
        )
    }

    private fun <T> assertEquals(
        messageForSize: String,
        messageForItem: String,
        expected: List<T>?,
        actual: List<T>?
    ) {
        assertEquals(messageForSize, expected?.size, actual?.size)
        if (expected == null || actual == null) {
            return
        }

        val iterator1 = expected.listIterator()
        val iterator2 = actual.listIterator()
        while (iterator1.hasNext()) {
            assertEquals(messageForItem, iterator1.next(), iterator2.next())
        }
    }
}
package com.hloriot.pizzacrew.model

import com.hloriot.pizzacrew.model.Ingredient
import com.hloriot.pizzacrew.model.interfaces.IIngredient
import org.junit.Assert
import org.junit.Test

class IngredientTest {
    @Test
    fun createIngredient_isCorrect() {
        val ingredient: IIngredient = Ingredient.Factory.createIngredient(
            "mozzarella",
            302.0,
            22.0,
            1.0,
            25.0,
            1.4
        )

        Assert.assertEquals(
            "The energy in kcal of the ingredient is incorrect",
            302.0,
            ingredient.getEnergyInKCal(),
            0.01
        )
        Assert.assertEquals(
            "The energy in kj of the ingredient is incorrect",
            1263.568,
            ingredient.getEnergyInKj(),
            0.01
        )
        Assert.assertEquals(
            "The fat in g of the ingredient is incorrect",
            22.0,
            ingredient.getFatInG(),
            0.01
        )
        Assert.assertEquals(
            "The carbohydrate in g of the ingredient is incorrect",
            1.0,
            ingredient.getCarbohydrateInG(),
            0.01
        )
        Assert.assertEquals(
            "The protein in g of the ingredient is incorrect",
            25.0,
            ingredient.getProteinInG(),
            0.01
        )
        Assert.assertEquals(
            "The salt in g of the ingredient is incorrect",
            1.4,
            ingredient.getSaltInG(),
            0.01
        )
    }
}
package com.nacer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientTest {
    private Ingredient ingredient;

    @BeforeEach
    void setUp() {
        System.out.println("Setting it up!");
        String text = "200g unsalted butter\n";

        this.ingredient = new Ingredient(text);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing down!");
        this.ingredient = null;
    }

    @Test
    void createIngredientObjectFromText() {
        assertEquals(ingredient.getItem(), "unsalted butter");
    }

    @Test
    void testUnit() {
        assertEquals(ingredient.getUnit(), "g");
    }

    @Test
    void testAmount() {
        assertEquals(ingredient.getAmount(), "200");
    }

    @Test
    void testItem() {
        assertEquals(ingredient.getItem(), "unsalted butter");
    }

    @Test
    void toXml() {
        assertEquals(ingredient.toXml(), "<Ingredient>\n" +
                "<Amount>200</Amount>\n" +
                "<Unit>g</Unit>\n" +
                "<Item>unsalted butter</Item>\n" +
                "</Ingredient>");
    }
}

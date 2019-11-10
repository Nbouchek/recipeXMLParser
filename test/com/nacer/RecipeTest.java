package com.nacer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipeTest {
    private Recipe recipe;

    @BeforeEach
    void setUp() {
        System.out.println("Setting it up!");
        String text = "2. Strawberry Cake by Nacer Bouchekhima [2019-11-10]\n" +
                "A delicious recipe for strawberry.\n" +
                "Ingredients:\n" +
                "200 unsalted butter\n" +
                "175g caster sugar\n" +
                "3 eggs\n" +
                "115g self-raising flour\n" +
                "1 fresh strawberry\n" +
                "\n" +
                "Method:\n" +
                "1. Preheat the oven to 180 degrees C.\n" +
                "2. Beat together butter and sugar.\n" +
                "3. Mix in eggs, ont at a time.\n" +
                "4. Sift in flour and add lemon zest.\n" +
                "5. Line loaf time with graseproof paper and spoon mixture in\n" +
                "6. Bake for 40-55 minutes.";
        this.recipe = new Recipe(text);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing down!");
        recipe = null;
    }

    @Test
    void createRecipeObjectFromText() {
        assertEquals(recipe.getId(), "2");
    }

    @Test
    void testMetaDataAuthor() {
        assertEquals(recipe.getMetaData().getAuthor(), "Nacer Bouchekhima");
    }

    @Test
    void testMetaDataCreated() {
        assertEquals(recipe.getMetaData().getCreated(), "2019-11-10");
    }

    @Test
    void testMetaDataTitle() {
        assertEquals(recipe.getMetaData().getTitle(), "Strawberry Cake");
    }

    @Test
    void testNumberOfIngredients() {
        assertEquals(recipe.getContent().getIngredients().size(), 5);
    }

    @Test
    void testNumberOfStepsInMethod() {
        assertEquals(recipe.getContent().getMethod().getSteps().size(), 6);
    }

    @Test
    void testFirstStepInMethod() {
        assertEquals(recipe.getContent().getMethod().getSteps().get(0), "Preheat the oven to 180 degrees C.");
    }


    @Test
    void toXml() {
        assertEquals(recipe.toXml(),"<Recipe id=\""+2+"\">\n" +
                "<Metadata>\n" +
                "<Created>2019-11-10</Created>\n" +
                "<Author>Nacer Bouchekhima</Author>\n" +
                "<Title>Strawberry Cake</Title>\n" +
                "</Metadata>\n" +
                "<Content>\n" +
                "<Lead>A delicious recipe for strawberry.</Lead>\n" +
                "<Ingredients>\n" +
                "<Ingredient>\n" +
                "<Amount>200</Amount>\n" +
                "<Item>unsalted butter</Item>\n" +
                "</Ingredient>\n" +
                "<Ingredient>\n" +
                "<Amount>175</Amount>\n" +
                "<Unit>g</Unit>\n" +
                "<Item>caster sugar</Item>\n" +
                "</Ingredient>\n" +
                "<Ingredient>\n" +
                "<Amount>3</Amount>\n" +
                "<Item>eggs</Item>\n" +
                "</Ingredient>\n" +
                "<Ingredient>\n" +
                "<Amount>115</Amount>\n" +
                "<Unit>g</Unit>\n" +
                "<Item>self-raising flour</Item>\n" +
                "</Ingredient>\n" +
                "<Ingredient>\n" +
                "<Amount>1</Amount>\n" +
                "<Item>fresh strawberry</Item>\n" +
                "</Ingredient>\n" +
                "</Ingredients>\n" +
                "<Method>\n" +
                "<Step>Preheat the oven to 180 degrees C.</Step>\n" +
                "<Step>Beat together butter and sugar.</Step>\n" +
                "<Step>Mix in eggs, ont at a time.</Step>\n" +
                "<Step>Sift in flour and add lemon zest.</Step>\n" +
                "<Step>Line loaf time with graseproof paper and spoon mixture in</Step>\n" +
                "<Step>Bake for 40-55 minutes.</Step>\n" +
                "</Method>\n" +
                "</Content>\n" +
                "</Recipe>\n");
    }
}

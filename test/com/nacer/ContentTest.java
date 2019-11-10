package com.nacer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContentTest {
    private Content content;

    @BeforeEach
    void setUp() {
        System.out.println("Setting it up!");
        String text = "2. Strawberry Cake by Nacer Bouchehhima [2019-11-10]\n" +
                "A delicious recipe for strawberry lovers.\n" +
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
        this.content = new Content(text);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing down!");
        this.content = null;
    }

    @Test
    void createContentObjectFromText() {
        assertEquals(content.getLead(), "A delicious recipe for strawberry lovers.");
    }

    @Test
    void testSizeOfIngredients() {
        assertEquals(content.getIngredients().size(), 5);
    }

    @Test
    void testIngredientAmount () {
        assertEquals(content.getIngredients().get(0).getAmount(), "200");
    }

    @Test
    void testIngredientUnit () {
        assertEquals(content.getIngredients().get(1).getUnit(), "g");
    }

    @Test
    void testIngredientItem () {
        assertEquals(content.getIngredients().get(2).getItem(), "eggs");
    }

    @Test
    void testMethodFirstStep () {
        assertEquals(content.getMethod().getSteps().get(0), "Preheat the oven to 180 degrees C.");
    }

    @Test
    void testNumberOfStepsInMethod () {
        assertEquals(content.getMethod().getSteps().size(), 6);
    }


    @Test
    void toXml() {
        assertEquals(content.toXml(), "<Content>\n" +
                "<Lead>A delicious recipe for strawberry lovers.</Lead>\n" +
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
                "</Content>\n");
    }
}

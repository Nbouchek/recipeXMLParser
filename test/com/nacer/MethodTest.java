package com.nacer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MethodTest {
    private Method method;

    @BeforeEach
    void setUp() {
        System.out.println("Setting it up!");
        String text = "1. Strawberry Cake by Nacer Bouchekhima [2019-11-10]\n" +
                "A delicious recipe for Strawberry cake lovers.\n" +
                "Ingredients:\n" +
                "100g unsalted butter\n" +
                "150g caster sugar\n" +
                "2 eggs\n" +
                "225g self-raising brown flour\n" +
                "1/2lb Fresh Strawberry\n" +
                "Method:\n" +
                "1. Preheat the oven to 180 degrees C.\n" +
                "2. Beat together butter and sugar.\n" +
                "3.             Mix in eggs, ont at a time.\n" +
                "4. Sift in flour and add Strawberry.\n" +
                "       Line loaf time with graseproof paper and spoon mixture in\n" +
                "6. Bake for 45-50 minutes.";
        this.method = new Method(text);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing down!");
        this.method = null;
    }

    @Test
    void createMethodObjectFromText() {
        assertEquals(method.getSteps().get(0), "Preheat the oven to 180 degrees C.");
    }

    @Test
    void testSizeOfMethodSteps() {
        assertEquals(method.getSteps().size(), 6);
    }

    @Test
    void testStepWithoutNumber() {
        assertEquals(method.getSteps().get(4), "Line loaf time with graseproof paper and spoon mixture in");
    }

    @Test
    void toXml() {
        assertEquals(method.toXml(),"<Method>\n" +
                "<Step>Preheat the oven to 180 degrees C.</Step>\n" +
                "<Step>Beat together butter and sugar.</Step>\n" +
                "<Step>Mix in eggs, ont at a time.</Step>\n" +
                "<Step>Sift in flour and add Strawberry.</Step>\n" +
                "<Step>Line loaf time with graseproof paper and spoon mixture in</Step>\n" +
                "<Step>Bake for 45-50 minutes.</Step>\n" +
                "</Method>\n");
    }
}

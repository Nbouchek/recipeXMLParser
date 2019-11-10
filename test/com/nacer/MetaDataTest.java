package com.nacer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MetaDataTest {

    private MetaData metaData;
    @BeforeEach
    void setUp() {
        System.out.println("Setting it up!");
        String text = "1. Strawberry Cake by Nacer Bouchekhima [2019-11-10]" +
                "A delicious recipe for Strawberry cake lovers." +
                "Ingredients:" +
                "100g unsalted butter" +
                "150g caster sugar" +
                "2 eggs" +
                "225g self-raising brown flour" +
                "1/2lb Fresh Strawberry" +
                "Method:" +
                "1. Preheat the oven to 180 degrees C." +
                "2. Beat together butter and sugar." +
                "3. Mix in eggs, ont at a time." +
                "4. Sift in flour and add Strawberry." +
                "5. Line loaf time with graseproof paper and spoon mixture in" +
                "6. Bake for 45-50 minutes.";
        this.metaData = new MetaData(text);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing down!");
        this.metaData = null;
    }

    @Test
    void createMetaDataObjectFromText() {
        assertEquals(metaData.getTitle(), "Strawberry Cake");
        assertEquals(metaData.getAuthor(), "Nacer Bouchekhima");
    }

    @Test
    public void testTitle() {
        assertEquals(metaData.getTitle(), "Strawberry Cake");
    }

    @Test
    public void testAuthor() {
        assertEquals(metaData.getAuthor(), "Nacer Bouchekhima");
    }

    @Test
    public void testCreated() {
        assertEquals(metaData.getCreated(), "2019-11-10");
    }


    @Test
    void toXml() {
        assertEquals(metaData.toXml(), "<Metadata>\n" +
                "<Created>2019-11-10</Created>\n" +
                "<Author>Nacer Bouchekhima</Author>\n" +
                "<Title>Strawberry Cake</Title>\n" +
                "</Metadata>\n");
    }
}

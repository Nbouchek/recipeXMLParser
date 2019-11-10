package com.nacer;

import java.util.ArrayList;
import java.util.List;

public class Content {
    private String lead;
    private List<Ingredient> ingredients;
    private Method method;

    private String text;

    public Content(String text) {
        this.text = text;
        createContentObjectFromText(text);
    }

    public String getLead() {
        return lead;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public void createContentObjectFromText(String text) {
        ingredients = new ArrayList<>();

        lead = text.substring(text.indexOf("]") + 2, text.indexOf("Ingredients") - 1);

        String[] ingredientsText = text.substring(text.indexOf("Ingredients") + 12, text.indexOf("Method")).trim().split("\n");
        for (String ingredientText : ingredientsText) {
            ingredients.add(new Ingredient(ingredientText));
        }

        method = new Method(text);
    }

    public String toXml() {
        String xml = "<Content>\n";

        // lead xml
        xml = xml + "<Lead>" + lead + "</Lead>\n";

        // ingredients xml
        xml = xml + "<Ingredients>\n";
        for (Ingredient ingredient : ingredients) {
            xml = xml + ingredient.toXml() + "\n";
        }
        xml = xml + "</Ingredients>\n";

        // Method xml
        xml = xml + method.toXml();

        return xml + "</Content>\n";
    }
}

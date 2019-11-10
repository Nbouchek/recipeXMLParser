package com.nacer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ingredient {
    private String amount;
    private String unit;
    private String item;
    private String text;

    public Ingredient() {
    }

    public Ingredient(String amount, String unit, String item) {
        this.amount = amount;
        this.unit = unit;
        this.item = item;
    }

    public Ingredient(String text) {
        this.text = text;
        createIngredientObjectFromText(text);
    }

    public String getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    public String getItem() {
        return item;
    }

    public void createIngredientObjectFromText(String text) {
        Pattern p = Pattern.compile("([\\d|½|1/2]+[½]*[\\-\\d]*[g,ml,oz,½]*[\\s]*(tsp)*(tbsp)*)");
        Matcher m = p.matcher(text);
        if (m.find()) {
            String amountUnit = m.group();
            p = Pattern.compile("[g,ml,oz,tsp,tbsp]+");
            m = p.matcher(amountUnit);

            int startIndex;
            int endIndex;

            if (m.find()) {
                this.unit = m.group().trim();
                this.amount = amountUnit.substring(0, amountUnit.indexOf(this.unit)).trim();
                startIndex = text.indexOf(amountUnit) + amountUnit.length();
                endIndex = text.length();
                this.item = text.substring(startIndex, endIndex).trim();
            } else {
                this.amount = text.substring(0, amountUnit.indexOf(" ")).trim();
                startIndex = text.indexOf(this.amount) + (this.amount).length();
                endIndex = text.length();
                this.item = text.substring(startIndex, endIndex).trim();
            }
        } else {
            this.item = text;
        }
    }

    public String toXml() {

        String xml = "<Ingredient>\n";
        if (amount != null) {
            xml = xml + "<Amount>" + amount + "</Amount>\n";
        }

        if (unit != null) {
            xml = xml + "<Unit>" + unit + "</Unit>\n";
        }
        return xml + "<Item>" + item + "</Item>\n" + "</Ingredient>";
    }
}

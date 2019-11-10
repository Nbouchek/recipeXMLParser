package com.nacer;

public class Recipe {
    private String id;
    private MetaData metaData;
    private Content content;

    private String text;

    public Recipe() {
    }

    public Recipe(String text) {
        this.text = text.trim();
        createRecipeObjectFromText(text);
    }

    public String getId() {
        return id;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public Content getContent() {
        return content;
    }

    public void createRecipeObjectFromText(String text) {
        metaData = new MetaData(text);
        id = text.substring(0, text.indexOf(".")).trim();
        content = new Content(text);
    }

    public String toXml() {
        // leading line
        String xml = "<Recipe id=\"" + id + "\">\n";

        // meta data xml
        xml = xml + this.metaData.toXml() + this.content.toXml();

        return xml + "</Recipe>\n";
    }
}

package com.nacer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MetaData {
    private String created;
    private String author;
    private String title;

    private String text;

    public MetaData(String text) {
        this.text = text;
        createMetaDataObjectFromText(text);
    }

    public String getCreated() {
        return created;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void createMetaDataObjectFromText(String text) {
        Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
        Matcher matcher = pattern.matcher(text);
        matcher.find();

        String created = matcher.group();
        this.created = created;

        String str = text.substring(text.indexOf(".") + 2, text.indexOf(created) - 1).trim();

        if (str.contains(" by ")) {
            this.title = str.substring(0, str.indexOf("by")).trim();
            this.author = str.substring(str.indexOf("by") + 3).trim();
        } else {
            this.title = str;
        }
    }

    public String toXml() {
        String xml = "<Metadata>\n" +
                "<Created>" + created + "</Created>\n";
        if (author == null)
            return xml + "<Title>" + title + "</Title>\n" +
                    "</Metadata>\n";
        else
            return xml + "<Author>" + author + "</Author>\n" +
                    "<Title>" + title + "</Title>\n" +
                    "</Metadata>\n";
    }
}

package com.nacer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Method {
    private List<String> steps;
    private String text;

    public Method() {
    }

    public Method(List<String> steps) {
        this.steps = steps;
    }

    public Method(String text) {
        String methodText = text.substring(text.indexOf("Method") + 7);
        this.text = methodText;
        createMethodObjectFromText(methodText);
    }

    public List<String> getSteps() {
        return steps;
    }

    public void createMethodObjectFromText(String text) {
        this.steps = new ArrayList<>();
        this.steps = Stream
                .of(text.trim().split("\n"))
                .map(s -> Character.isDigit(s.charAt(0)) ? s.substring(s.indexOf(".") + 2) : s)
                .map(s -> s.trim())
                .collect(Collectors.toList());
    }

    public String toXml() {
        String xml = "<Method>\n";
        for (String step : steps) {
            xml = xml + "<Step>" + step + "</Step>\n";
        }
        return xml + "</Method>\n";
    }
}

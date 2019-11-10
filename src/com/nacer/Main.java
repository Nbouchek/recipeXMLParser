package com.nacer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        try (Stream<Path> walk = Files.walk(Paths.get(args[0]))) {

            List<String> result = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());

            for (String pathToFile : result) {

                // read and process input
                StringBuffer stringBuffer = FileIO.read(pathToFile);
                String recipeText = stringBuffer.toString().trim();
                Recipe recipe = new Recipe(recipeText);

                // write output
                String titleStripped = recipe.getMetaData().getTitle().replaceAll("\\s", "_");
                String path = args[1] + "\\" + recipe.getId() + "_" + titleStripped + ".xml";
                FileIO.write(path, recipe.toXml(), 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

# xmlParser

This is a command line Java -OpenJDK 13- implementation for the recipe parsing task. JUnit 5 is used for unit testing.

It takes in two arguments:
  1.	A path to a directory of recipes to process.
  2.	A path to a directory to write the results out to.

And it generates a separate XML file for each recipe and stores them in the results' directory.

Unit tests are included in the test folder.

Included is a UML diagram, in uml and png formats, showing the application classes and  dependencies. See classDiagram.png / classDiagram.uml

## How to run this program
1. Ensure that your plain text recipes are valid and stored in a folder <input>
2. Build then from terminal change your working directory to the produced class file
3. Execute the following command:

`java Main <path-toinput-folder> <path-to-output-folder>`


## Assumptions:
- The provided arguments are always valid, hence no checks are performed.
- Each input file contains the details of a specific recipe.
- A recipe file consists of four sections:
    -	a line specifying the id, the title, the author and the date when the recipe was written. 
      These are stored in the metadata section of the generated xml file.

    -	a section that contains a brief description of the recipe, also known as "Lead".

    -	a section for the Ingredients, and

    -	a section for the Method

- The Lead, Ingredients and Method are stored in the Content section of the generated xml file.
- There could be one or more ingredients. 
- Each ingredient is described in one line.
- An ingredient consists of an amount, a unit and an item
- Some ingredients do not have an amount or a unit.   
- A Method has one or more steps.
- Each step is described in one line.
- A step does not necessarily start with a number and might start or end with one or multiple empty spaces.

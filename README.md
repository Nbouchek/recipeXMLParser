# xmlParser

This is a command line Java -OpenJDK 13- implementation for the recipe parsing task.

It takes in two arguments:
  1.	A path to a directory of recipes to process.
  2.	A path to a directory to write the results out to.
And it generates a separate XML file for each recipe.

Unit tests are included in the test folder.

Included is a UML diagram, in uml and png formats, showing the application classes and  dependencies. See classDiagram.png / classDiagram.uml

## How to run this program
1. Ensure that that you plain text recipes are valid and stored in a folder <input>
2. Build then from terminal change your working directory to the produced class file
3. Execute the following command:

`java Main <path-toinput-folder> <path-to-output-folder>`


## Assumptions:
1.	The provided arguments are always valid, hence no checks are performed.
2.	Each input file contains the details of a specific recipe:
3.	A recipe file consists of four sections:
  a.	a line specifying the id, the title, author and the date when the recipe was written. 
      These are stored in the metadata section of the generated xml file
  b.	a section that contains a brief description of the recipe: Lead.
  c.	a section for the Ingredients, and
  d.	a section for the Method
4.	The Lead, Ingredients and Method are stored in the Content section of the generated xml file.
5.	A recipe consists of one or more ingredients. 
6.	Each ingredient is described in one line.
7.	An ingredient consists of an amount, a unit and an item
8.	Some ingredients do not have an amount or a unit.   
9.	A Method has one or more steps.
10.	Each step is described in one line.
11.	A step does not necessarily start with a number.

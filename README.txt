===Lab 2: Graph Recursion===
Created by: Wesley Chan
IDE: Eclipse Neon
Java Version 8

==Description==
There are 8 .java files associated with this package.
There are 2 input.txt files associated with the package for testing purposes.
There are 2 sample output.txt files for reference.
The input and output files are located in the ..\Graph\ folder.

Javadoc is provided with the package and is located in ..\Graph\doc\
All class files are located in ..\Graph\src

The original .txt input file provided to the students is named PathsGraphInput.txt
The second input file is custom and used for testing purposes.


==How to Use==
The Driver file that contains the main() method is named GraphDriver.java.

The driver accepts 2 command line arguments.  
The first argument is the input data source filepath.
The second argument will be the name of the output source filepath.
These can be absolute file paths on the computer as long as the user as access to those directories.

If a user wishes to use their own data, please refer to the ==Input Data Format== section.

When the Driver has completed the analysis, the output file will be located the filepath specified by the second command line argument.

Sample Output has been generated from the input file PathsGraphInput.txt for reference.
The sample output file is called PathsGraphOutput.txt

Sample Output has been generated from the input file CustomPaths.txt for reference.
The sample output file is called CustomPathsOutput.txt


==Input Data Format==
The data format of the input text file must be as follows:

Number of Vertices in the Graph.
An Adjacency matrix of the Graph.

This can be repeated, but must follow the form above.
There can be no blank lines at the end of the input files.

Example:
2
0 1
1 0
3
1 0 1
0 0 0
1 1 1
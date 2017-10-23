package graph;

import java.io.IOException;

/**
 * GraphDriver is the class that runs the graph analysis. This class contains
 * the main() method.
 * 
 * @author Wesley Chan
 *
 */
public class GraphDriver {
	/**
	 * The main() method takes 2 command line arguments. The first argument is
	 * the input source filepath. The second argument is the output filepath.
	 * These filepaths should be absolute.
	 * 
	 * @param args
	 *            first argument is the input source txt file, the second
	 *            argument is the out source filepath
	 * @throws IOException
	 *             if the files cannot be found.
	 */
	public static void main(String[] args) throws IOException {

		// First Command line argument is the input source txt filepath.
		ReadFile sourceFile = new ReadFile(args[0]);

		// Second Command line argument is the output source filepath.
		WriteFile outputFile = new WriteFile(args[1]);

		// Slice up the input file to it's respect matrices
		MatrixParser matrixParser = new MatrixParser(sourceFile);

		// Run analysis for every matrix found in the input source file
		for (int i = 0; i < sourceFile.getNumMatrices(); i++) {
			// Create new graph from adjacency matrix
			Graph graph = new Graph(matrixParser.parse());

			// Analyze all possible paths in the graph
			for (int j = 0; j < graph.getNumVertex(); j++) {
				graph.traverse(j);
			}

			// Log the analysis
			GraphLog graphLog = new GraphLog(graph.getAdjMatrix(), graph.getPathList().toString(), outputFile);

			// Write the log data to the output file
			graphLog.write();
		}

		// Close the output file
		outputFile.closeFile();
		// Prompt user that the graphs have been analyzed.
		System.out.println("Graphs Analyzed");
	}

}

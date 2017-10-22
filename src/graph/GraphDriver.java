package graph;

import java.io.IOException;

public class GraphDriver {
	public static void main(String[] args) throws IOException {

		// First Command line argument is the input source txt file.
		ReadFile sourceFile = new ReadFile(args[0]);

		// Second Command line argument is the output source filename.
		WriteFile outputFile = new WriteFile(args[1]);

		MatrixParser matrixParser = new MatrixParser(sourceFile);

		for (int i = 0; i < sourceFile.getNumMatrices(); i++) {
			Graph graph = new Graph(matrixParser.parse());
			for (int j = 0; j < graph.getNumVertex(); j++) {
				graph.traverse(j);				
			}
			GraphLog graphLog = new GraphLog(graph.getAdjMatrix(), graph.getPathList().toString(), outputFile);
			graphLog.write();
		}
		
		outputFile.closeFile();
		System.out.println("Graphs Analyzed");
	}

}

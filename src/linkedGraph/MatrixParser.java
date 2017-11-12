package linkedGraph;

/**
 * This class is responsible for separating the different matrices in the input
 * source file.
 * 
 * @author Wesley Chan
 *
 */
public class MatrixParser {
	private static int currentLine;
	private ReadFile file;

	/**
	 * Constructor for the MatrixParser class with one argument of type ReadFile
	 * 
	 * @param sourceFile
	 *            input source file
	 */
	MatrixParser(ReadFile sourceFile) {
		currentLine = 0;
		file = sourceFile;
	}

	/**
	 * This method creates an adjacency list based on the source file data.
	 * 
	 * @return An adjacency list of type PathList<PathList<Integer>> that represents
	 *         adjacency matrix found in the input source file.
	 */
	public PathList<Integer>[] parse() {

		int listSize = Integer.parseInt(file.getFileLines()[currentLine]);

		@SuppressWarnings("unchecked")
		PathList<Integer>[] adjList = new PathList[listSize];

		for (int i = currentLine + 1; i < currentLine + listSize; i++) {
			for (int row = 0; row < listSize; row++) {
				String[] tempArr = file.getFileLines()[i + row].split("\\s+");

				// Each row in the Adjacency List will be an array of linked lists
				PathList<Integer> pathNodeList = new PathList<Integer>();
				
				// This loop creates the list of nodes
				for (int col = 0; col < tempArr.length; col++) {
					if (tempArr[col].equals("1")) {
						// If there is an edge, add as next node
						pathNodeList.append(col);
					}
				}
				// Add list of nodes to the Adjacency List
				adjList[row] = pathNodeList;
			}
			i = i + listSize;
		}

		currentLine = currentLine + listSize + 1;

		return adjList;

	}

	/*	*//**
			 * This method creates an adjacency matrix based on the source file data
			 * 
			 * @return a 2D boolean array that represents an adjacency matrix found in the
			 *         input source file.
			 *//*
				 * public boolean[][] parse() { int matrixSize =
				 * Integer.parseInt(file.getFileLines()[currentLine]); boolean[][] matrix = new
				 * boolean[matrixSize][matrixSize];
				 * 
				 * for (int i = currentLine + 1; i < currentLine + matrixSize + 1; i++) { for
				 * (int row = 0; row < matrix.length; row++) { String[] tempArr =
				 * file.getFileLines()[i + row].split("\\s+"); for (int col = 0; col <
				 * tempArr.length; col++) { matrix[row][col] = Integer.parseInt(tempArr[col]) !=
				 * 0; } } i = i + matrixSize; } currentLine = currentLine + matrixSize + 1;
				 * 
				 * return matrix; }
				 */

}

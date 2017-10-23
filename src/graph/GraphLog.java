package graph;

import java.io.IOException;

/**
 * This Log class is responsible for formatting the graph analysis data and
 * streaming it to the output file. Output file formatting is all controlled
 * here and can be changed with this class if needed.
 * 
 * @author Wesley Chan
 *
 */
public class GraphLog {
	private boolean[][] adjMatrix;
	private String paths;
	private WriteFile outputFile;
	private int[][] rawHeaders;
	private String[] headers;
	private static int counter = 1;

	/**
	 * Constructor for the GraphLog class that accepts 3 arguments.
	 * 
	 * @param adjMatrix
	 *            is a 2D boolean array of the adjacency matrix that was used to
	 *            create a Directed Graph data structure
	 * @param paths
	 *            is a String all possible paths from the analyzed graph
	 * @param outputFile
	 *            is the output file
	 */
	GraphLog(boolean[][] adjMatrix, String paths, WriteFile outputFile) {
		this.adjMatrix = adjMatrix;
		this.paths = paths;
		this.outputFile = outputFile;
		headers = new String[adjMatrix.length * adjMatrix.length];
		createRawHeaders();
		createHeaders();
	}

	/**
	 * Formats all the analyzed data and streams the data to the output file.
	 * Adds line breaks and horizontal rules for readability.
	 * 
	 * @throws IOException
	 *             if output file cannot be found.
	 */
	public void write() throws IOException {
		StringBuffer log = new StringBuffer();

		// Echo Adjacency Matrix
		log.append(horizontalRule());
		log.append("Matrix " + counter + "\r\n");
		counter++;
		log.append(horizontalRule());
		log.append(matrixToString());
		log.append(horizontalRule());
		// List possible pathways
		for (int row = 0; row < headers.length; row++) {
			log.append(headers[row]);
			// for (int vertices = 0; vertices < adjMatrix.length; vertices++) {
			log.append(linearSearch(Integer.toString(rawHeaders[row][0]), Integer.toString(rawHeaders[row][1])));
			// }
			log.append(horizontalRule());
		}
		log.append("\r\n");
		outputFile.writeToFile(log.toString());
	}

	/**
	 * Linear search through the entire path list and selects the paths with the
	 * corresponding start and end vertices. This search has a time complexity
	 * of O(n).
	 * 
	 * @param startVertex
	 *            Start of path
	 * @param endVertex
	 *            End of path
	 * @return Path with the matching start and end vertex, No Paths Found
	 *         otherwise.
	 */
	private String linearSearch(String startVertex, String endVertex) {
		// Split the paths string into its respective lines.
		StringBuffer sb = new StringBuffer();

		boolean pathFound = false;
		// split paths by new line and trim
		String[] splitPaths = paths.split("\\s*\\r?\\r\n\\s*");
		for (String s : splitPaths) {
			if (s.startsWith(startVertex) && s.endsWith(endVertex)) {
				sb.append(s).append("\r\n");
				pathFound = true;
			}
		}

		if (!pathFound) {
			sb.append("No Paths Found.\r\n");
		}

		return sb.toString();

	}

	/*
	 * Creates a horizontal rule
	 */
	private String horizontalRule() {
		return "------------------------------------\r\n";
	}

	/**
	 * Converts the 2D boolean adjacency matrix to a String for streaming.
	 * 
	 * @return String of the adjacency matrix.
	 */
	private String matrixToString() {
		StringBuffer sb = new StringBuffer();

		for (int row = 0; row < adjMatrix.length; row++) {
			for (int col = 0; col < adjMatrix[row].length; col++) {
				if (adjMatrix[row][col]) {
					sb.append("1").append(" ");
				} else {
					sb.append("0").append(" ");
				}
			}
			sb.append("\r\n");
		}

		return sb.toString();
	}

	/**
	 * Creates the headers for the possible paths in the graph
	 */
	private void createHeaders() {
		String template = "Path(s) From %d to %d: \r\n";

		for (int row = 0; row < rawHeaders.length; row++) {
			headers[row] = String.format(template, rawHeaders[row][0], rawHeaders[row][1]);
		}
	}

	/**
	 * Contains all possible node combinations in the graph, regardless of
	 * whether or not there are paths connecting the node.
	 */
	private void createRawHeaders() {
		int numHeaders = adjMatrix.length;

		int n = numHeaders * numHeaders;
		rawHeaders = new int[n][2];
		int rawRow = 0;

		for (int row = 0; row < numHeaders; row++) {
			for (int col = 0; col < numHeaders; col++) {
				rawHeaders[rawRow][0] = row;
				rawHeaders[rawRow][1] = col;
				rawRow++;
			}
		}
	}

}

package graph;

import java.io.IOException;

public class GraphLog {
	private boolean[][] adjMatrix;
	private String paths;
	private WriteFile outputFile;
	private int[][] rawHeaders;
	private String[] headers;

	GraphLog(boolean[][] adjMatrix, String paths, WriteFile outputFile) {
		this.adjMatrix = adjMatrix;
		this.paths = paths;
		this.outputFile = outputFile;
		headers = new String[adjMatrix.length * adjMatrix.length];
		createRawHeaders();
		createHeaders();
	}

	public void write() throws IOException {
		StringBuffer log = new StringBuffer();

		// Echo Adjacency Matrix
		log.append(matrixToString());
		log.append(horizontalRule());
		// List possible pathways
		for (int row = 0; row < headers.length; row++) {
			log.append(headers[row]);
			for (int vertices = 0; vertices < adjMatrix.length; vertices++, row++) {
				log.append(linearSearch(Integer.toString(rawHeaders[vertices + row][0]),
						Integer.toString(rawHeaders[vertices + row][1])));
			}
			log.append(horizontalRule());
			log.append(horizontalRule());
		}

		outputFile.writeToFile(paths);
	}

	/**
	 * Linear search through the entire path list and selects the paths with the
	 * corresponding start and end vertices. This search has a time complexity of
	 * O(n).
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
		String[] splitPaths = paths.split("\\s*\\r?\\n\\s*");
		for (String s : splitPaths) {
			if (s.startsWith(startVertex) && s.endsWith(endVertex)) {
				sb.append(s).append("\n");
				pathFound = true;
			}
		}

		if (!pathFound) {
			sb.append("No Paths Found.");
		}

		return sb.toString();

	}

	private String horizontalRule() {
		return "------------------------------------";
	}

	private String matrixToString() {
		StringBuffer sb = new StringBuffer();

		for (int row = 0; row < adjMatrix.length; row++) {
			for (int col = 0; col < adjMatrix[row].length; col++) {
				sb.append(adjMatrix[row][col]).append(" ");
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	private void createHeaders() {
		String template = "Path From %d to %d";

		for (int row = 0; row < rawHeaders.length; row++) {
			headers[row] = String.format(template, rawHeaders[row][0], rawHeaders[row][1]);
		}
	}

	private void createRawHeaders() {
		int numHeaders = 4;

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

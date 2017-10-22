package graph;

import java.io.IOException;
import java.util.Arrays;

public class GraphLog {
	private boolean[][] adjMatrix;
	private String paths;
	private WriteFile outputFile;
	private int[][] rawHeaders;
	public String[] headers;

	GraphLog(boolean[][] adjMatrix, String paths, WriteFile outputFile) {
		this.adjMatrix = adjMatrix;
		this.paths = paths;
		this.outputFile = outputFile;
		headers = new String[16];
	}

	public void write() throws IOException {
		StringBuffer log = new StringBuffer();

		log.append(matrixToString());

		outputFile.writeToFile(paths);
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
	
	public String[] createHeaders() {
		String template = "Path From %d to %d";
	
		
		for (int row = 0; row < rawHeaders.length; row++) {
			headers[row] = String.format(template, rawHeaders[row][0], rawHeaders[row][1]);
		}
		return headers;
	}

	public int[][] createRawHeaders() {
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
		return rawHeaders;
	}
}

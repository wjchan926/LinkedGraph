package graph;

public class MatrixParser {
	private static int currentLine;
	private ReadFile file;

	MatrixParser(ReadFile sourceFile) {
		currentLine = 0;
		file = sourceFile;
	}
	
	public boolean[][] parse() {
		int matrixSize = Integer.parseInt(file.getFileLines()[currentLine]);
		boolean[][] matrix = new boolean[matrixSize][matrixSize];

		for (int i = currentLine + 1; i < currentLine + matrixSize + 1; i++) {
			for (int row = 0; row < matrix.length; row++) {
				String[] tempArr = file.getFileLines()[i+row].split("\\s+");
				for (int col = 0; col < tempArr.length; col++) {
					matrix[row][col] = Integer.parseInt(tempArr[col]) != 0;
				}
			}
			i = i + matrixSize;
		}
		currentLine = currentLine + matrixSize + 1;
		
		return matrix;
	}

}

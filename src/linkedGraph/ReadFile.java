package linkedGraph;

import java.io.*;

/**
 * This class reads the input data for the Graph adjacency matrices. There are
 * no Graph functions or calculations found in this class. This class is solely
 * used for read/write purposes. It will also keep track of the number of
 * matrices in the input file.
 * 
 * @author Wesley Chan
 *
 */
public class ReadFile {

	private File f;
	private String[] fileLines;
	private int numMatrices;

	/**
	 * Constructor with filepath as an argument
	 * 
	 * @param fileName
	 *            filepath of input source
	 * @throws IOException
	 *             throws exception if it cannot find the file
	 */
	public ReadFile(String fileName) throws IOException {
		f = new File(fileName);
		fileLines = new String[countLines() + 1];
		readFromFile();
		calcNumMatrices();
	}

	/**
	 * Gets the file being read
	 * 
	 * @return f file
	 */
	public File getFile() {
		return f;
	}

	/**
	 * Gets the fileLines array
	 * 
	 * @return fileLines array
	 */
	public String[] getFileLines() {
		return fileLines;
	}

	/**
	 * Gets the number of matrices found in the source file
	 * 
	 * @return number of matrices in source file
	 */
	public int getNumMatrices() {
		return numMatrices;
	}

	/**
	 * Reads the file line by line and stores each in an index of the fileLines
	 * array.
	 * 
	 * @throws IOException
	 *             throws exception if it cannot find the file
	 */
	private void readFromFile() throws IOException {

		FileReader fr = new FileReader(f);
		BufferedReader input = new BufferedReader(fr);

		for (int i = 0; i < fileLines.length; i++) {
			fileLines[i] = input.readLine();
		}
		input.close();

	}

	/**
	 * Calculates the number of matrices in the input source file. This method
	 * mutates the numMatrices class variable.
	 */
	private void calcNumMatrices() {
		int size = Integer.parseInt(fileLines[0]);
		numMatrices++;

		for (int i = size + 1; i < fileLines.length; i = i + size + 1) {
			numMatrices++;
			size = Integer.parseInt(fileLines[i]);
		}
	}

	/**
	 * Method that counts the number of lines in the data source file. It
	 * utilizes a buffered binary read.
	 * 
	 * @return count the number of lines in file
	 * @throws IOException
	 *             if the file f cannot be found
	 */
	private int countLines() throws IOException {

		InputStream inputFile = new BufferedInputStream(new FileInputStream(f.getAbsolutePath()));

		try {
			byte[] c = new byte[1024];
			int count = 0;
			int readChars = 0;

			// Loop until end of stream
			while ((readChars = inputFile.read(c)) != -1) {
				// Read characters until return sequence is read
				for (int i = 0; i < readChars; i++) {
					// Search for number of line returns "\n"
					if (c[i] == '\n') {
						// Increment count for every line return read
						count++;
					}
				}
			}
			return count;
		} finally {
			// Close out InputStream
			inputFile.close();
		}
	}
}
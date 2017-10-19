
public class Graph {

	private int numVertex;
	private boolean[][] adjMatrix;
	private PathStack<Integer> pathStack;
	private boolean[] visitedVertex;

	/**
	 * Default constructor for Graph class.
	 * 
	 * @param i
	 *            Number of Vertices or Nodes in the graph
	 */
	Graph(int i) {
		numVertex = i;
		adjMatrix = new boolean[numVertex][numVertex];
		pathStack = new PathStack<Integer>();
		visitedVertex = new boolean[numVertex];
	}

	public void traverse(int startVertex, int endVertex) {
		// DFS, Must be Recursive

		pathStack.push(startVertex);
		visitedVertex[startVertex] = true;

		if (startVertex == endVertex) {
			// Log path
		} else {
			
			// Iterate through vertexes to see if there are paths
/*			for () {
				if (visitedVertex[i] == false) {
					traverse(i, endVertex);
				}
			}*/

			pathStack.pop();
			visitedVertex[startVertex] = false;

		}

	}

	private boolean hasEdge(int i, int j) {
		return adjMatrix[i][j];
	}

}

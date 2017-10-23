package graph;

/**
 * This is a custom graph class that creates a Directed Graph data structure
 * from an adjacency matrix representation.
 * 
 * @author Wesley Chan
 *
 */
public class Graph {

	private int numVertex;
	private boolean[][] adjMatrix;
	private PathStack<Integer> pathStack;
	private PathList<PathList<Integer>> pathList;
	private boolean[] visitedVertex;

	/**
	 * Constructor for the graph class that takes 1 argument of type
	 * boolean[][].
	 * 
	 * @param matrix
	 *            is the adjacency matrix representation of the graph.
	 */
	Graph(boolean[][] matrix) {
		numVertex = matrix.length;
		adjMatrix = matrix;
		pathStack = new PathStack<Integer>();
		visitedVertex = new boolean[numVertex];
		pathList = new PathList<PathList<Integer>>();
	}

	/**
	 * Returns the list of all possible paths
	 * 
	 * @return the list of all possible paths
	 */
	public PathList<PathList<Integer>> getPathList() {
		return pathList;
	}

	/**
	 * Returns the number of vertices in the graph
	 * 
	 * @return number of vertices in the graph
	 */
	public int getNumVertex() {
		return numVertex;
	}

	/**
	 * Returns the adjacency matrix of which the graph was constructed
	 * 
	 * @return adjacency matrix representation of the graph as a 2D boolean
	 *         array
	 */
	public boolean[][] getAdjMatrix() {
		return adjMatrix;
	}

	/**
	 * This Overloaded method is for ease of use for the user. It only takes 1
	 * parameter and will call a private traverse() method. It will perform a
	 * depth-first search of the graph beginning with vertex i.
	 * 
	 * @param i
	 *            starting vertex. This should always be the first vertex of the
	 *            adjacency matrix
	 */
	public void traverse(int i) {
		PathList<Integer> path = new PathList<Integer>();
		path.append(i);
		traverse(i, path, i);
	}

	/**
	 * This Overloaded private method Recursively traverses the graph and
	 * performs a depth-first search. It keeps track of all possible paths from
	 * 1 vertex to another in the graph. Utilizes a stack to keep track of the
	 * visiting nodes. This algorithm also handles disjointed graphs.
	 * 
	 * @param vertex
	 *            start vertex
	 * @param path
	 *            the currently traversing path
	 * @param current
	 *            the initial start vertex
	 */
	private void traverse(int vertex, PathList<Integer> path, int current) {
		// DFS, Must be Recursive

		pathStack.push(vertex);
		visitedVertex[vertex] = true;

		for (int i = 0; i < numVertex; i++) {
			// Case for if the node has a path to itself
			if (i == current && adjMatrix[vertex][i]) {
				visitedCode(path, i);
				path.removeLast();
				continue; // Must force loop to continue for this case
			}
			if (adjMatrix[vertex][i] && !visitedVertex[i]) {
				visitedCode(path, i);
				// Recursive call
				traverse(i, path, current);
			}
		}

		pathStack.pop();
		path.removeLast();
		visitedVertex[vertex] = false;

	}

	/**
	 * This method is only used by the private traverse() method. When a node a
	 * visited, this method updates the list of possible paths.
	 * 
	 * @param path
	 *            currently traversing path
	 * @param visiting
	 *            current vertex that is being visited
	 */
	private void visitedCode(PathList<Integer> path, int visiting) {
		PathList<Integer> tempPath = new PathList<Integer>();
		path.append(visiting);
		// A copy of the path must be made be made because Java uses pass by
		// reference
		tempPath = path.copy();
		pathList.append(tempPath);
	}

}

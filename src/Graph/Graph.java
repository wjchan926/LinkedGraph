package Graph;

public class Graph {

	private int numVertex;
	private boolean[][] adjMatrix;
	private PathStack<Integer> pathStack;
	private PathList<PathList> pathList;
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
		pathList = new PathList<PathList>();
	}

	public void traverse(int vertex, PathList<Integer> path) {
		// DFS, Must be Recursive
		/*
		 * 1. Push Vertex to stack 2. Mark as visited 3. Check for adjacent Vertices 4.
		 * If there are none, pop from stack 5. Move to next adjacent vertex
		 */

		pathStack.push(vertex);
		visitedVertex[vertex] = true;

		for (int i = 0; i < numVertex; i++) {			
			if (adjMatrix[vertex][i] && !visitedVertex[i]) {
				PathList<Integer> tempPath = new PathList<Integer>();
				tempPath = path;
				tempPath.append(i);
				pathList.append(tempPath);
				path = tempPath;
				traverse(i, path);
			}
		}

		pathStack.pop();
		path.removeLast();
		visitedVertex[vertex] = false;

	}

	private boolean hasEdge(int i, int j) {
		return adjMatrix[i][j];
	}
}

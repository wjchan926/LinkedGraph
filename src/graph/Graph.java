package graph;

public class Graph {

	private int numVertex;
	private boolean[][] adjMatrix;
	private PathStack<Integer> pathStack;
	private PathList<PathList<Integer>> pathList;
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
		pathList = new PathList<PathList<Integer>>();
	}

	public void traverse(int vertex, PathList<Integer> path, int current) {
		// DFS, Must be Recursive
		/*
		 * 1. Push Vertex to stack 2. Mark as visited 3. Check for adjacent Vertices 4.
		 * If there are none, pop from stack 5. Move to next adjacent vertex
		 */
		
		pathStack.push(vertex);
		visitedVertex[vertex] = true;

		for (int i = 0; i < numVertex; i++) {		
			if (vertex == current) {
				visitedCode(path, i);
				path.removeLast();
				continue;
			}
			if (adjMatrix[vertex][i] && !visitedVertex[i]) {
				visitedCode(path, i);
				traverse(i, path, current);
			}
		}

		pathStack.pop();
		path.removeLast();
		visitedVertex[vertex] = false;

	}
	
	private void visitedCode(PathList<Integer> path, int visiting) {
		PathList<Integer> tempPath = new PathList<Integer>();
		tempPath = path;
		tempPath.append(visiting);
		pathList.append(tempPath);
	}

	private boolean hasEdge(int i, int j) {
		return adjMatrix[i][j];
	}
}

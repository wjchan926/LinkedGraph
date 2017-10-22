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
	Graph(boolean[][] matrix) {
		numVertex = matrix.length;
		adjMatrix = matrix;
		pathStack = new PathStack<Integer>();
		visitedVertex = new boolean[numVertex];
		pathList = new PathList<PathList<Integer>>();
		// adjMatrix = new boolean[][] { { false, true, true, false }, { true, true,
		// true, true },
		// { true, false, false, false }, { true, false, false, true } };
		// adjMatrix = new boolean[][] {{false, true},{false, false}};
	}

	public PathList<PathList<Integer>> getPathList() {
		return pathList;
	}

	public int getNumVertex() {
		return numVertex;
	}
	
	public boolean[][] getAdjMatrix(){
		return adjMatrix;
	}
	public void traverse(int i) {
		PathList<Integer> path = new PathList<Integer>();
		path.append(i);
		traverse(i, path, i);
	}

	private void traverse(int vertex, PathList<Integer> path, int current) {
		// DFS, Must be Recursive

		pathStack.push(vertex);
		visitedVertex[vertex] = true;

		for (int i = 0; i < numVertex; i++) {
			if (i == current && adjMatrix[vertex][i]) {
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
		path.append(visiting);
		tempPath = path.copy();
		pathList.append(tempPath);
	}

}

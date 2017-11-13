package linkedGraph;

/**
 * This is a custom graph class that creates a Directed Graph data structure. It
 * will store the information as an adjacency list.
 * 
 * @author Wesley Chan
 *
 */
public class LinkedGraph {

	private int numVertex;
	private PathList<Integer>[] adjList;
	private PathList<PathList<Integer>> pathList;
	private boolean[] visitedVertex;

	/**
	 * Constructor for the graph class that takes 1 argument of type PathList[].
	 * 
	 * @param list
	 *            is the adjacency list representation of the graph.
	 */
	LinkedGraph(PathList<Integer>[] list) {
		numVertex = list.length;
		visitedVertex = new boolean[numVertex];
		adjList = list;
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
	 * Returns the adjacency list representation of the graph
	 * 
	 * @return adjacency list representation of the graph
	 */
	public PathList<Integer>[] getAdjList() {
		return adjList;
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
	 * This Overloaded method is for ease of use for the user. It only takes 1
	 * parameter and will call a private traverse() method. It will perform a
	 * depth-first search of the graph beginning with vertex i.
	 * 
	 * @param i
	 *            starting vertex. This should always be the first vertex of the
	 *            adjacency list
	 */
	public void traverse(int i) {
		PathList<Integer> path = new PathList<Integer>();
		path.append(i);
		// Custom cases graphs with a link to itself and completely disjointed
		// graphs
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
		// DFS Recursive
		visitedVertex[vertex] = true;

		Node<Integer> currentNode = new Node<Integer>();

		currentNode = adjList[vertex].getHead();

		while (currentNode != null) {
			if (currentNode.getData() == current) {
				visitedCode(path, currentNode.getData());
				path.removeLast();
			}
			if (!visitedVertex[currentNode.getData()]) {
				visitedCode(path, currentNode.getData());
				traverse(currentNode.getData(), path, current);
			}
			currentNode = currentNode.getNext();
		}

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

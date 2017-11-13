package linkedGraph;

/**
 * This is a custom graph class that creates a Directed Graph data structure
 * from an adjacency list representation. It will store the information as an
 * adjacency list.
 * 
 * @author Wesley Chan
 *
 */
public class LinkedGraph {

	private int numVertex;
	private PathList<Integer>[] adjList;
	private PathList<PathList<Integer>> pathList;
	private PathList<Integer> path;
	//private boolean[] visitedVertex;


	/**
	 * Constructor for the graph class that takes 1 argument of type PathList<PathList<Integer>>.
	 * 
	 * @param list
	 *            is the adjacency list representation of the graph.
	 */
	LinkedGraph(PathList<Integer>[] list) {
		numVertex = list.length;
	//	visitedVertex = new boolean[numVertex];
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

	public PathList<Integer>[] getAdjList(){
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
	 *            adjacency matrix
	 */
	public void traverse(int i) {
		traverse(i, i);
	}

	/**
	 * This Overloaded private method Recursively traverses the graph and performs a
	 * depth-first search. It keeps track of all possible paths from 1 vertex to
	 * another in the graph. Utilizes a stack to keep track of the visiting nodes.
	 * This algorithm also handles disjointed graphs.
	 * 
	 * @param vertex
	 *            start vertex
	 * @param path
	 *            the currently traversing path
	 * @param current
	 *            the initial start vertex
	 */
	private void traverse(int i, int current) {
		// DFS, Iterative
		boolean[] visitedVertex = new boolean[adjList.length];
		
		PathStack<Integer> pathStack = new PathStack<Integer>();
		path = new PathList<Integer>();
		
		pathStack.push(i);		
		
		while (!pathStack.isEmpty()) {			
			int vertex = pathStack.pop();
									
			if (!visitedVertex[vertex]) {			
								
				visitedCode(path, vertex);				
				visitedVertex[vertex] = true;
				
				PathStack<Integer> adjPathStack = new PathStack<Integer>();
				Node<Integer> currentNode = new Node<Integer>();
				currentNode = adjList[vertex].getHead();
				
				// Add adjacent vertices
				while(currentNode != null) {
					// Self Cycle case
					if (currentNode.getData() == i) {
						visitedCode(path, currentNode.getData());
						path.removeLast();
					}
										
					if (!visitedVertex[currentNode.getData()]) {
						adjPathStack.push(currentNode.getData());
					}
					currentNode = currentNode.getNext();
				}
				
				if (adjPathStack.isEmpty()) {
					path.removeLast();					
					visitedVertex[vertex] = false;
				}				
				
				while(!adjPathStack.isEmpty()) {
					pathStack.push(adjPathStack.pop());
				}
			}
			
		}				
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
		
		
		if (tempPath.getSize() != 1) {
			pathList.append(tempPath);
		}
	}

}

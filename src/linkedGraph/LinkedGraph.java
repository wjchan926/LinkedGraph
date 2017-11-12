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
	//private boolean[] visitedVertex;
	private PathStack<Integer> pathStack;

	/**
	 * Constructor for the graph class that takes 1 argument of type PathList<PathList<Integer>>.
	 * 
	 * @param list
	 *            is the adjacency list representation of the graph.
	 */
	LinkedGraph(PathList<Integer>[] list) {
		numVertex = list.length;
//		visitedVertex = new boolean[numVertex];
		adjList = list;
		pathStack = new PathStack<Integer>();
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
		PathList<Integer> path = new PathList<Integer>();
		path.append(i);		
		pathStack.push(i);
		adjList[i].getHead().setVisited(true);
		traverse(adjList[i].getHead(), path, i);
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
	private void traverse(Node<Integer> currentVertex, PathList<Integer> path, int current) {
		// DFS, Recursive
		
		pathStack.push(currentVertex.getData());		
		
		while (currentVertex != null) {
			
			if (!currentVertex.getVisited()) {
			//	System.out.println("MileA");
				visitedCode(path, currentVertex.getData());	
				
				currentVertex.setVisited(true);
								
				traverse(adjList[currentVertex.getData()].getHead(), path, current);
			}
				
			if (currentVertex.getNext() == null) {
				currentVertex.setVisited(false);
			}
				
				currentVertex = currentVertex.getNext();
			
		}
		
/*
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

		}*/
		
		pathStack.pop();
		path.removeLast();
	//	visitedVertex[currentVertex.getData()] = false;
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

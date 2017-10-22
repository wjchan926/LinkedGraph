package graph;

import static org.junit.Assert.*;

import org.junit.Test;

public class GraphTest {

	@Test
	public void testTraverse() {
		Graph graph = new Graph(2);
		PathList<Integer> pathList = new PathList<Integer>();
		pathList.append(0);
		
		graph.traverse(0, pathList, 0);
				
		String expected = "0 -> 1";
		String output = graph.getPathList().toString();
		
		System.out.println(pathList.getSize());
		
		assertEquals(expected, output);
	}

}

package graph;

import static org.junit.Assert.*;

import org.junit.Test;

public class PathListTest {
	@Test
	public void testAppend() {
		PathList<Integer> vertList = new PathList<Integer>();
		
		vertList.append(1);
		
		int expected = 1;
		
		int output = vertList.getSize();
		
		assertEquals(expected,output);
	}


	@Test
	public void testToString() {
		PathList<Integer> vertList = new PathList<Integer>();
		
		vertList.append(1);
		vertList.append(2);
		vertList.append(3);
		
		String expected = "1 -> 2 -> 3";
		
		String output = vertList.toString();
		
		assertEquals(expected,output);
	}
	
	@Test
	public void testToStringNested() {
		PathList<PathList<Integer>> pathList = new PathList<PathList<Integer>>();
		PathList<Integer> vertList = new PathList<Integer>();
		PathList<Integer> vertList2 = new PathList<Integer>();
		
		vertList.append(1);
		vertList.append(2);
		vertList.append(3);
		
		vertList2.append(4);
		vertList2.append(5);
		vertList2.append(6);
		
		pathList.append(vertList);
		pathList.append(vertList2);
		
		String expected = "1 -> 2 -> 3\n4 -> 5 -> 6";
		
		String output = pathList.toString();
		
		assertEquals(expected,output);
	}
	
	@Test
	public void testRemoveLast() {

		PathList<Integer> vertList = new PathList<Integer>();

		
		vertList.append(1);
		vertList.append(2);
		vertList.append(3);

		vertList.removeLast();

		
		int expected = 2;
		
		int output = vertList.getSize();
		
		assertEquals(expected,output);
	}
	
	@Test
	public void testRemoveLastToString() {

		PathList<Integer> vertList = new PathList<Integer>();

		
		vertList.append(1);
		vertList.append(2);
		vertList.append(3);

		vertList.removeLast();

		
		String expected = "1 -> 2";
		
		String output = vertList.toString();
		
		assertEquals(expected,output);
	}

}

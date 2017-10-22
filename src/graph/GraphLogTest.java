package graph;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class GraphLogTest {

	@Test
	public void test() {
		GraphLog log = new GraphLog(null, null, null);
		for (int[] i : log.createRawHeaders()) {
			for (int j : i) {
				System.out.printf("%d ", j);
			}
			System.out.printf("\n", "");
		}
	}
	
	@Test
	public void test2() {
		GraphLog log = new GraphLog(null, null, null);
		log.createRawHeaders();
		//System.out.println(Arrays.toString(log.createHeaders()));
		log.createHeaders();
		
		for (int i = 0; i < 16; i++) {
			System.out.println(log.headers[i]);
		}
		
	}

}

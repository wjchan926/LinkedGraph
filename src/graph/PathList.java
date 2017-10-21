package graph;

/**
 * Generic List class that will be used to hold the possible pathways in the
 * graph. Typical methods for Lists are omitted if unused
 * 
 * @author wchan
 *
 */
public class PathList<T> {

	private Node head;
	private Node tail;
	private int size;

	/**
	 * Generic node class.
	 * 
	 * @author wchan
	 *
	 */
	private class Node {
		private T data;
		private Node prev;
		private Node next;			
	}

	/**
	 * Default constructor for PathList class.
	 */
	PathList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}

	public void append(T t) {	
		// DLL append
	}
	
	public void removeLast() {
		// DLL remove 
	}

/*	public void copy(PathList<T> pathList) {
		Node currentNode = head;
		while(head != null) {
			Node newNode = new Node();
			newNode.data = currentNode.data;
			currentNode = currentNode.next;
		}
	}*/
	
	private boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node currentNode = head;

		if (isEmpty()) {
			return sb.append("No Pathways.").toString();
		} else {
			while (head != null) {
				sb.append(currentNode.data).append(" -> ");
				currentNode = currentNode.next;
			}

			return sb.toString();
		}

	}
}

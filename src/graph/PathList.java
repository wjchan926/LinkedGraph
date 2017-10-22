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
		if (isEmpty()) {
			Node tempNode = new Node();
			tempNode.data = t;
			tempNode.next = null;
			tempNode.prev = null;
			head = tempNode;
			tail = tempNode;
			size++;

		} else {
			Node tempNode = new Node();
			tempNode.data = t;
			tempNode.next = null;
			tail.next = tempNode;
			tempNode.prev = tail;
			tail = tempNode;
			size++;
		}

	}

	public void removeLast() throws NullPointerException {
		if (isEmpty()) {
			throw new NullPointerException("List is empty");
		} else {
			tail = tail.prev;
			tail.next.prev = null;
			tail.next = null;
			size--;
		}

	}

	/*
	 * public void copy(PathList<T> pathList) { Node currentNode = head; while(head
	 * != null) { Node newNode = new Node(); newNode.data = currentNode.data;
	 * currentNode = currentNode.next; } }
	 */

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
			while (currentNode != null && currentNode.data != null) {
				if (currentNode.data instanceof PathList) {
					sb.append(currentNode.data.toString());
					sb.append("\n");
				} else {
					sb.append(currentNode.data);
					if (currentNode != tail) {
						sb.append(" -> ");
					}
				}
				currentNode = currentNode.next;
			}
		}
		return sb.toString();
	}
}

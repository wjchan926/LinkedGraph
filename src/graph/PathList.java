package graph;

/**
 * Generic List class that is customized for the Graph data structure. Typical
 * methods for Lists are omitted if unused. This class can be used to hold both
 * the possible paths between 2 nodes and all possible paths in a matrix.
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

	/**
	 * Gets the size of the list.
	 * 
	 * @return the list size as an int
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Gets the first element of the list
	 * 
	 * @return the first Node in the list
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * Gets the last element of the list.
	 * 
	 * @return the last Node in the list.
	 */
	public Node getTail() {
		return tail;
	}

	/**
	 * Adds an element to the end of the list. Increases the size of the list.
	 * 
	 * @param t
	 *            element to add to the list
	 */
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

	/**
	 * Remove the last element of the list without returning the value.
	 */
	public void removeLast() {
		if (isEmpty()) {
			throw new NullPointerException("List is empty.");
		} else if (head == tail) {
			head = null;
			tail = null;
		} else {
			tail = tail.prev;
			tail.next.prev = null;
			tail.next = null;
			size--;
		}

	}

	/**
	 * This method makes a deep copy of the list.
	 * 
	 * @return a copy of the list
	 */
	public PathList<T> copy() {
		PathList<T> tempPathList = new PathList<T>();

		Node currentNode = head;

		while (currentNode != null) {
			tempPathList.append(currentNode.data);
			currentNode = currentNode.next;
		}

		return tempPathList;
	}

	/**
	 * Checks if the list is empty
	 * 
	 * @return true of the list is empty, false otherwise
	 */
	private boolean isEmpty() {
		return size == 0;
	}

	/**
	 * This method Overrides the toString() method. As an enhancement, it makes
	 * recursive call to the toString() override in order to return the data as
	 * a string since the list can hold other lists
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node currentNode = head;

		if (isEmpty()) {
			return sb.append("No Pathways in Graph.").toString();
		} else {
			while (currentNode != null && currentNode.data != null) {
				if (currentNode.data instanceof PathList) {
					sb.append(currentNode.data.toString());
					sb.append("\r\n");
				} else {
					sb.append(currentNode.data);
					if (currentNode != tail) {
						sb.append(" -> ");
					}
				}
				currentNode = currentNode.next;
			}
		}
		return sb.toString().trim();
	}
}

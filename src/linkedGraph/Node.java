package linkedGraph;

/**
 * This is a generic node class.  It is utilized by the LinkedGraph, LinkedGraphLog, and PathList classes.
 * 
 * @author Wesley Chan
 *
 * @param <T> Generic Datatype
 */
public class Node<T> {
	private T data;
	private Node<T> prev;
	private Node<T> next;

	/**
	 * Default Constructor
	 */
	public Node() {
		data = null;
		prev = null;
		next = null;
	}

	/**
	 * Returns the data stored in the node
	 * 
	 * @return data stored in node
	 */
	public T getData() {
		return data;
	}

	/**
	 * Returns this node's preceding node
	 * @return current node's preceding node
	 */
	public Node<T> getPrev() {
		return prev;
	}

	/**
	 * Returns this node's following node
	 * @return current node's following node
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * Sets the data value of the node.
	 * @param t data of the node as a generic datatype
	 */
	public void setData(T t) {
		data = t;
	}

	/**
	 * Sets the current node's preceding node
	 * @param node node that will precede current node
	 */
	public void setPrev(Node<T> node) {
		prev = node;
	}

	/**
	 * Sets the current node's following node
	 * @param node node that will follow the current node
	 */
	public void setNext(Node<T> node) {
		next = node;
	}

}

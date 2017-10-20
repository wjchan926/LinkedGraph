package Graph;

/**
 * Generic Stack class that will be used to mark the nodes when traversing the graph
 * 
 * @author wchan
 *
 */
public class PathStack<T> {

	private Node top;
	private int size;
	
	/**
	 * Generic node class.
	 * 
	 * @author wchan
	 *
	 */
	private class Node {
		private T data;
		private Node next;
	}
	
	/**
	 * Default constructor for PathStack class.
	 */
	PathStack() {
		top = null;
		size = 0;
	}

	/**
	 * Adds a vertex to the top of the stack. Increases the size of the stack by 1.
	 * 
	 * @param t
	 *            data that will be associated with the node added
	 */
	public void push(T t) {
		Node tempNode = top;
		top = new Node();
		top.data = t;
		top.next = tempNode;
		size++;
	}

	/**
	 * Removes the top vertex from the stack and returns the vertex value. Decreases
	 * the size of the stack by 1.
	 * 
	 * @return value of the vertex at the top of the stack, null if the stack is
	 *         empty
	 */
	public T pop() {
		if (isEmpty()) {
			return null;
		} else {
			T t = top.data;
			top = top.next;
			size--;
			return t;
		}

	}

	/**
	 * Returns but does not remove the top vertex of the stack
	 * 
	 * @return value of the vertex at top of the stack, null if the stack is empty
	 */
	public T peek() {
		return isEmpty() ? null : top.data;
	}

	/**
	 * Checks if the stack is empty
	 * 
	 * @return true if the stack is empty, false otherwise
	 */
	private boolean isEmpty() {
		return top == null;
	}

}
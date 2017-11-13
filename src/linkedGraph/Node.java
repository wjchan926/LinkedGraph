package linkedGraph;

public class Node<T> {
	private T data;
	private Node<T> prev;
	private Node<T> next;

	public Node() {
		data = null;
		prev = null;
		next = null;
	}

	public Node(T t) {
		data = t;
		prev = null;
		next = null;
	}

	public Node(Node<T> n) {
		data = n.getData();
		prev = n.getPrev();
		next = n.getNext();
	}

	public T getData() {
		return data;
	}

	public Node<T> getPrev() {
		return prev;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setData(T t) {
		data = t;
	}

	public void setPrev(Node<T> node) {
		prev = node;
	}

	public void setNext(Node<T> node) {
		next = node;
	}

}

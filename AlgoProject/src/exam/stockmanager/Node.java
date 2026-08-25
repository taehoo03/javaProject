package exam.stockmanager;

public class Node<E> {

	E value;
	Node<E> left;
	Node<E> right;
	Node<E> parent;

	public Node(E value) {
		this.value = value;
	}

	public Node(E value, Node<E> parent) {
		this.value = value;
		this.parent = parent;
	}
}
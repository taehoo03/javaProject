package exam.stockmanager;

import java.util.Comparator;

public class BinarySearchTree<E> {

	private Node<E> root;
	private int size;
	private final Comparator<? super E> comparator;

	public BinarySearchTree() {
		this(null);
	}

	public BinarySearchTree(Comparator<? super E> comparator) {
		this.comparator = comparator;
		this.root = null;
		this.size = 0;
	}

	public boolean add(E value) {

		if (comparator == null) {
			return addUsingComparable(value) == null;
		}

		return addUsingComparator(value, comparator) == null;
	}

	private E addUsingComparable(E value) {

		Node<E> current = root;
		Node<E> currentParent;

		@SuppressWarnings("unchecked")
		Comparable<? super E> compValue =
				(Comparable<? super E>) value;

		int compResult;

		if (current == null) {
			root = new Node<E>(value);
			size++;
			return null;
		}

		do {
			currentParent = current;

			compResult =
					compValue.compareTo(current.value);

			if (compResult < 0) {
				current = current.left;
			} else if (compResult > 0) {
				current = current.right;
			} else {
				return value;
			}

		} while (current != null);

		Node<E> newNode =
				new Node<E>(value, currentParent);

		if (compResult < 0) {
			currentParent.left = newNode;
		} else {
			currentParent.right = newNode;
		}

		size++;

		return null;
	}

	private E addUsingComparator(
			E value,
			Comparator<? super E> comp) {

		Node<E> current = root;
		Node<E> currentParent;

		int compResult;

		if (current == null) {
			root = new Node<E>(value);
			size++;
			return null;
		}

		do {
			currentParent = current;

			compResult =
					comp.compare(value, current.value);

			if (compResult < 0) {
				current = current.left;
			} else if (compResult > 0) {
				current = current.right;
			} else {
				return value;
			}

		} while (current != null);

		Node<E> newNode =
				new Node<E>(value, currentParent);

		if (compResult < 0) {
			currentParent.left = newNode;
		} else {
			currentParent.right = newNode;
		}

		size++;

		return null;
	}

	public E remove(E value) {

		if (comparator == null) {
			return removeUsingComparable(value);
		}

		return removeUsingComparator(value, comparator);
	}

	private E removeUsingComparable(E value) {

		Node<E> currentParent = null;
		Node<E> current = root;

		boolean hasLeft = false;

		if (root == null) {
			return null;
		}

		@SuppressWarnings("unchecked")
		Comparable<? super E> compValue =
				(Comparable<? super E>) value;

		int resComp;

		do {

			resComp =
					compValue.compareTo(current.value);

			if (resComp == 0) {
				break;
			}

			currentParent = current;

			if (resComp < 0) {
				hasLeft = true;
				current = current.left;
			} else {
				hasLeft = false;
				current = current.right;
			}

		} while (current != null);

		if (current == null) {
			return null;
		}

		if (currentParent == null) {

			root = deleteNode(current);
			size--;

			return value;
		}

		if (hasLeft) {
			currentParent.left =
					deleteNode(current);
		} else {
			currentParent.right =
					deleteNode(current);
		}

		size--;

		return value;
	}

	private E removeUsingComparator(
			E value,
			Comparator<? super E> comp) {

		Node<E> currentParent = null;
		Node<E> current = root;

		boolean hasLeft = false;

		while (current != null) {

			int res =
					comp.compare(value, current.value);

			if (res == 0) {
				break;
			}

			currentParent = current;

			if (res < 0) {
				hasLeft = true;
				current = current.left;
			} else {
				hasLeft = false;
				current = current.right;
			}
		}

		if (current == null) {
			return null;
		}

		if (currentParent == null) {

			root = deleteNode(current);

		} else if (hasLeft) {

			currentParent.left =
					deleteNode(current);

		} else {

			currentParent.right =
					deleteNode(current);
		}

		size--;

		return value;
	}

	private Node<E> deleteNode(Node<E> removeNode) {

		if (removeNode.left == null &&
				removeNode.right == null) {

			return null;
		}

		if (removeNode.left != null &&
				removeNode.right != null) {

			Node<E> replacement =
					getSuccessorAndUnlink(removeNode);

			removeNode.value =
					replacement.value;

			return removeNode;
		}

		if (removeNode.left != null) {
			return removeNode.left;
		}

		return removeNode.right;
	}

	private Node<E> getSuccessorAndUnlink(
			Node<E> node) {

		Node<E> currentParent = node;
		Node<E> current = node.right;

		if (current.left == null) {

			currentParent.right =
					current.right;

			current.right = null;

			return current;
		}

		while (current.left != null) {

			currentParent = current;
			current = current.left;
		}

		currentParent.left =
				current.right;

		current.right = null;

		return current;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(Object o) {

		if (comparator == null) {
			return containsUsingComparable(o);
		}

		return containsUsingComparator(o, comparator);
	}

	private boolean containsUsingComparable(Object o) {

		@SuppressWarnings("unchecked")
		Comparable<? super E> value =
				(Comparable<? super E>) o;

		Node<E> node = root;

		while (node != null) {

			int res =
					value.compareTo(node.value);

			if (res > 0) {
				node = node.right;
			} else if (res < 0) {
				node = node.left;
			} else {
				return true;
			}
		}

		return false;
	}

	private boolean containsUsingComparator(
			Object o,
			Comparator<? super E> comp) {

		@SuppressWarnings("unchecked")
		E value = (E) o;

		Node<E> node = root;

		while (node != null) {

			int res =
					comp.compare(value, node.value);

			if (res > 0) {
				node = node.right;
			} else if (res < 0) {
				node = node.left;
			} else {
				return true;
			}
		}

		return false;
	}

	public void clear() {

		size = 0;
		root = null;
	}

	public void preorder() {
		preorder(root);
	}

	public void preorder(Node<E> node) {

		if (node != null) {

			System.out.print(node.value + " ");

			preorder(node.left);
			preorder(node.right);
		}
	}

	public void inorder() {
		inorder(root);
	}

	public void inorder(Node<E> node) {

		if (node != null) {

			inorder(node.left);

			System.out.print(node.value + " ");

			inorder(node.right);
		}
	}

	public void postorder() {
		postorder(root);
	}

	public void postorder(Node<E> node) {

		if (node != null) {

			postorder(node.left);
			postorder(node.right);

			System.out.print(node.value + " ");
		}
	}

	protected Node<E> getRoot() {
		return root;
	}
}
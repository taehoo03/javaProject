package datastructure.tree.binarysearch;

public class Node<E> {
	E value;
	
	//왼쪽 서브트리 참조
	Node left;
	//오른쪽 서브트리 참조
	Node right;
	
	/*
	 * 부모 노드 참조는 이진탐색에서는 사용 안함
	 * 추후 용이하게 사용되므로 미리 추가
	 */
	Node<E> parent;
	
	Node(E value){
		this(value,null);//현재 클래스의 다른 생성자 호출
	}
	
	Node(E value,Node<E> parent){
		this.value = value;
		this.parent = parent;
		this.right = null;
		this.left = null;
	}
}

package datastructure.tree.binarysearch;

import java.util.Comparator;

public class BinarySearchTree <E>{
	private Node<E> root;//루트(최상단)노드
	private int size; //요소(노드)의 개수
	
	private final Comparator<? super E> comparator;//<? super E> 제네릭 타입 E 와 E의 모든 부모 클래스 포함
	
	//type 에 비교정의 객체가 구현되어 있는 타입인 경우
	public BinarySearchTree() {
		this(null);
	}
	//type 에 비교정의 객체가  미구현 타입인 경우에는 comparator 인터페이스를 구현한 구현 객체가 전달 되어야함
	public BinarySearchTree(Comparator<? super E> comparator) {
		this.comparator = comparator;
		this.root = null;
		this.size = 0;
	}
	/*
	 * 노드 추가를 위한 addUsingXXX()메소드는 반환 타입이 E 타입임
	 * 중복 원소를 삽입 할 경우 해당 value를 반환하고 삽입이 완료되면 null을 반환함
	 */
	
	public boolean add(E value) {
		if(comparator ==null) {
			return addUsingComparable(value) ==null;
		}
		return addUsingComparator(value)==null;
	}
	
	//전달되는 객체에 따라  Comparable 또는 Comparator중 하나의 사용이 가능하도록 2개 메서드 생성
	
	//Comparable을 이용한 add메소드
	private E addUsingComparable(E value) {
		Node<E> current = root; // 탐색할 노드르 가리키는 current
		Node<E> currentParent; //current 직전의 탐색 노드르 ㄹ가리키는 노드
		//삽입할 노드가 비교 될 수 있도록 변수 생성(add 대상의 value가 비교 가능하도록 comparable 타입으로 변환
		@SuppressWarnings("unchecked")
		Comparable<? super E> compValue = (Comparable<? super E>) value;
		int compResult; //비교 결과 (양수, 음수 , 0)
		
		//current가 null 즉 ,root가 null이면 root에 새 노드 연결 후  null 반환
		if(current ==null) {
			root= new Node<E>(value);
			size++;
			return null; //노드 추가 완성 시 null 반환
		}
		//기존 트리에 노드가 1개 이상 있는 경우
		do {
			//삽입 위치를 유지한느 변수
			currentParent = current;
			//새로운 노드의 값과 현재 노드의 값  비교
			compResult = compValue.compareTo(current.value);
			//비교 결과에 따라 방향 결정, 동일하면 value 그대로 return
			if(compResult <0) {//새로운 노드 value가 현재 value 보다 작음
				current = current.left;
			}else if(compResult>0) {//새로운 노드값이 현재 값보다 큼
				current = current.right;
			}else {
				return value;
			}
		}while(current !=null);
		//순회가 완료 되어서 삽입해야 할 위치를 찾았다면 value 를 노드로 구성
		Node<E> newNode = new Node<>(value,currentParent);
		//Node<E> newNode= new Node<>(value)
		if(compResult < 0) {
			currentParent.left = newNode;
		}else {
			currentParent.right = newNode;
		}
		size++;
		return null;
	}  
	
	//Comparator을이용한 add 메소드 - Comparable 이용한 메소드와 비교 메소드만 다르고 다른 절차는 동일
	private E addUsingComparator(E value, Comparator<? super E> comp) {
			Node<E> current = root; // 탐색할 노드르 가리키는 current
			Node<E> currentParent;
			int compResult; //비교 결과 (양수, 음수 , 0)
			
		
			if(current ==null) {
				root= new Node<E>(value);
				size++;
				return null; //노드 추가 완성 시 null 반환
			}
			//기존 트리에 노드가 1개 이상 있는 경우
			do {
				//삽입 위치를 유지한느 변수
				currentParent = current;
				//전달된 comparator 이용 비교 진행 - compare(obj1,obj2)
				compResult =comp.compare(value,current, value);
				//비교 결과에 따라 방향 결정, 동일하면 value 그대로 return
				if(compResult <0) {//새로운 노드 value가 현재 value 보다 작음
					current = current.left;
				}else if(compResult>0) {//새로운 노드값이 현재 값보다 큼
					current = current.right;
				}else {
					return value;
				}
			}while(current !=null);
			//순회가 완료 되어서 삽입해야 할 위치를 찾았다면 value 를 노드로 구성
			Node<E> newNode = new Node<>(value,currentParent);
			//Node<E> newNode= new Node<>(value)
			if(compResult < 0) {
				currentParent.left = newNode;
			}else {
				currentParent.right = newNode;
			}
			size++;
			return null;
		}  
	
	///////////////////////////////////////////////////////////
	///삭제(remove) 메서드
	
	public E remove(E value) {
		if(comparator ==null) {
			return removeUsingComparable(value);
		}
		return removeUsingComparator(value,comparator);
	}
	
	private E removeUsingComparable(E value) {
		Node<E> currentParent;
		Node<E>current  = root;
		boolean hasLeft = false;
		
		//current(root)가 null 인 경우
		if(root==null) {
			return null;
		}
		@suppressWarnings("unchecked");''
		Comparable<? super E>compValue = (Comparable<? super E>)value;
		//삭제할 node를 찾는 역할을 함, current.value 와 compvalue가 동일하면 삭제 노드를 찾게 됨 찾으면 break
		//current가 null이면 해당value의 node가 없음
		do {
			resComp =compValue.compareTo(current.value);
			if(resComp ==0) {//삭제할 node 찾음
				break;
			}
			
			//삭제할 node 못찾음
			currentParent = current;
			if(resComp <0) {
				hasLeft = true;
				current = current.left;
			}else {
				hasLeft = false;
				current= current.right;
			}
		}while(current !=null);
		if(current ==null) {//찾는값이 없음
			return null; //삭제 실패
		}
		if(currentParent ==null) {//찾는값이 root에 있음
			deleteNode(current);//deleteNode -> node 삭제 후 재배치 역할
			size--;
			return value;
		}
		
		if(hasLeft) {//turn 면 currentParent 의 쵠쪽 노드가 삭제
			CurrentParent.left = deleteNode(current);
			
		}else {//currentParent의 오른쪽 노드가 삭제 되었음
			currentParent.right = deleteNode(current);
			
		}
		
		if(currentParent ==null) {
			
		}
		
	}
	
	private E removeUsingComparable(E value , Comparator<? super E> comp) {
		
	}
	
	
	private Node<E>deleteNode(Node<E> node){
		
	}
	
	}

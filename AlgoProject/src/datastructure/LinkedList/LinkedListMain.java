package datastructure.LinkedList;

public class LinkedListMain {

	public static void main(String[] args) {
		// LinkedList test
		LinkedList linkedList = new LinkedList();
		String str= null;
		//LinkedList  마지막에 삽입
		linkedList.insertNode("sun");
		linkedList.insertNode("mon");
		linkedList.insertNode("tue");
		linkedList.insertNode("wed");
		linkedList.insertNode("thu");
		linkedList.insertNode("fri");
		linkedList.insertNode("sat");
		linkedList.printList();

		
		//LinkedList의 특정 노드의 참조 반환
		ListNode search = linkedList.searchNode("tue");
		System.out.println(search.getData());
		
		linkedList.insertNode(search,"test");
		linkedList.printList();
		
		//마지막 node 삭제 
		linkedList.deleteNode(str);
		linkedList.printList();
		
		//중간 node 삭제(전달된 data 값을 저장하는 node를 삭제
		linkedList.deleteNode("test");
		linkedList.printList();
		
		str = "sun";
		
		linkedList.deleteNode(linkedList.searchNode(str).getData());
		linkedList.printList();
		
		linkedList.reverseList();
		linkedList.printList(); 
	}

}

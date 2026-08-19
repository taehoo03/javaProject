package datastructure.LinkedList;

public class LinkedList {

	private ListNode head;

	//생성자
	public LinkedList() {
		head =null;
	}

	//Node 삽입(마지막에)
	public void insertNode(String data) {
		//새로운 노드 생성
		ListNode newNode = new ListNode(data);

		if(head==null) {//리스트에 노드가 없는경우
			this.head = newNode;
		}else {//리스트에 노드가 1개 이상 있는 경우
			//시작 노드 주소인 head의 참조주소를 임시 변수에 저장
			ListNode tempNode = head;

			while(tempNode.link != null) {
				tempNode=tempNode.link;
			}

			//마지막 노드를 찾았으면 link에 새로운 노드 참조하도록 연결
			tempNode.link = newNode;
		}
	}

	//노드 중간에 새로운 노드 삽입
	//preNode ->preNode 다음 노드 참조
	public void insertNode(ListNode preNode ,String data) {

		ListNode newNode = new ListNode(data);

		newNode.link = preNode.link;//preNode.link newNode 주소를 update 된 상태에서
		preNode.link = newNode;//preNode.link를 newNode.link로 저장하면 나머지 리스트는 연결 불가능
	}

	//1.중간 노드삭제
	public void deleteNode(String data) {

		if(head == null) {
			return;
		}

		ListNode preNode = head;
		ListNode tempNode = head.link;

		//찾는 data 가 첫번째 노드에서 찾아지는 경우
		if(data.equals(preNode.getData())) {
			head=preNode.link; //헤드는 두번쨰 노드 참조
			preNode.link = null;
		}else {//두번쨰(템프노드) 부터 데이터가 찾아질때 까지 노드 이동

			while(tempNode != null) {

				if(data.equals(tempNode.getData())) {

					//데이터가 일치하는 node를 찾은 경우
					if(tempNode.link==null) {//마지막 노드에서 데이터가 일치한 경우
						preNode.link = null; // preNode는 tempNode 이전 node
					}else {//찾은 노드가 마지막 노드가 아니면

						//preNode : 삭제 노드 이전 노드 , tempNode : 삭제할 노드
						preNode.link = tempNode.link;

						tempNode.link = null;
					}

					break;

				}else {

					preNode = tempNode;
					tempNode = tempNode.link;
				}
			}
		}
	}

	//ㅁ지맞 노드 삭제(data 상관 없이 무조건 마지막 노드 삭제)
	public void deledeNode() {

		ListNode preNode;
		ListNode tempNode;

		//노드 없음
		if(head ==null) {
			return;
		}

		//노드가 1개인 경우
		if(head.link ==null) {
			head =null;
		}else { // 두개 이상인 경우 마지막 노드 찾아야 함(마지막 노드는 null)

			preNode = head;
			tempNode = head.link;

			while(tempNode.link != null) {
				preNode = tempNode;
				tempNode = tempNode.link;
			}

			//반복이 종료되면 마지막 노드는 tempNode가 참조하고 마지막 이전 노드는 preNode 가 참조함
			//preNode.link 를 null로 설정해서 tempNode
			preNode.link = null;
		}
	}

	//노드 검색 : 데이터를 전달해 해당 데이터가 링크드리스트에 있는지 확인 후 있으면 해당 노드의 참조 반환
	public ListNode searchNode(String data) {

		ListNode tempNode= this.head;

		while(tempNode != null) { //다음 노드가 있는 동안 반복

			if(data.equals(tempNode.getData())) {

				//data 가 탑색되면 탐색된 node의 참조 주소가 반환됨
				return tempNode;

			}else {
				tempNode = tempNode.link;
			}
		}

		return tempNode; //안 찾아지면 최동tempNode 반환(반환값은 null)
	}

	// 연결 리스트의 모든 노드의 data 출력
	public void printList() {

		ListNode tempNode = this.head;

		//head 부터 시작하여 마지막 노드ㅓ까지 순회하면서 출력
		while(tempNode !=null) {

			System.out.print(tempNode.getData()+ " ");
			tempNode = tempNode.link;
		}

		System.out.println(); 
	}

	//연결 리스트를 역순을 ㅗ재배치 
	public void reverseList() {

		ListNode nextNode = head;
		ListNode currentNode = null;
		ListNode preNode = null;

		while(nextNode != null) {

			preNode = currentNode;
			currentNode = nextNode;
			nextNode = nextNode.link;

			currentNode.link = preNode;
		}

		head = currentNode;
	}
}
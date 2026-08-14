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
		preNode.link = newNode;
		
		
	}
	
	
	//1.중간 노드삭제
	public void deleteNode(String data) {
		ListNode preNode = head;
		ListNode tempNode = head.link;
		
		//찾는 data 가 첫번째 노드에서 찾아지는 경우
		if(data.equals(preNode.getData())) {
			head=preNode.link; //헤드는 두번쨰 노드 참조
			preNode.link = null;
		}else {//두번쨰(템프노드) 부터 데이터가 찾아질때 까지 노드 이동
			if(data.equals(tempNode.getData())) {
				//데이터가 일치하는 node를 찾은 경우
				if(tempNode.link==null) {//마지막 노드에서 데이터가 일치한 경우
					preNode.link = null; // preNode는 tempNode 이전 node
				}else {//찾은 노드가 마지막 노드가 아니면
					//preNode : 삭제 노드 이전 노드 , tempNode : 삭제할 노드
					preNode.link = tempNode.link;
					tempNode.link = null;
				}
			}else {
					preNode = tempNode;
					tempNode = tempNode.link;
				}
			}
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	






























package api.objectapi.finalize;

public class FinalizeMain {

	public static void main(String[] args) {
		//객체 소멸자 호출 예제
		Counter counter =null;
		for(int i=1;i<50; i++) {
			counter =new Counter(i);
			counter =null; //위에서 생성한 객체가 소멸된다면 재정의 한finalize()에 의 해 호출
			System.gc();
		}

	}

}

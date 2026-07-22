package loop;

public class While {

	public static void main(String[] args) {
		//조건식만 필수로 존재하는 반복문(while)
/*		while(1==1) {//1==1은 무조건 ㄴ참이기때문에 해당 while 은 무한루프에 들어감
			System.out.println("몇번 실행되나요?");*/
		//조건 검사시 거짓에 도달해종료할 수 있도록 while 문 구성
		
		//0-10 출력
		int i=0;//초기식
		
		while(i<=10) {//조건
			System.out.println(i);
			i++; //증가감
			
		}
		
		//1-11 출력
		i =0; //초기식
		while(i<=10) {//조건
			i++;
			System.out.println(i);
		}
	}

}

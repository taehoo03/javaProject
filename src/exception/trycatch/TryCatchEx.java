package exception.trycatch;

public class TryCatchEx {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		// 예외처리 블록
		try {//예외 발생 가능성 있는 코드
			Class clazz =Class.forName("java.lang.String");
		}catch(ClassNotFoundException e){
			System.out.println("클래스가 존재하지 않습니다");
		}
		//예외 처리 후 만나느 ㄴ일반 문장은 정상 실행됨
		System.out.println(arr[5]);
	}

}

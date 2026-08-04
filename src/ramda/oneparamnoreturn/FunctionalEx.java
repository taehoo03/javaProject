package ramda.oneparamnoreturn;

public class FunctionalEx {

	public static void main(String[] args) {
		// 함수형 인터페이스 구현객체 구성(람다식)
		MyFunctionalInterface fi ;
		//매개변수 없고 반환문 없는 람다식, 매개변수가 없으면 반드시 빈 괄호 필요
		fi= (int x) ->{
			int res = x*5;
			System.out.println(res);
		};
		fi.method(5);

	
		fi= (x) ->{//호출시 대입되는 파라미터로 타입을 유추
			int res =x *5
			System.out.println(res);
		};
		fi.method(5);
	
	
	//람다식 매개변수가 1개면 실행블럭이 한줄 문장이면 중괄호 생략 가능
	fi = x ->System.out.println(x*5);
	fi.method(5);
}
}

package ramda.multiparamreturn;

public class FunctionalEx {

	public static void main(String[] args) {
		// 함수형 인터페이스 구현객체 구성(람다식)
		MyFunctionalInterface fi ;
		//매개변수 있고 반환문 없는 람다식, 매개변수가 없으면 반드시 빈 괄호 필요
		fi= (x,y) ->{
			int result = x+y;
			return result;
		};
		fi.method(5,6);

	//매개변수 타입 생략 가능
		fi= (x,y) ->{
			return x+y;
			
		};
		fi.method(5,6);
	
	
	//람다식 실행블럭이 return 한줄 문장이며 중괄호 return 생략 가능
	fi = (x,y) -> x+y;
	fi.method(5,6);
	
	
	//매개변수가 2개 이상인 경우 소괄호 필요
	fi = (x,y) -> x+y;
	fi.method(5,6);
}
}

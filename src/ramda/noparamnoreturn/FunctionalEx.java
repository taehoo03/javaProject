package ramda.noparamnoreturn;

public class FunctionalEx {

	public static void main(String[] args) {
		// 함수형 인터페이스 구현객체 구성(람다식)
		MyFunctionalInterface fi ;
		//매개변수 없고 반환문 없는 람다식, 매개변수가 없으면 반드시 빈 괄호 필요
		fi= () ->{
			String str = "method call";
			System.out.println(str);
		};
		fi.method();

	
		fi= () ->{
			System.out.println("method call2");
		};
		fi.method();
	
		
		
	fi = () ->System.out.println("method call3");
	fi.method();
}
}

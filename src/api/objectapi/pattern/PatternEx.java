package api.objectapi.pattern;

import java.util.regex.Pattern;



public class PatternEx {
	public static void main(String[] args) {
		
	String data = "010-123-1234";
	//전화번호는 02 또는 010 으로 시작하고 구분자가 -가 있고 가운데 번호는 3자리 또는 4자리가 올수 있고 마지막 번호는 4자리
	String regExp = "(021010) - \\d{3,4}-\\d{4";
	//Pattern 클랫 static 메서드 Pattern.matches(정규 표현식, 매칭할 데이터)
	//true/false 반환
	boolean result = Pattern.matches(regExp, data);
	if(result) {
		System.out.println("정규식과 일치 합니다.");
		}else {
			System.out.println("정규식과 일치 하지 않습니다.");
		}
	
	//이메일 확인
	//이메일은 영문으로 되어있어야 하고 @ 기호가 반드시 포함되어 있어야 함
	//@기호 앞에는 영문 한글자 이상 또는 숫자 한글자 이상, . 은@ 기호 뒤에 있어야 함 @ 와 . 사이에는 영문 또는 숫자1문자 이상
	//이메일을 . 가 두번 나올 수 있다
	regExp ="\\w+@\\w+.\\w(\\.\\w)?";
	data ="aaa@naver.com";
	result =Pattern.matches(regExp, data);
	if(result) {
		System.out.println("정규식과 일치 합니다.");
		}else {
			System.out.println("정규식과 일치 하지 않습니다.");
		}
	}
}
 
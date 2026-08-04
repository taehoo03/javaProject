package exception.throwex;

public class BlanceInsufficienException extends Exception {
	//예외 처리 클래스 생성 시 예외 처리 발생 원인(예외 메세지)를 전달하기 위해String 타입 매개변수를 갖는 생성자를구현함

public  BlanceInsufficienException(String message) {//message에 예외 원인이 전달됨
	super(message);

}
}
//예외 처리 클래스 내부에 필드 메서드 생성자 포함 가능함 단, 대부분은 생성자만 오버로딘한다
//예외 메시지 용도: catch 에서 처리할 때 사용하기 위해
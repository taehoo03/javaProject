package interfaceex;

//인터페이스 이름은 관례적으로 대문자 I를 앞에 포함시키고 이름의 첫글자도 대문자
//IAnimal
public interface ISmartPhone {
	//구현 클래스에서 필수 구현해야하는 메소드의 원형(선언부)를 나열
	//생성자 함수는 포함할 수 없음 - 인터페이스는 객체 인스턴스 생성할 수 없음
	
	//구성 요소1 : 추상메소드
	public void sendCall();
	public void receiveCall();
	public void sendSMS();
	public void receiveSMS();
	
	//구성요소 2 : 상수필드
	//구성요소 3 : 디폴트 메소드 : 구현한 메소드
	//구성요소 4 : static 메소드 : 구현한 메소드
}

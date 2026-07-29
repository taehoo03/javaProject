package interfaceex.multi;

public class SmartMain {

	public static void main(String[] args) {
		//다중 인터페이스 구현 객체 확인
		SmartTelevision stv = new SmartTelevision();
		stv.turnOn();
		stv.search(null);
		stv.turnOff();
		
		//IRemoteControl rc = new SmartTelevisioin();
		ISearchable sc= new SmartTelevision();
		


	}

}

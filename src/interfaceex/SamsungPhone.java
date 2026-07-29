package interfaceex;

public class SamsungPhone implements ISmartPhone{//인터페이스의 구현 클래스
	
	String name;
	 
	public SamsungPhone() {
		name ="삼성폼";
	}

	@Override
	public void sendCall() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveCall() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendSMS() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveSMS() {
		// TODO Auto-generated method stub
		
	}
	
}

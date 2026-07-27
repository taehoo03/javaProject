package classInfo;

public class GetterSetter {
	private int speed;
	private boolean stop;
	
	//멤버 필드에 값을 저장하기 위한 메소드
	public void setSpeed(int speed) {
		this.speed =speed;
	}
	public void setStop(boolean stop) {
		this.stop =stop;
	}
	//멤버 필드의 값을 반환하기 위한 메소드
	//getter : get 필드명
	public int getSpeed() {
		return this.speed;
	}
	
	public boolean isStop() {
		return stop;
	}
}

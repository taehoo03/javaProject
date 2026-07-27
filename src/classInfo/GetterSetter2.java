package classInfo;


public class GetterSetter2 {
	private int speed;
	private boolean stop;
	
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		if(speed <0) {
			this.speed =0;
		}else {
			this.speed =speed;
		}
		this.speed = speed;
	}
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed=0;
	}
	
	//이클립스 메뉴통해 자동추가
	//source - generate getter and setter
}

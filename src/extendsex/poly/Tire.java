package extendsex.poly;

public class Tire {
	public int maxRotation; //최대 수명
	public int accumulatedrotation; //누적회전수
	public String location; //타이어의 위치
	
	//생성자
	public Tire(String location,int maxRotation) {
		this.location =location;
		this.maxRotation =maxRotation;
	}
	
	public boolean roll() {
		++accumulatedrotation;
		if(accumulatedrotation<maxRotation) {
			System.out.println(location + "Tire 수명 : " + (maxRotation-accumulatedrotation) + "회");
			return true;
		}else {
			System.out.println("*** "+location + "Tire 펑크");
			return false;
		}
	}
	
}

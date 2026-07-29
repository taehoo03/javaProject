package extendsex.poly;

public class HankookTire  extends Tire{
	public HankookTire(String location,int maxRotation) {
	super(location,maxRotation);
}

@Override
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
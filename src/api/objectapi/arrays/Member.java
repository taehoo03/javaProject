package api.objectapi.arrays;

public class Member implements Comparable {
	String name;
	Member(String name){
		this.name =name;
	}
	
	//CompareTo() 리턴값
	// - 오름 차순일때 자신이 매개값보다 늦을 경우 음수 , 같을 경우  0 , 높으면 양수 반환
	@Override
	public int compareTo(Member 0) {
		return name.compareTo(0.name);
	}
}

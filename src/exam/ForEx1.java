package exam;

public class ForEx1 {

	public static void main(String[] args) {
		int i,sum;
		sum =0;
		for(i=1; i<=10;i++)
			if(i%2 ==1) {
				sum+=i;
		System.out.println(i);
	}
		System.out.println("1~10까지 홀수의 합 : " +sum);
		
}
}
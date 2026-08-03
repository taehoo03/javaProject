package api.objectapi.random;

import java.util.Random;

public class RandomEx {

	public static void main(String[] args) {
		//seed 값 없는 정수형 난수
		Random random = new Random();
		
		for(int i=0; i<10;i++) {
			System.out.print(random.nextInt(10)+1+ " ");
		}
		
		//seed 값 있는 랜덤 객체 정수형 난수 : 시드 값이 같으면 동일한 난수 발생
		Random random1 = new Random(568795206);
		
		for(int i=0; i<10;i++) {
			System.out.print(random1.nextInt(10)+1+ " ");
		}

	}

}

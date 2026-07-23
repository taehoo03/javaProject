package ref;

import java.util.Arrays;

public class ArrayCopy {

	public static void main(String[] args) {
		//배열의 복사
		//(1)얕은 복사 : 객체를 새로 생성하는것이 아니라  객체의 주소만 복사
		int []a1 = {1,2,3,4};
		int[] b1 = new int[a1.length]; // a 참조변수에 저장된 참조 주소값이 b변수에 저장됨
		
		//변경 전 출력 -a1,b1 변경 출력
		for(int i=0;i<a1.length;i++) {
			System.out.print(a1[i]+ " ");
		}
		System.out.println();
		for(int i=0;i<b1.length;i++) {
			System.out.print(b1[i]+ " ");
		}
		System.out.println();
		//변수 변경 진행
		
		a1[0] =10;
		//변경 후 출력
		for(int i=0;i<a1.length;i++) {
			System.out.print(a1[i]+ " ");
		}
		System.out.println();
		for(int i=0;i<b1.length;i++) {
			System.out.print(b1[i]+ " ");
		}
		System.out.println();
		  //(2) 깊은 복사
			/*
			 * Object.clone()
			 * Arrays.copyOf()
			 * Arrays.copyOfRange()
			 *  System.arraycopy()
			 */
		//2. Object.clone() -> Object를 모든 클래스는 상속받기 떄문에 배열객체에도 Object의 clone()메소드가 있음
		int a2[] = {1,2,3,4};
		int b2[] =a2.clone();

		System.out.println("Object.clone()이용한 깊은 복사");
				//변경 전 출력 -a2,b2 변경 출력
				for(int i=0;i<a2.length;i++) {
					System.out.print(a2[i]+ " ");
				}
				System.out.println();
				for(int i=0;i<b2.length;i++) {
					System.out.print(b2[i]+ " ");
				}
				System.out.println();
				//변수 변경 진행
				
				a2[0] =10;
				//변경 후 출력
				for(int i=0;i<a2.length;i++) {
					System.out.print(a2[i]+ " ");
				}
				System.out.println();
				for(int i=0;i<b2.length;i++) {
					System.out.print(b2[i]+ " ");
				}
				System.out.println();
				
				//3.Arrays
				//Arrays.copyOf()(원본 배열, 복사할 길이) - 새로운 배열객체 생성 후 반환
				int []a3= {1,2,3,4};
				int []b3 = Arrays.copyOf(a3, a3.length);
				int []b3One= Arrays.copyOfRange(a3,1,3 );//인덱스 1-3
				
				//변경 전 출력 -a1,b1 변경 출력값이 동일
				for(int i=0;i<a3.length;i++) {
					System.out.print(a3[i]+ " ");
				}
				System.out.println();
				for(int i=0;i<b3.length;i++) {
					System.out.print(b3[i]+ " ");
				}
				System.out.println();
				System.out.println("Arrays.copyOfRange()이용한 깊은 복사");
				//변수 변경 진행
				
				a1[0] =10;
				//변경 후 출력
				for(int i=0;i<a3.length;i++) {
					System.out.print(a3[i]+ " ");
				}
				System.out.println();
				for(int i=0;i<b3.length;i++) {
					System.out.print(b3[i]+ " ");
				}
				System.out.println();
				System.out.println("Arrays.copyOfRange()이용한 깊은 복사");
				
				
				for(int i=0;i<b3One.length;i++) {
					System.out.print(b3One[i]+ " ");
		
	}
				//배열 크기 변경 불가능 - 더 큰 배열 필요시 새 배열 생성 후 기존 배열 원소 값 복사
				int []a5 = {1,2,3,4};
				int[] b5 = new int[10]; 
				
				//각 원소값을 하나씩 저장
				for(int i=0;i<a5.length;i++) {
					b5[i] = a5[i];
				}
				System.out.println();
				for(int i=0;i<b5.length;i++) {
					System.out.print(b5[i]+ " ");
		
	}
				
				//향상된 for문 : 참조 객체 중 배열 또는 컬렉션의 항목 요소를 순차적으로 처리
				//index 이용하지 않고 바로 항목 요소 반복 가능
				//for(반복변수: 배열 또는 컬렉션){반복문장}
				int sum=0;
				int[] scores = {95,71,84,93,87};
				for( int score : scores) {
					sum+= score;
				
				}
				System.out.println();
				System.out.println("sum의 값 : "+ sum);
				
				String[] flowers = {"해바라기","장미","진달래"};
				for(String flower : flowers) {
					System.out.println(flower + " ");
				}
				
	}
}



package ref;

import java.util.Arrays;

public class ArrayInfo {

	public static void main(String[] args) {
		// Array 선언 형식
		//1.데이터 타입[] 변수명
		//2. 데이터타입 변수명[]
		int[] num;
		double[] average;
		String[] name; //name 배열변수가 참조하는 주소에 가면 문자열이 저장된 주소값들이 나열되어있다.
		
		//배열 선언 후 메모리 할당[new]를 받아야 함
		//new 배열데이터 타입[원소 수]
		//배열 선언과 동시에 할당
		int a[] = new int[5];
		//미리 선언해 놓은 변수에 할당받아 대입
		average = new double[5];
		
		//주의 : 배열 선언시 크기 지정은 불가능
		 //int[3] b;
		//int b[3];
		
		
		//배열 선언 후 메모리 할당 받으면 자료형의 기본값으로 초기화 됨
		int ab[] = new int[5]; //초기값 : 0 ,byte,short : 0 long 0L
		boolean b[] =new boolean[3]; //초기값 false
		double[]c= new double[3]; //초기값 0.0 float 형 초기값 :: 0.0F
		String[] s= new String[5]; //초기값 : null
		char[] cb = new char[5]; //초기값: \u0000(유니코드NULL 문자)
		
		//배열 선언할 때 바로 실제 값 대입으로 배열객체 생성: 초기화
		int num1 [] = {1,2,3,4,5};; // int 배열 생성 원소수 5개
		double num2[] = {5.0,6.5}; //
		String[] nation = {"Korea","Japan","China"};
		
		//주의 사항
		int num3[]; //배열 선언 후
		//num3 = {1,2,3,4,5}; // 실제값을 {} 대입하려면 에러발생, 선언과 동시에 초기화 하는 경우만 사용가능
		num3 = new int[] {1,2,3,4,5};
		
		//new 로 배열을 생성할 때는 선언과 생성을 분리한 후 나중에 값만 채워 넣는 식의 문법을 지원하지 않는다
		//ab = {1,2,3,4,5}; //new  이용 메모리 할당 시 이미 초기화 되었으므로{} 사용 불가능
		
		//참조형 변수의 값을 출력하면 결과는?
		System.out.println(num1); //[I@2ff4acd0 ->16진수 배열 주소, 실제 메모리 물리주소가 아닌 jvm 사용 가상주소
		//가상 주소가 [시작하면 배열임, [: 1차원 배열 [[:2차원 배열
		
		//배열 사용 : 배열 원소에 값 저장 또는 값 참조(원소 값 복사 후 반환)
		//원소 접근 index  사용(0부터 시작함)
		int x = num3[0];
		System.out.println(x);
		num3[0] =3;
		System.out.println(num3[0]);
		
		//배열은 객체의 특수한 형태, 배열의 정보 속성을 사용할 수 있음
		//배열의 길이(원소 수)  : 배열변수.length
		System.out.println(num3.length);
		//num3[0],num3[1]..num3[4]
		
		//반복문 활용 배열의 모든 원소에 접근
		for(int i=0; i<num3.length; i++) {
			//index를 표현하기 위한 변수 i,index 가 0부터 시작하고 배열길이 -1 까지 index 가 생성
			System.out.println(num3[i]);
		}
		
		//length 속성은 final field기 때문에 수정 불가능 함
		//num3.length =10;
		
		//배열길이를 변경하려면 기존 배열길이 변경은 불가능 함
		//더 큰 배열 생성하고 , 기존 배열 내용을 새로운 배열에 복사해서 사요해야함
		
		//참조형 배열 예시
		String[] flowers= {"해바라기" , "장미","진달래"};
		
		for(int i=0;i<flowers.length; i++) {
			System.out.println(flowers[i]+ "");
			
		}
		System.out.println();
		
		//배열 변수 출력: 배열의 가상주소
		//배열 변수 toString()활용  - 문자열변환(참조형 객체인 경우에는 참조하는 데이터를 문자열로 반환)
		System.out.println(Arrays.toString(flowers));
		System.out.println(Arrays.toString(num3));
		
		//배열 크기 확인
		System.out.println(flowers.length);
		
		int [] score = new int [] {};
		int[] score2 = {};
		int []score3 = new int[0];
		
		
		

		
	
	}

}

package ref;

public class Array2Dim {

	public static void main(String[] args) {
		//다차원 배열 : 차원에 따라 [] 수를 증가시킨다 [][]: 2차원 [][][] : 3차원
		int[][] a= new int[3][4]; //선언과 동시 할당
		
		//2차원 배열의 초기화 : 선언 + 기억장소 할당 + 원소에 값 저장
		int[][] b = {{1,2,3,4},{5,6,7,8},{9,10,11,12}}; //3행 4열 2차원 배열
		char[][] c = {{'a','b','c'},
				{'d','e','f'}};// 2행 3열
		
		// 2차원 배열의 각 원소값 접근
	      System.out.println(c[0][2]);
	      
	      for(int i = 0; i < 2; i++) {
	         for(int j = 0; j < 3; j++) {
	            System.out.print(c[i][j] + " ");
	         }
	      }
	      
	      //배열 길이 참조: 배열 length, 배열[index].length
	      for(int i = 0; i < c.length; i++) {
	    	  for(int j = 0; j < c[i].length; j++) {
	         System.out.print("\n" + c[i] + " "); //각행의 우너소 모두 출력
	         
	      }
	    	  System.out.print(c); // [[2차원 배열
	    	  }
	      
	      
	      
	}

}

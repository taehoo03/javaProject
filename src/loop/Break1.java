package loop;

public class Break1 {

	public static void main(String[] args) {
		// 반복 진행 중 특정 조건 만족시 반복 종료
		int i =0;
		while(true) {
			//무한 반복
			i +=3;
			if(i>100) {//100보다 크면
				break; //가장 가까운 반복문 종료
			}
			System.out.println(i);
		}
		
		//중첩 반복에서의 break -break 와 가장 가까운 반복문 종료
		for(char upper ='A';upper<='Z';upper++) {
			for(char lower='a';lower<='z';lower++) {
				System.out.println(upper+"-" +lower);
				if(lower =='g') {
					break; // 안쪽 반복문 종료
				}
			}
		}
		//중첩 반복에서의 break -break 를 이용해 특정 반복문을 종료
		//종료하고자 하는 반복문에 라벨을 붙임
		Outter :for(char upper ='A';upper<='Z';upper++) {
			for(char lower='a';lower<='z';lower++) {
				System.out.println(upper+"-" +lower);
				if(lower =='g') {
					break Outter; // 해당 라벨이 부착된 반복문이 종료됨
				}
			}
		}
		
		//중첩 반복에서의 break -break 를 이용해 특정 반복문을 종료
		//종료하고자 하는 반복문에 라벨을 붙임
		Outter :for(char upper ='A';upper<='Z';upper++) {
			for(char lower='a';lower<='z';lower++) {
				System.out.println(upper+"-" +lower);
				if(lower =='g') {// 소문자 g 이면 안쪽 for문 중단
					
				break;
				}
				
				if(upper =='K') {
					break Outter; //대문자 k이면 바깥 for문 중단
				}
			}
		}
	}

}

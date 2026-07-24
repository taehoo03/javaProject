package exam;
import java.util.Scanner;
public class Member {
	String ID;
	String name;
	int age;
	String num;
	String add;
	
	  public Member() {
	        this("hkd","홍길동","30","010-1234-5678","서울시 강남구 대치동");
	    }
	
	public void inputInfo() {
		
		Scanner sc =new Scanner(System.in); 
		
		System.out.println("*** 회원 정보 입력 ***");
		System.out.print("아이디 입력 : " );
		ID =sc.next();
		
		System.out.print("성명 입력 : " );
		name =sc.next();
		
		System.out.print("나이 입력 : " );
		age =sc.nextInt();
		
		System.out.print("전화번호 입력  : " );
		num =sc.next();
		
		System.out.print("주소 입력 : " );
		add =sc.next();
		
		//sc.close(); 
}
	public void showInfo() {
        System.out.println("*** 회원정보 출력 ***");
        System.out.println("ID : " + ID);
        System.out.println("성명 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("전화 : " + num);
        System.out.println("주소 : " + add);
    }
}

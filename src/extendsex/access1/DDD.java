package extendsex.access1;

public class DDD extends extendsex.access.AAA {
		public DDD() {
			field1 =10; //super class AAA의 필드(public)
			field1 =10;//super class AAA의 필드(default) -상속 받아도 다른패키지 사용 불가능
			field1 =10;//super class AAA의 필드(private) - 상속 받아도 사용 불가능
			field1 =10;//super class AAA의 필드(protected) - 상속 받은 경우 다른 패키지 사용 가능
			
		}
}

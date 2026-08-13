package recursion;

public class Recursion1 {
//Sum(n) = n+(n-1)(n-2)+...+1
	//Sum(5) = 5+4+3+2+1(Sum(4))
	//Sum(4) =4+sum(3)
	//Sum(3) =3+sum(2)
	//Sum(2) =2+sum(1)
	//Sum(1) 1+ sum(0)
	//sum(0) = return 0
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sum(10));
	}
	static int sum(int n) {
		int(n==0){
			return 0;
		}else {
			return n+sum(n-1);
		}
	}
}

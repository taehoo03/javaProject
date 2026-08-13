package recursion;



import java.util.Scanner;

public class Fabonachi {
	//n = (n-1) +(n-2)
	//n==1 |n==2 -> 1
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("항 개수 입력 ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
    

    static int fibonacci(int n) {
        if (n ==1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
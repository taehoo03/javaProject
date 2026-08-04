package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();

		
		for (int i = 0; i < 4; i++) {
			System.out.print("단어를 입력하세요 >> ");
			list.add(sc.nextLine());
		}

		System.out.println("-----------------------------");

		
		for (String word : list) {
			System.out.print(word + " ");
		}

		System.out.println();

		
		String longest = list.get(0);

		for (String word : list) {
			if (word.length() > longest.length()) {
				longest = word;
			}
		}

		System.out.println("가장 긴 단어는 : " + longest);
		System.out.println("가장 긴 단어의 길이는 : " + longest.length());

		sc.close();
	}
}
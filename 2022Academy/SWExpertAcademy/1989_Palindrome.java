import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {

	static String str;

	static int solution() {

		int len = str.length();
		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - 1 - i)) {
				return 0;
			}
		}

		return 1;
	}

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("src/res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = Integer.parseInt(sc.nextLine());

		StringTokenizer st;

		for (int test_case = 1; test_case <= T; test_case++) {

			str = sc.nextLine();
			int answer = solution();

			System.out.println("#" + test_case + " " + answer);
		}
	}
}
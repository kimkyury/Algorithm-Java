import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {

	static int N;
	static int[][] map;

	static int solution() {

		int middle = N / 2;

		int sum = 0;

		for (int i = 0; i < N; i++) {
			sum += map[middle][i];
			sum += map[i][middle];
		}
		sum -= map[middle][middle];

		for (int i = 1; i < middle; i++) {
			for (int k = 1; k <= i; k++) {
				sum += map[i][middle - k];
				sum += map[i][middle + k];

				sum += map[N - i - 1][middle - k];
				sum += map[N - i - 1][middle + k];
			}

		}

		return sum;
	}

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("src/res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = Integer.parseInt(sc.nextLine());

		StringTokenizer st;

		for (int test_case = 1; test_case <= T; test_case++) {
			// st = new StringTokenizer(sc.nextLine());

			N = Integer.parseInt(sc.nextLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String str = sc.nextLine();

				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			int answer = solution();

			System.out.println("#" + test_case + " " + answer);
		}
	}
}
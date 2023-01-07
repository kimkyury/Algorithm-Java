import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {

	static int N, K;
	static int[][] map;

	static int solution() {

		int cnt = 0;

		// 가로, 세로로 연속된 1이 K만큼 존재하는지 확인한다
		int row = 0;
		int col = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 시작점 i, j

				row = 0;
				col = 0;
				for (int k = 0; k < K; k++) {
					if (j + k < N && map[i][j + k] == 1)
						row++;

					if (i + k < N && map[i + k][j] == 1)
						col++;

				}

				if (row == K && (j + K >= N || map[i][j + K] == 0)) {
					if (j - 1 >= 0 && map[i][j - 1] == 0 || j - 1 < 0)
						cnt++;

				}
				if (col == K && (i + K >= N || map[i + K][j] == 0)) {
					if (i - 1 >= 0 && map[i - 1][j] == 0 || i - 1 < 0)
						cnt++;
				}
			}
		}
		return cnt;
	}

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("src/res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = Integer.parseInt(sc.nextLine());

		StringTokenizer st;

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(sc.nextLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(sc.nextLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int answer = solution();

			System.out.println("#" + test_case + " " + answer);
		}
	}
}
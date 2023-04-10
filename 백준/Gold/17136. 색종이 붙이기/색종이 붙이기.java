
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[] confettiLimit;
	static int[][] map;
	static boolean[][] isAttach;
	static int minCnt = Integer.MAX_VALUE;
	static boolean neverPossible;

	static boolean confirmAttach(int y, int x, int size) {

		// range Check
		if (y + size > 10 || x + size > 10)
			return false;

		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (map[i][j] != 1)
					return false;
			}
		}

		return true;

	}

	// 해당 색종이 숫자로 표기하기
	static void attach(int y, int x, int size, int num) {
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				map[i][j] = num;
			}
		}
	}

	// cnt : 사용한 색종이 수
	static void dfs(int y, int x, int cnt) {

		if (y == 9 && x > 9) {
			minCnt = Math.min(minCnt, cnt);
			return;
		}

		if (minCnt <= cnt)
			return; // Pruning

		// 개행
		if (x > 9) {
			y = y + 1;
			x = 0;
		}

		// 칠해야하는 곳
		if (map[y][x] == 1) {
			for (int i = 1; i <= 5; i++) {
				// 잔여색종이 확인 && 색종이크기 만큼 map에 영역표기가 되어있는지 확인
				if (confettiLimit[i] > 0 && confirmAttach(y, x, i)) {
					// Run Attach && Counting rest Confetti
					attach(y, x, i, 0);
					confettiLimit[i]--;

					// Call recurFuc, next Position

					dfs(y, x + i, cnt + 1);

					// Restore
					attach(y, x, i, 1);
					confettiLimit[i]++;

					//
				}
			}

		} else {
			dfs(y, x + 1, cnt);
		}
	}

	public static void main(String[] args) throws Exception {

		confettiLimit = new int[6];
		for (int i = 1; i < 6; i++)
			confettiLimit[i] = 5;

		isAttach = new boolean[10][10];
		map = new int[10][10];
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, 0);

		if (minCnt == Integer.MAX_VALUE)
			minCnt = -1;

		bw.write(String.valueOf(minCnt));
		bw.flush();
	}

	public static void show(int[][] arr) {

		for (int ar[] : arr) {
			for (int a : ar)
				System.out.print(a + " ");
			System.out.println("");
		}
	}

	public static void show(int[] ar) {
		System.out.println("사용한 종이 개수---");
		for (int i = 1; i <= 5; i++) {
			System.out.print((5 - ar[i]) + " ");

		}
		System.out.println("");
	}
}

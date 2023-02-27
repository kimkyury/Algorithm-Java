import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb;

	static int[][] dp;

	static int parents[];

	static int T;
	static int N;

	public static StringBuilder show(char[][] arr) {
		StringBuilder sb = new StringBuilder();
		for (char[] ar : arr) {
			for (char a : ar) {
				sb.append(a);
			}
			sb.append('\n');
		}
		return sb;
	}

	public static void union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);

		if (aParent == bParent) {
			return;
		} else {
			if (aParent < bParent) {
				parents[bParent] = aParent;
			} else {
				parents[aParent] = bParent;
			}
		}
	}

	public static int find(int a) {
		if (a == parents[a]) {
			return parents[a];
		}
		return parents[a] = find(parents[a]);

	}

	public static void main(String args[]) throws Exception {

		//System.setIn(new FileInputStream("res/input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));

//        T = 10;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb = new StringBuilder();
			int answer = 0;
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parents = new int[n + 1];

			for (int i = 0; i <= n; i++) {
				parents[i] = i;
			}
			// 0 a b -> a, b 를 한 집합으로
			// 1 a b -> 한 집합인지 말하기

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int operation = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (operation == 0) {
					// 합치기
					union(a, b);
				} else {
					// 확인하기

					int aParent = find(a);
					int bParent = find(b);

					if (aParent != bParent)
						sb.append('0');
					else
						sb.append('1');

				}
			}

			bw.write("#" + test_case + " " + sb.toString() + "\n");
			bw.flush();

		}
	}
}
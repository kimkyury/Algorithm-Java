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

	static int parents[];

	static int T;
	static int N;

	public static void union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);

		if (aParent == bParent) {
			return;
		} else {
			if (aParent < bParent)
				parents[bParent] = aParent;
			else
				parents[aParent] = bParent;
		}
	}

	public static int find(int a) {
		if (a == parents[a])
			return parents[a];
		return parents[a] = find(parents[a]);

	}

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));

//        T = 10;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parents = new int[n + 1];

			for (int i = 1; i <= n; i++)
				parents[i] = i;

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}

			for (int i = 0; i <= n; i++) {
				find(i);
			}
			int cnt = 0;
			boolean isPassed[] = new boolean[n + 1];
			for (int i = 1; i <= n; i++)
				isPassed[parents[i]] = true;

			for (int i = 1; i <= n; i++) {
				if (isPassed[i])
					cnt++;
			}

			bw.write("#" + test_case + " " + cnt + "\n");
			bw.flush();

		}
	}
}
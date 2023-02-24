
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N;
	static int M;
	static boolean isEnd;
	static boolean[] isPassed;

	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	// 서클이 있는지 확인하면 됨
	public static void search(int v, int cnt) {
//		System.out.println(v + " " + cnt);
		if (isEnd)
			return;

		if (cnt >= 5) {

			System.out.print("1");
			isEnd = true;
			return;
		}

		ArrayList<Integer> tmp = graph.get(v);
		for (int i = 0; i < tmp.size(); i++) {

			int tmpV = tmp.get(i);
			if (isPassed[tmpV]) {
				continue;
			}

			isPassed[tmpV] = true;
//			System.out.print("here");
			search(tmp.get(i), cnt + 1);
			isPassed[tmpV] = false;
		}

	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {

			graph.add(new ArrayList<Integer>());
		}

		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		isEnd = false;
		for (int i = 0; i < N; i++) {
			isPassed = new boolean[N];
			isPassed[i] = true;
//			System.out.println(i + " 에서 시작");
			search(i, 1);
		}

		if (!isEnd) {
			System.out.print(0);
		}

		bw.flush();
	}
}

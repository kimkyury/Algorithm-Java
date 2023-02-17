import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, K;

	public static void main(String[] args) throws IOException {
		Main main = new Main();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}

		int[] answer = new int[N];
		int index = 0;

		int tmp = 0;
		while (!q.isEmpty()) {

			for (int i = 0; i < K - 1; i++) {
				tmp = q.poll();
				q.offer(tmp);
			}
			answer[index++] = q.poll();
		}

		bw.write("<");
		for (int i = 0; i < N - 1; i++) {
			bw.write(String.valueOf(answer[i]) + ", ");
		}
		bw.write(answer[N - 1] + ">");
		bw.flush();
	}
}

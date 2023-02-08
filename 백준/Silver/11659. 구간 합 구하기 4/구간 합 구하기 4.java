import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static int M;

	static int arr[];
	static int dp[];

	public static void solve(int index) throws IOException {

	}

	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		arr[0] = 0;
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// i번째까지 합한 값을 dp로 저장해놓자
		// 1 3이라고 하면, 3번까지의 합에서 1번합을 빼버리면 된다
		dp = new int[N + 1];
		dp[0] = 0;
		dp[1] = arr[1];
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + arr[i];
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
//			bw.write(String.valueOf(dp[end]) + " " + String.valueOf(dp[start]) + " \n");
			bw.write(String.valueOf(dp[end] - dp[start - 1]) + "\n");

		}

		bw.flush();
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N;
	static int M;

	public static int twoPointer(int[] arr) {

		int lt = 0;

		int cnt = 0;
		while (true) {
			if (lt == arr.length - 1)
				break;
			int sum = 0;
			int num1 = arr[lt];

			for (int rt = arr.length - 1; rt > lt; rt--) {
				int num2 = arr[rt];
//				System.out.println(num1 + " " + num2);
				sum = num1 + num2;
				if (sum == M) {

					cnt++;
					break;
				}
				if (sum < M)
					break;
			}

			lt++;
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine()); // 필요한 수

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int answer = twoPointer(arr);

		bw.write(String.valueOf(answer));
		bw.flush();

	}
}

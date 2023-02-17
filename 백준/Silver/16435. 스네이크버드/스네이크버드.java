
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static long[] fibo = new long[52];
	static int N, M;

	static int result;

	public static void main(String[] args) throws IOException {

		// 과일의 높이가 주어진다
		// 자신의 길이보다 작거나 높은 과일을 먹을 수 있다
		// 처음 길이가 L일때 과일들을 먹어 늘릴 수 있는 최대 길이 구하기

		// 주어지는 수를 오름차순으로 정렬한다
		// 해당 수가 지금의 스네이크 버드보다 같거나 작은지를 판단하고, 길이를 증가시킨다
		// 다음 수를 다시 더하여 구한다

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		for (int a : arr) {

			if (a <= L) {

				L++;
			} else {
				break;
			}
		}

		bw.write(String.valueOf(L));
		bw.flush();
	}

}

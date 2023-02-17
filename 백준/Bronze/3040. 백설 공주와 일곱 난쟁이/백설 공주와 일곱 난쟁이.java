

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[] choice = new int[7];
	static boolean isEnd;
	static int[] arr;

	public static void solve(int index, int cnt) throws IOException {

		if (isEnd)
			return;

		if (cnt == 7) {
			int sum = 0;

			for (int value : choice) {
//				bw.write(String.valueOf(value) + " ");
				sum += value;
			}
//			bw.write("\n");

			if (sum == 100) {

				isEnd = true;
				for (int value : choice)
					bw.write(String.valueOf(value) + "\n");
			}
			return;
		}

		if (index == 9)
			return;

		choice[cnt] = arr[index];
		solve(index + 1, cnt + 1);
		solve(index + 1, cnt);

	}

	public static void main(String[] args) throws IOException {

//		StringTokenizer st = new StringTokenizer(br.readLine());

		// 아홉개의 수 중 합이 100이 되는 일곱개의 수
		// 조합?

		arr = new int[9];
		for (int i = 0; i < 9; i++)
			arr[i] = Integer.parseInt(br.readLine());

		solve(0, 0);

//		bw.write(String.valueOf());
		bw.flush();
	}

}

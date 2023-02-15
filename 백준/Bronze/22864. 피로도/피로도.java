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

	static int A, B, C, M;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 한계값

		// 한시간당 피로도:A, 처리량: B
		// 한시간당 회복량:C, 피로도는 최저 0으로 유지

		// 번아웃이 되지 않도록 일을 할 때의 하루 최대 일을 할 수 있는 양 리턴

		// 24번에 대하여 반복한다
		// A가 M보다 커졌을 시, 그 직전 B값을 max에 저장한다
		// M보다 작아지도록 C만큼 감소시킨다
		if (A > M) {

			bw.write("0");
			bw.flush();
			return;
		}
		int sumA = 0; // 피로도
		int sumB = 0; // 처리량
		int maxB = 0;

		int cnt = 0;
		boolean isOver = false;
		boolean beReturn = false;
		while (cnt < 24) {
			isOver = false;
			if (sumA > M) {
				sumA = sumA - A;
				sumB = sumB - B;
				maxB = Math.max(maxB, sumB);

				cnt--;
				isOver = true;
			} else if (sumA == M) {
				maxB = Math.max(maxB, sumB);
				isOver = true;
			}

			if (isOver) {
				while (!(sumA <= M - A)) {

					if (cnt >= 23) {
						beReturn = true;
						break;
					}
					cnt++;
					sumA -= C;
					if (sumA < 0) {
						sumA = 0;
					}

				}
			}

			if (beReturn)
				break;

			sumA += A;
			sumB += B;
			cnt++;
		}

		// bw.write(sumA + " " + sumB + " " + cnt);
		bw.write(String.valueOf(sumB));
		bw.flush();

	}
}

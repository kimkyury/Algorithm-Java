import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sb;

	// -------- variable for Problem
	static long A, B; // 10^15

	static long[] countingSubNum(long num, long[] numCnts, long d) {

		// 133 -> 3, 3, 1
		while (num > 0) {
			numCnts[(int) (num % 10)] += d; // 1
			num /= 10;
		}

		return numCnts;

	}

	public static void main(String args[]) throws Exception {

		//System.setIn(new FileInputStream("res/input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		// 33 133
		// 4~12는 10번씩 나온다
		for (int t = 1; t <= T; t++) {
			// n = 구하고자 하느 숫자, v = 자릿

			st = new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());

			long[] numCnts = new long[10]; // 0~9 몇 번 나오는가

//			System.out.println("hihi" + A + " " + B);
			// A가 B보다 같을 떄까지

			// 증가시킬 단위
			long d = 1;
			while (A <= B) {

				/* 양 끝 처리 */
				// 30번대 짜투리 33, 34, 35, 36, 37, 38, 39
				for (; A % 10 != 0 && A <= B; A++)
					numCnts = countingSubNum(A, numCnts, d);

				// 130번 때 짜투리, 133 132 131 130
				for (; B % 10 != 9 && A <= B; B--)
					numCnts = countingSubNum(B, numCnts, d);

				if (A > B) // ex. A:33, B: 34
					break;

				/* 중간 큰 숫자들 처리 */
				A /= 10;
				B /= 10;
				long rowCnt = (B - A + 1) * d;
				for (int i = 0; i < 10; i++)
					numCnts[i] += rowCnt;

				d *= 10;

			}

			long totalCnt = 0;

			for (int i = 1; i < 10; i++)
				totalCnt += i * numCnts[i];
//			System.out.println("hihii");

			bw.write("#" + String.valueOf(t) + " " + String.valueOf(totalCnt) + "\n");

		}
		bw.flush();
	}
}

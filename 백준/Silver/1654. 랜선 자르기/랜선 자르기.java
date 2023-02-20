

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, K;
	static int[] lineLAN, target;
	static int answer; // 최대 랜선 길이
	static int sumShareMax;

	public static void solve(int index, int cnt) throws IOException {

	}

	public static void binarySearch(int lt, int rt, int mid) {

//		System.out.print(lt + " " + rt + " " + mid);

		while (lt <= rt) {
			int sumShare = 0;
			for (int len : lineLAN) {
				sumShare += len / mid;
			}

			if (sumShare >= N)
				answer = Math.max(answer, mid);

			if (sumShare >= N) {
				if (mid != Integer.MAX_VALUE) {
					lt = mid + 1;

				} else {
					return;
				}
			} else if (sumShare < N) {
				rt = mid - 1;
			}
			mid = rt + (lt - rt) / 2;
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		lineLAN = new int[K];
		answer = Integer.MIN_VALUE;
		// N개의 랜선 만들기
		// 제각각 길이의 K개 랜선을 같은 길이의 N개로 만들기

		// 공통된 길이를 갖는 N개의 랜선을 만들때, 그 공통된 길이가 최대 길이가 되는 것을 출력하기

		// 전체길이의 합에서 N으로 나누어 평균길이(avgLen)를 시작점으로 잡아보자
		// 각 랜선을 avgLen으로 나누어본다
		// 몫이 1이상이면 카운트에 더한다
		// 총 몫의 합의 N이상이 되었다면 굿
		// 만약 몫의 합이 N이상이 되지 못했다면 범위를 우로 줄인다
		// 만약 몫의 합이 N이하라면 범위를 좌로 줄인다
		int minLen = Integer.MAX_VALUE;
		int maxLen = 0;
		for (int i = 0; i < K; i++) {
			lineLAN[i] = Integer.parseInt(br.readLine());
			minLen = Math.min(minLen, lineLAN[i]);
			maxLen = Math.max(maxLen, lineLAN[i]);
		}

//		Arrays.sort(lineLAN);

		if (maxLen == 1) {
			bw.write(String.valueOf(1));
		} else {
			binarySearch(1, maxLen, (maxLen / 2));
			bw.write(String.valueOf(answer));
		}
		bw.flush();
	}

}

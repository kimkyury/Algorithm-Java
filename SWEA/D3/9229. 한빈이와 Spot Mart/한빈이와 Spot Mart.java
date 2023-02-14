
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {

	static int N, M;
	static int max;

	static void solution(int[] weight) {
		int[] result = new int[2];

		for (int i = 0; i < N - 1; i++) {
			for (int j = 1; j < N; j++) {

				if (i == j)
					continue;
				if (weight[i] + weight[j] <= M) {
					max = Math.max(max, weight[i] + weight[j]);
				}
			}
		}

//		combi(0, 0, weight, result);

	}

//	static void combi(int r, int index, int weight[], int[] result) {
//		if (index == 2) {
//			int sum = 0;
//			sum = result[0] + result[1];
//			System.out.println("show me value: " + sum);
//			if (sum < M) {
//				max = Math.max(max, sum);
//			}
//			return;
//		}
//
//		else if (r == N) {
//			return;
//		}
//
//		result[index] = weight[r];
//		combi(r + 1, index + 1, weight, result);
//		combi(r + 1, index, weight, result);
//
//	}

	public static void main(String args[]) throws Exception {

		//System.setIn(new java.io.FileInputStream("src/res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			// N개의 과자 중, M을 초과하지 않으면서 가장 큰 두 무게의 합을 구하기
			// plan1. 조합으로 두 개를 통해 만들 수 있는 합들을 저장함
			// 구한 것들 중 M을 초과하지 않는 max를 구함

			// N = 10^3 -> 10^3에 대해 2개를 뽑는 시행횟수?
			//

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 과자
			M = Integer.parseInt(st.nextToken()); // limit
			max = -1;
			// 중복되는 수가 있겠지만 사실 2개 초부턴 의미가 없음
			// 위에 경우는 일단 패스하자
			// 정렬이 필요할까? -> 이분탐색으로할까?
			// 두 개의 합 >= limit인 범위를 만나지 않도록 하면?

			int[] weight = new int[N];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}

			solution(weight);

			bw.write("#" + test_case + " " + String.valueOf(max) + '\n');
		}

		bw.flush();
	}
}

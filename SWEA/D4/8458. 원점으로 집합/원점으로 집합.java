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
	static int[][] poses;
	static int N;

	public static void main(String args[]) throws Exception {

		//System.setIn(new FileInputStream("res/input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {

//			맨해튼 거리: x, y 좌표 각각의 절대값

//
//			 누적합 - 최고값 이 가지는 의미 : (짝수-짝수, 홀수-홀수 를 의미함.)

//			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(br.readLine());

			poses = new int[N][2];
			int[] sumPos = new int[N];
			int maxSumPos = 0;
			// 1. 각 좌표들의 맨해튼 거리를 구한다
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				poses[i][0] = Integer.parseInt(st.nextToken());
				poses[i][1] = Integer.parseInt(st.nextToken());
				sumPos[i] = Math.abs(poses[i][0]) + Math.abs(poses[i][1]);
				maxSumPos = Math.max(maxSumPos, sumPos[i]);
			}

			int num = 0;
			int cnt = 0;

			// 2. 각 좌표들 모두가 홀수 이거나 짝수인 맨해튼 거리를 가지는지 확인한다
			boolean isEnd = false;
			int flag = sumPos[0] % 2;
			for (int i = 0; i < N; i++) {
				if (flag != (sumPos[i] % 2)) {
//					System.out.println("#" + t + " -1" + "\n");
					bw.write("#" + t + " -1" + "\n");
					isEnd = true;
					break;
				}
			}
			
			if ( isEnd) {
				continue;
			}

			int runningTotal = 0;

			int weight = 0;
			while (true) {
//				3. 가장 멀리 있는 점을 체크하여, 그 거리보다 큰 i를 찾도록 한다
//			    1. 가장 멀리 있는 점만 체크하는 이유는 다음과 같다
//			    : 나머지 작은 값들은 원점 주변에서 움직이다가 함께 이동하면 됨
				runningTotal += weight;

				if ((runningTotal >= maxSumPos) && (Math.abs(runningTotal - maxSumPos) % 2 == 0)) {

					break;

				}
				weight++;

			}

//			System.out.println("#" + t + " " + (weight) + "\n");
			bw.write("#" + t + " " + String.valueOf(weight) + "\n");

		}
		bw.flush();
	}
}

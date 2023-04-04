import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

	static BufferedReader br;
	static BufferedWriter bw;

	static ArrayList<ArrayList<int[]>> graph;
	static int N, M;

	static boolean isPassedUpper[];
	static boolean isPassedLower[];

	public static void main(String args[]) throws Exception {

		//System.setIn(new FileInputStream("res/input.txt"));
		 br = new BufferedReader(new InputStreamReader(System.in));
		 bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st ;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		int cnt;
		for (int t = 1; t <= T; t++) {
			cnt = 0;

			// 키가 작은 관계를 그래프로 나타냄
			// 그래프를 통해서, 자신의 키가 몇 번째인지 알 수 있을 수도 있고 없을 수도 있음
			// 알 수 있는 학생의 수를 리턴할 것임
			// 알 수 있는 경우 = 자기보다 큰값이 확실히 몇개고, 자기보다 작은값이 확실히 몇 개 인지 알 수 있을 때
			// 모르는 경우: 자신의 상단 노드가 또 다른 자식을 갖고 있을 때

			// 간선 정보를 ArrayList로 담자
			// 한 node에 연결된 놈들을 Queue에 담고
			// 꺼냈을 때 나보다 작은 놈이면 -> 아랫에로 체킹
			// 꺼냈을 떄 나보다 큰 놈이면 -> 큰놈으로 체킹
			// 근데. 그렇게 해서 잰 놈들의 수가 N-1개라면 난 알 수 있는 거고
			// N-1개가 아니라면 걘 알 수 없는 애고
			graph = new ArrayList<>();
			isPassedUpper = new boolean[N + 1];
			isPassedLower = new boolean[N + 1];

			N = Integer.parseInt(br.readLine());

			for (int i = 0; i <= N; i++) {
				graph.add(new ArrayList<int[]>());
			}

			M = Integer.parseInt(br.readLine());

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				// v1= 작은키
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());

				int[] v2Info = { v2, 1 }; // 1: 큰 놈이란 뜻
				int[] v1Info = { v1, 0 }; // 0: 작은 놈이란 뜻
				graph.get(v1).add(v2Info);
				graph.get(v2).add(v1Info);

			}

			for (int i = 1; i <= N; i++) {
				isPassedUpper = new boolean[N + 1];
				isPassedLower = new boolean[N + 1];

				if (func(i))
					cnt++;
			}

			bw.write("#" + t + " " + cnt + "\n");
		}
		bw.flush();
	}

	static boolean func(int v) {

		int cnt = 0;
		Queue<Integer> biggerQ = new LinkedList<>();
		Queue<Integer> smallerQ = new LinkedList<>();
		ArrayList<int[]> connectV = graph.get(v);

		// 연결된 애가 하, 상에 따라서 구분되도록 q에 넣자
//		System.out.print("--------------\n" + v + "에 연결된 V들: ");
		for (int i = 0; i < connectV.size(); i++) {
			cnt++;
			int[] tmpV = connectV.get(i);
//			System.out.println(tmpV[0]  + "카운팅");

//			System.out.print("(" + tmpV[0] + ", " + tmpV[1] + ")");
			if (tmpV[1] == 1) {
				isPassedUpper[tmpV[0]] = true;
				biggerQ.offer(tmpV[0]);
			} else {
				isPassedLower[tmpV[0]] = true;
				smallerQ.offer(tmpV[0]);
			}
		}
//		System.out.println("");

		// 자기보다 큰 것들에 대해서 카운팅
		// 1. 5에 연결된 것들 중 tmpVinfo[1] =1인 것들을 q에 다 담음
		// 2. 꺼내면서 cnt ++;
		// 동시에 tmpVInfo[0]에 대해 연결된 간선들을 넣어줌
		// 단, 그때 tmp- tmpInfo[1] = 1이여야 함

		while (!biggerQ.isEmpty()) {
			int nV = biggerQ.poll();
			connectV = graph.get(nV);

			for (int i = 0; i < connectV.size(); i++) {
				int[] tmpV = connectV.get(i);
				if (isPassedUpper[tmpV[0]])
					continue;

				if (tmpV[1] == 1) {
					isPassedUpper[tmpV[0]] = true;
//					System.out.println(tmpV[0]  + "카운팅");
					cnt++;
					biggerQ.offer(tmpV[0]);
				}
			}
		}

		// 자기보다 작은 것들에 대해서 카운팅
		// 1. 5에 연결된 것들 중 tmpVinfo[0] = 0인 것들을 q에 다 담음
		// 2. 꺼내면서 cnt++;
		// 동시에 tmpVinfo[0]에 대해 연결된 간선들을 넣어줌
		// 단, tmpVinfo[1] = 0이여야 함
		while (!smallerQ.isEmpty()) {
			int nV = smallerQ.poll();
			connectV = graph.get(nV);

			for (int i = 0; i < connectV.size(); i++) {
				int[] tmpV = connectV.get(i);
				if (isPassedLower[tmpV[0]])
					continue;

				if (tmpV[1] == 0) {
					isPassedLower[tmpV[0]] = true;
//					System.out.println(tmpV[0]  + "카운팅");
					cnt++;
					smallerQ.offer(tmpV[0]);
				}
			}
		}

//		System.out.println(v + ": " + cnt);

		if (cnt < N - 1) {
			return false;
		}
		return true;
	}

}
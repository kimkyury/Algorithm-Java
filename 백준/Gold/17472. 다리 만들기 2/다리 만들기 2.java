import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	// ---- for Problem
	static int bridgeCnt = 1;
	static int N, M;
	static int[][] map;
//	static int[][] numMap;
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	static int[] parent;
	static PriorityQueue<int[]> pq;

	public static void setMapInfo(int y, int x) {

		int nx = 0, ny = 0;

		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1)
				continue;
			if (map[ny][nx] == bridgeCnt)
				continue;
			if (map[ny][nx] == -1) {
				map[ny][nx] = bridgeCnt;
				setMapInfo(ny, nx);
			}
		}
	}

	// 해당 좌표에서 직선으로 나아갈 때, 다른 곳과 마주치면 ++
	public static void connect(int y, int x) {

		int startNum = map[y][x];

		int ny = 0, nx = 0;
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];

			if (ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1)
				continue;

			if (map[ny][nx] == 0) {
				// 해당 섬에서 가장 가까운 0 발견시, 브릿지 건설하러 가
				int cost = 0;
				while (true) {
					ny += dy[i];
					nx += dx[i];
					cost++;

					if (ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1)
						break;
					if (map[ny][nx] == startNum)
						break;

					if (map[ny][nx] != 0) {

						if (cost >= 2) {
							// 기저조건 : 다른 섬을 만났을
							int endNum = map[ny][nx];
							int[] temp = { startNum, endNum, cost };
							pq.offer(temp);
						}
						break;
					}

				}
			}
		}
	}

	public static int kruskal() {

		for (int i = 1; i <= bridgeCnt; i++) {
			parent[i] = i;
		}

		int totalCost = 0;
		int connectCnt = 0;

		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();

			int parent1 = findParent(tmp[0]);
			int parent2 = findParent(tmp[1]);

			// 같은 집합이 아닌 것들에 대하여 최소 간선비용 더하기
			if (parent1 != parent2) {
				union(parent1, parent2);
				totalCost += tmp[2];
				connectCnt++;
			}

		}

		if (totalCost == 0 || connectCnt != bridgeCnt - 2) {
			return -1;
		} else {
			return totalCost;
		}
	}

	public static void union(int v1, int v2) {

		v1 = parent[v1];
		v2 = parent[v2];

		parent[v2] = v1;

	}

	public static int findParent(int v1) {
		if (v1 == parent[v1]) {
			return v1;
		}
		return parent[v1] = findParent(parent[v1]);
	}

	public static void main(String[] args) throws Exception {

		// 섬 표시하기
		// 한 섬에서 직선탐색할때, 다른 숫자와 닿으면 최단거리로 갱신하기
		// 연결 여부를 true로 표시할 것

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 1)
					map[i][j] = -1;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1) {
					map[i][j] = bridgeCnt;
					setMapInfo(i, j);
					bridgeCnt++;
				}
			}
		}
//		show(map);

		pq = new PriorityQueue<>((o1, o2) -> {
			return o1[2] - o2[2];
		});
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					connect(i, j);
				}
			}
		}
//		show(pq);

		// Kruskal, Union-find
		parent = new int[bridgeCnt + 1];
		int answer = kruskal();
		bw.write(String.valueOf(answer));
		bw.flush();

	}

	// ----------- for debug log
	static public void show(int[][] arr) {
		System.out.println("-------------------");
		for (int[] ar : arr) {
			for (int a : ar)
				System.out.print(a + " ");

			System.out.println("");
		}
	}

	static public void show(PriorityQueue<int[]> q) {

		Iterator<int[]> iter = q.iterator();

		while (iter.hasNext()) {
			int[] temp = iter.next();
			System.out.println("startV: " + temp[0] + ", endV: " + temp[1] + ", cost: " + temp[2]);
		}

	}

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point {

	int x;
	int y;
	int cost;

	Point(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}

class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int T;
	static int N;
	static int[][] map;
	static int[][] dp;

	static int dy[] = { -1, 0, 1, 0 };
	static int dx[] = { 0, 1, 0, -1 };
	static int min;
	static boolean[][] isPassed;

	public static void bfs(int y, int x) {
		// 시작점

		PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		isPassed[y][x] = true;
		pq.offer(new Point(y, x, map[y][x]));

		while (!pq.isEmpty()) {
			Point curP = pq.poll();

//			System.out.println(curP.x + " " + curP.y + " " + curP.cost);

			if (curP.cost > min)
				continue;
			if (curP.x == N - 1 && curP.y == N - 1) {
				min = Math.min(min, curP.cost);
			}

			Point tmpP;
			for (int i = 0; i < 4; i++) {
				int nx = curP.x + dx[i];
				int ny = curP.y + dy[i];

				if (nx < 0 || ny < 0 || ny > N - 1 || nx > N - 1)
					continue;
				if (isPassed[ny][nx])
					continue;

				isPassed[ny][nx] = true;
				tmpP = new Point(nx, ny, curP.cost + map[ny][nx]);
				pq.offer(tmpP);
//				isPassed[nx][ny] = false;
			}

		}

	}

	public static void show(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println("");
		}
	}

	public static void show(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println("");
	}

	public static void main(String args[]) throws Exception {

		//System.setIn(new FileInputStream("res/input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			min = Integer.MAX_VALUE;
			isPassed = new boolean[N][N];
			String str;
			for (int i = 0; i < N; i++) {
				str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

//			show(map);
			bfs(0, 0);

			bw.write("#" + test_case + " " + min + "\n");
			bw.flush();

		}
	}

}
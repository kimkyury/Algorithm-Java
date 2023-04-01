import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static StringBuilder sb;
	static StringTokenizer st;

	static int[][] map;
	static boolean[][] isPassed;
	static int N, M;

	static int preCnt = 0;
	static int cnt = 0;
	static int cycleCnt = -1;

	static int dy[] = { 0, 1, 0, -1 };
	static int dx[] = { 1, 0, -1, 0 };

	public static void show(int[][] arr) {

		System.out.println("---------------start");
		for (int[] ar : arr) {
			for (int a : ar)
				System.out.print(a + " ");
			System.out.println("");
		}
	}

	public static void melt(Queue<int[]> borders) {
		preCnt = borders.size();

		while (!borders.isEmpty()) {
			int[] tmp = borders.poll();
			cnt--;
			map[tmp[0]][tmp[1]] = 0;
		}
	}

	public static Queue<int[]> findCheeseBorder() {
		cycleCnt++;
		isPassed = new boolean[N][M];

		Queue<int[]> q = new ArrayDeque<>();
		Queue<int[]> newBorders = new ArrayDeque<>();

		q.add(new int[] { 0, 0 });
		while (!q.isEmpty()) {

			int[] border = q.poll();

			int ny, nx;
			for (int i = 0; i < 4; i++) {
				ny = border[0] + dy[i];
				nx = border[1] + dx[i];

				if ( ny < 0 || nx <0 || ny > N-1 || nx > M-1) continue;
				if (isPassed[ny][nx])
					continue;

				isPassed[ny][nx] = true;
				int[] pos = { ny, nx };
				if (map[ny][nx] == 1) {
					newBorders.offer(pos);
				} else {
					q.offer(pos);
				}
			}
		}

		return newBorders;

	}

	public static void main(String[] args) throws IOException {

		// DP로 풀 수 있을까?
		// ... 점화식이 나오겠어?

		// BFS

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // row
		M = Integer.parseInt(st.nextToken()); // col

		map = new int[N][M];
		isPassed = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					cnt++;
				}

			}
		}
		
		Queue<int[]> border = new ArrayDeque<>();
		
		while(cnt != 0) {
			melt(border);
			border = findCheeseBorder();
		}

		

		bw.write(String.valueOf(cycleCnt) + "\n");
		bw.write(String.valueOf(preCnt) + "\n");

		bw.flush();
		// cycle체킹, cnt == 0이 었을 때의 q.size() 반납

	}
}

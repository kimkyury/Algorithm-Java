import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N, M;
	static int[][] map;
	static boolean[][] isPassed;

	static boolean isCan;
	static int limitCnt;
	static int minDays;
	static int dy[] = { -1, 0, 1, 0 };
	static int dx[] = { 0, 1, 0, -1 };

	public static void bfs(ArrayList<int[]> agingTomatos) {

		Queue<int[]> q = new LinkedList<>();

		for (int[] agingTomato : agingTomatos) {
			q.offer(agingTomato);
			isPassed[agingTomato[0]][agingTomato[1]] = true;
		}

		// init 숙성토마토수
		int cnt = agingTomatos.size();
		int days = -1;
		isCan = false;
		while (!q.isEmpty()) {
			days++; // 이하로 하루동안 일어나는 일들

			if (cnt == limitCnt) {
				isCan = true;
				minDays = days;
				break;
			}

			int size = q.size();
			for (int i = 0; i < size; i++) {

				// 한 익은 토마토에 대해서 전염시킬 곳을 찾아 Q에 넣는다
				int[] curPos = q.poll();

				for (int j = 0; j < 4; j++) {
					int ny = curPos[0] + dy[j];
					int nx = curPos[1] + dx[j];

					// for가독성
					if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1)
						continue;
					if (map[ny][nx] != 0) // 안 익은 토마토에 대해서만 수행하도록
						continue;
					if (isPassed[ny][nx])
						continue;

					isPassed[ny][nx] = true; // 검사한 곳인지 체킹

					int[] tomato = { ny, nx };
					q.offer(tomato);
					cnt++; // q에 넣는다 == 숙성시켰다 라는 의미
				}
			}
		}
	}

	public static void show(int[][] arr) {

		for (int[] ar : arr) {
			for (int a : ar) {
				System.out.print(a + " ");
			}
			System.out.println("");
		}
	}

	public static void show(boolean[][] arr) {
		System.out.println("---------");
		for (boolean[] ar : arr) {
			for (boolean a : ar) {

				if (a == true)
					System.out.print("1" + " ");
				else
					System.out.print("0" + " ");
			}
			System.out.println("");
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		isPassed = new boolean[M][N];
		minDays = Integer.MAX_VALUE;
		limitCnt = 0;
		int zeroCnt = 0; // 전염 필요 여부 판독
		ArrayList<int[]> agingTomatos = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {

				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				// 시작점이 될 곳들 담기
				if (value == 1) {
					int[] tmp = { i, j }; // y, x
					agingTomatos.add(tmp);
				}

				if (value != -1) {
					limitCnt++;
				}

				if (value == 0) {
					zeroCnt++;
				}
			}
		}

		if (zeroCnt == 0) {

			bw.write(String.valueOf(0) + "\n");
			bw.flush();
			return;
		} else
			bfs(agingTomatos);

		if (isCan)
			bw.write(String.valueOf(minDays) + "\n");
		else
			bw.write(String.valueOf(-1) + "\n");
		bw.flush();
	}
}

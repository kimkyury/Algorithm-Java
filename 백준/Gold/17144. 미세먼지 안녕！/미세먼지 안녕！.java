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

	static int N, M, T;
	static int[][] map;
	static int[][] resultM;
	static boolean[][] isPassed;
	static int[] lowerCleanser;

	static int dy[] = { -1, 0, 1, 0 };
	static int dx[] = { 0, 1, 0, -1 };

	// BFS
	public static void diffusionDust(ArrayList<int[]> dusts) {

		Queue<int[]> q = new LinkedList<>();

		for (int[] dust : dusts) {
			q.offer(dust);
		}

		while (!q.isEmpty()) {

			int size = q.size();

			// 모든 먼지작동
			for (int i = 0; i < size; i++) {

				int[] tmpDust = q.poll();
				int amountDust = tmpDust[2] / 5;
//				System.out.print(tmpDust[0] + " " + tmpDust[1] + ",  ");
//				System.out.print("amount: " + amountDust + " ");

				if (amountDust == 0) {
					// 가지치기, 확산 시킬만큼의 최소량도없으면 사방탐색할 필요는 없음
					resultM[tmpDust[0]][tmpDust[1]] += tmpDust[2];
					continue;
				}
				// 4방탐색 -> 먼지 분산시키기
				int cnt = 0;
				for (int j = 0; j < 4; j++) {

					int ny = tmpDust[0] + dy[j];
					int nx = tmpDust[1] + dx[j];

					if (ny < 0 || nx < 0 || nx > M - 1 || ny > N - 1)
						continue;

					// 공기청정기에 닿는 경우 처리해주기
					if (ny == lowerCleanser[0] && nx == lowerCleanser[1])
						continue;
					else if (ny == (lowerCleanser[0] - 1) && nx == lowerCleanser[1])
						continue;

					resultM[ny][nx] += amountDust;
					cnt++;
//					tmpDust[2] -= amountDust; // 남는 양 Check

				}
				// 앞에서 뿌리고 남은 것만큼을 담아주기
//				System.out.print("cnt: " + cnt + " \n");
				resultM[tmpDust[0]][tmpDust[1]] += tmpDust[2] - cnt * amountDust;
			}

//			show(resultM); // 분산과정 확인

		}

	}

	public static void runCleanser() {
		// 윗부분 순환시키기
		int[] highCleanser = { lowerCleanser[0] - 1, lowerCleanser[1] };
		int tmp = resultM[highCleanser[0]][highCleanser[1]];
		int ny = highCleanser[0];
		int nx = highCleanser[1];

		// 좌 : 상향, y변화

		for (int i = ny - 1; i > 0; i--) {
			resultM[i][nx] = resultM[i - 1][nx];
		}
		resultM[ny][nx] = 0; // 공기청정기가 먹는 부분

		// 상 : 우향 x변화
		for (int i = nx; i < M - 1; i++) {
			resultM[0][i] = resultM[0][i + 1];
		}

		// 우 : 하향 y변화
		for (int i = 0; i < ny; i++) {
			resultM[i][M - 1] = resultM[i + 1][M - 1];
		}

		// 하 : 좌향 x변화
		for (int i = M - 1; i > 0; i--) {
			resultM[ny][i] = resultM[ny][i - 1];
		}

		// confirm
//		resultM[ny][nx + 1] = tmp;
//		show(resultM);

		// 아랫부분 순환시키기

		tmp = resultM[lowerCleanser[0]][lowerCleanser[1]];
		ny = lowerCleanser[0];
		nx = lowerCleanser[1];

		// 좌 : 하향, y변화
		for (int i = ny + 1; i < N - 1; i++) {
			resultM[i][nx] = resultM[i + 1][nx];
		}
		resultM[ny][nx] = 0; // 공기청정기가 먹는 부분

		// 하 : 우향 x변화

		for (int i = 0; i < M - 1; i++) {
			resultM[N - 1][i] = resultM[N - 1][i + 1];
		}

		// 우 : 상향 y변화
		for (int i = N - 1; i > ny; i--) {
			resultM[i][M - 1] = resultM[i - 1][M - 1];
		}

		// 상 : 좌향 x변화
		for (int i = M - 1; i > 0; i--) {
			resultM[ny][i] = resultM[ny][i - 1];

		}

		// 공기청정기 부분은 reset

//		resultM[ny+1][nx] = tmp;
//		show(resultM);
	}

	public static void show(ArrayList<int[]> arr) {

		System.out.println("-----------------");
		for (int[] ar : arr) {
			for (int a : ar) {
				System.out.print(a + " ");
			}
			System.out.println("");
		}

	}

	public static void show(int[][] arr) {

		System.out.println("-----------------");
		for (int[] ar : arr) {
			for (int a : ar)
				System.out.print(a + " ");
			System.out.println("");
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		ArrayList<int[]> dusts = new ArrayList<>();

		map = new int[N][M];
		resultM = new int[N][M];

		lowerCleanser = new int[2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {

				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;

				if (value == -1) { // cleanser의 아랫부분이 담길 것임, 그럼 윗부분은 (i-1, j)
					lowerCleanser[0] = i;
					lowerCleanser[1] = j;
				} else if (value > 0) {
					int[] dust = { i, j, value };
					dusts.add(dust);
				}
			}
		}
//		show(dusts);
//		show(map);

		// TODO: 아래의 두 함수를 T번 반복
		// 돌수록 감소되는 이유: 먼지가 공기청정기한테 먹혔기 때문임. 이 경우를 감소시켜줘야하는데.
		for (int t = 0; t < T; t++) {
			// 미세먼지 확산
			diffusionDust(dusts);
			// 청정기를 통한 확산
			runCleanser();

			dusts = new ArrayList<>();

			// resutM 을 map으로 복사넣기
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int value = resultM[i][j];
					map[i][j] = value;
					if (value > 0) {
						int tmp[] = { i, j, value };
						dusts.add(tmp);
					}
				}
			}
//			System.out.print("----result----");
//			show(resultM);

//			System.out.print("----map----");
//			show(map);
			if (t == T - 1)
				break;

			resultM = new int[N][M];

		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum += resultM[i][j];
			}
		}

		bw.write(String.valueOf(sum));
		bw.flush();

	}
}

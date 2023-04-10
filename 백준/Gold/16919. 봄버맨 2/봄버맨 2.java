import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	// ------------for problem
	static char[][] map;

	static int[][] log;

	static int cnt = 0;
	static int timeCnt = 0;
	static int N, M, limitTime;

	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };

	static Queue<int[]> q;

	public static void countDown() {

//		show(log);
		if (timeCnt == limitTime) {
			return;
		}

		// 해당 숫자들 감소
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (log[i][j] == 1) {
					int[] temp = { i, j };
					q.offer(temp);
				} else if (log[i][j] == 0)
					continue;
				log[i][j]--;

			}
		}

		if (q.size() == 0) {
			// 폭탄채우러가기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (log[i][j] == 0) {
						log[i][j] = 3;
					}
				}
			}
		}
		while (!q.isEmpty()) {

			int[] tmp = q.poll();
			int ny, nx;
			log[tmp[0]][tmp[1]] = 0;
			for (int i = 0; i < 4; i++) {
				ny = tmp[0] + dy[i];
				nx = tmp[1] + dx[i];

				if (ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1) {
					continue;
				}

				log[ny][nx] = 0;

			}
		}

		timeCnt++;
		countDown();

	}

	public static void main(String[] args) throws Exception {

		// 1초 : 입력상태
		// 2초: 다 차있음
		// 3초: 입력상태 기준으로 사방이 '.' 표시
		// 4초: 원본상태

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		limitTime = Integer.parseInt(st.nextToken());
		log = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {

				char value = str.charAt(j);
				if (value == 'O') {
					log[i][j] = 3;
				}
			}
		}

		timeCnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (log[i][j] == 0)
					continue;
				log[i][j]--;

			}
		}
		
		

		q = new LinkedList<>();
		
		if ( limitTime >4 ) {
			limitTime = 4 + limitTime % 4;
//			System.out.println(limitTime);
			countDown();
		}else if (limitTime >= 2 ) {
			countDown();
		}
		

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (log[i][j] > 0) {
					System.out.print('O');
				} else {
					System.out.print('.');
				}
			}
			System.out.println("");
		}

		bw.flush();
	}

	// --------------for debug log
	public static void show(int[][] arr) {
		System.out.println("time: " + timeCnt);
		for (int ar[] : arr) {
			for (int a : ar)
				System.out.print(a + " ");
			System.out.println("");
		}
	}

	public static void show(char[][] arr) {

		for (char ar[] : arr) {
			for (char a : ar)
				System.out.print(a + " ");
			System.out.println("");
		}
	}
}

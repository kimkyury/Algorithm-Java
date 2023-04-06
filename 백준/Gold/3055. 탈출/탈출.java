import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 17472 다리 만들기 2
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static StringBuilder sb;
	static StringTokenizer st;

	// ------------- Variable for Problem ------------
	static int R, C;
	static char[][] map;
	static boolean[][] isPassed;
	static int[] sPos;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	static Queue<int[]> water;
	static int min = Integer.MAX_VALUE;

	static char[][] newMap;
	static Iterator<int[]> iter;
	static Queue<int[]> newQ;


	public static void func() {
		// y, x == 도치 위치
		int cnt = 0;
		Queue<int[]> dochi = new LinkedList<>();
		dochi.add(sPos);

		
		
		
		while (true) {
			
			if ( water.isEmpty() && dochi.isEmpty()) break;

			// 1. 물이 한 번 번짐 ( 번지는 곳을 *로 체킹)
			int size = water.size();
			for (int i = 0; i < size; i++) {

				int[] waterPos = water.poll();
				int ny, nx;

				for (int j = 0; j < 4; j++) {
					ny = waterPos[0] + dy[j];
					nx = waterPos[1] + dx[j];

					if (ny < 0 || nx < 0 || ny > R - 1 || nx > C - 1)
						continue;

					if (map[ny][nx] == '.') {
						map[ny][nx] = '*';
						int[] tmp = { ny, nx };
						water.offer(tmp);
					}
				}
			}
			cnt++;

//			show(map);
			
			// 이제 도치 탐색
			int dSize = dochi.size();
			for (int k = 0; k < dSize; k++) {
				int[] tmp = dochi.poll();

				int ny, nx;
				for (int i = 0; i < 4; i++) {
					ny = tmp[0] + dy[i];
					nx = tmp[1] + dx[i];

					if (ny < 0 || nx < 0 || ny > R - 1 || nx > C - 1)
						continue;
					if (isPassed[ny][nx])
						continue;

					if (map[ny][nx] == 'D') {
						min = Math.min(min, cnt);
						return;
					} else if (map[ny][nx] == '.') {
						isPassed[ny][nx] = true;
						int[] tmpPos = { ny, nx };
						dochi.offer(tmpPos);
					}
				}
			}
			
			
			
			
		}
	}

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		sPos = new int[2];

		isPassed = new boolean[R][C];
		water = new LinkedList<>();

		// 동굴:D(목적지)
		// 고슴도치: S(시작점)
		for (int i = 0; i < R; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				char tmp = arr[j];
				if (tmp == '*') {
					int[] waterPos = { i, j };
					water.offer(waterPos);
				} else if (tmp == 'S') {
					sPos[0] = i;
					sPos[1] = j;
				}
				map[i][j] = tmp;
			}
		}

		isPassed[sPos[0]][sPos[1]] = true;
		func();

		if (min == Integer.MAX_VALUE)
			bw.write("KAKTUS" + "\n");
		else
			bw.write(String.valueOf(min) + "\n");
		bw.flush();
	}

	// ------------- Log for Debug -------------
	public static void show(int[][] arr) {
		System.out.println("----------------");
		for (int[] ar : arr) {
			for (int a : ar)
				System.out.print(a + " ");
			System.out.println("");
		}
	}

	public static void show(char[][] arr) {
		System.out.println("----------------");
		for (char[] ar : arr) {
			for (char a : ar)
				System.out.print(a + " ");
			System.out.println("");
		}
	}

	public static void show(TreeSet<Integer> set) {
		System.out.println("----------------");
		Iterator<Integer> iter = set.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println("");
	}
}

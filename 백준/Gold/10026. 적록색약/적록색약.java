import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Point {
	int y;
	int x;

	Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {

	static int N;
	static char[][] map;
	static int[][] isPassed0; // for not 적록색맹
	static int[][] isPassed1; // for 적록색맹
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	public static void dfs(Point p, char color, int type) {

		if (p.x == N - 1 && p.y == N - 1) {
			return;
		}

		int nx, ny;
		Point tmpP;
		for (int i = 0; i < 4; i++) {
			ny = p.y + dy[i];
			nx = p.x + dx[i];
			tmpP = new Point(ny, nx);

			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;

			// R and G is Combined, for 적록색맹의 특수경우 예외처리
			if (type == 1) {
				if (color == 'R') {
					if (isPassed1[tmpP.y][tmpP.x] == 0 && (map[tmpP.y][tmpP.x] == 'R' || map[tmpP.y][tmpP.x] == 'G')) {
						isPassed1[tmpP.y][tmpP.x]=1; 
						dfs( tmpP, 'R', 1);
					}

				}else {
					if (isPassed1[tmpP.y][tmpP.x] == 0 && map[tmpP.y][tmpP.x] == 'B') {
						isPassed1[tmpP.y][tmpP.x]=1; 
						dfs( tmpP, 'B', 1);
					}
				}

			}else if (type == 0) {
				if (isPassed0[tmpP.y][tmpP.x] == 0 && map[tmpP.y][tmpP.x] == color) {
					isPassed0[tmpP.y][tmpP.x]=1; 
					dfs( tmpP, color, 0);
				}
			}

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		isPassed0 = new int[N][N];
		isPassed1 = new int[N][N];

//		StringTokenizer st;
		String line;
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		// index:0 -> not 적록색맹 index:1 -> 적록생맹
		int[] cntRrange = new int[2];
		int cntGrange = 0; // target: NOT 적록색맹
		int[] cntBrange = new int[2];

		Point tmp;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp = new Point(i, j);
				if (isPassed0[i][j] == 0) {
					isPassed0[i][j] =1;
					if (map[i][j] == 'R') {
						cntRrange[0]++;
						dfs(tmp, 'R', 0);
					} else if (map[i][j] == 'G') {
						cntGrange++;
						dfs(tmp, 'G', 0);
					} else if (map[i][j] == 'B') {
						cntBrange[0]++;
						dfs(tmp, 'B', 0);
					}
				}

				if (isPassed1[i][j] == 0) {
					isPassed1[i][j] =1;
					if (map[i][j] == 'R' || map[i][j] == 'G') {
						cntRrange[1]++;
						dfs(tmp, 'R', 1); // G is Combined 'R'
					} else if (map[i][j] == 'B') {
						cntBrange[1]++;
						dfs(tmp, 'B', 1);
					}
				}

			}

		}

		int answer0 = cntRrange[0] + cntGrange + cntBrange[0];
		int answer1 = cntRrange[1] + cntBrange[1];

		bw.write(String.valueOf(answer0) + " ");
		bw.write(String.valueOf(answer1) + "\n");

		bw.flush();
	}
}

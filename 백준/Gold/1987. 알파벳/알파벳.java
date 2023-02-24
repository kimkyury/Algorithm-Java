import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, R, C;

	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	static boolean[] isPassedChar = new boolean[26];
	static char[][] arr;
	static int maxCnt = 1;

	// 우, 하, 우하
	//
	public static void solve(int sx, int sy, int ex, int ey) {
	}

	public static void dfs(int y, int x, int cnt) {
		// System.out.println(x + ", " + y + ": " + arr[y][x] + " " + cnt);

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			// System.out.print("here!!!!");
			if (nx < 0 || ny < 0 || nx >= C || ny >= R) {
				// System.out.print("here!!!!" + nx + " " + ny);
				// System.out.print("끝" + "\n");
				continue;
			}

			char tmp = arr[ny][nx];
			if (isPassedChar[tmp - '0' - 17]) {
				// System.out.print(ny + " " + nx + " " + tmp + ":중복, back" + "\n");
				continue;
			} else {
				isPassedChar[tmp - '0' - 17] = true;
				maxCnt = Math.max(maxCnt, cnt + 1);
				dfs(ny, nx, cnt + 1);
				isPassedChar[tmp - '0' - 17] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		// A : 'A'-'0'-17 = 0
		// Z : 'Z'-'0'-17 = 25
		// System.out.print(('A' - '0') + " " + ('Z' - '0'));

		String str;
		for (int i = 0; i < R; i++) {
			str = br.readLine();
			for (int j = 0; j < C; j++)
				arr[i][j] = str.charAt(j);
		}

		isPassedChar[arr[0][0] - '0' - 17] = true;
		dfs(0, 0, 1);

		bw.write(String.valueOf(maxCnt));
		bw.flush();
	}
}

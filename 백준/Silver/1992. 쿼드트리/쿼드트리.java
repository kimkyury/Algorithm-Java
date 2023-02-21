
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N;
	static int[][] quad;
	static StringBuilder sb = new StringBuilder();

	public static void solve(int index, int cnt) {

	}

	public static void check(int sy, int sx, int ey, int ex) {
		// x : sx, (sx+ex)/2, ex
		// y : sy, (sy+ey)/2, ey
		int initV = quad[sy][sx];
		if (ey - sy == 1) {
			sb.append(initV);
			return;
		}

		boolean isFullFill = true;

		for (int i = sy; i < ey; i++) {
			for (int j = sx; j < ex; j++) {
				if (quad[i][j] != initV)
					isFullFill = false;

			}
			if (!isFullFill) {
				break;
			}
		}

		if (!isFullFill) {
			int my = (sy + ey) / 2;
			int mx = (sx + ex) / 2;
			sb.append("(");
			check(sy, sx, my, mx);
			check(sy, mx, my, ex);
			check(my, sx, ey, mx);
			check(my, mx, ey, ex);

			sb.append(")");
			return;
		} else {
			sb.append(initV);
		}

	}

	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(br.readLine());

		quad = new int[N][N];

		String line;
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			for (int j = 0; j < N; j++) {
				quad[i][j] = line.charAt(j) - '0';
			}
		}

		check(0, 0, N, N);

		bw.write(sb.toString());
		bw.flush();
		// 사분할 영역을 체크하러 간다

	}

}

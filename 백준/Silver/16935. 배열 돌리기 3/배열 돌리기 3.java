import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	// ------------for problem
	static int N, M;
	static int[][] map;
//    static int [][] tmp;

	// 상하 반전
	public static int[][] turn1(int[][] arr) {

		int ret[][] = new int[N][M];

		for (int i = 0; i < N; i++)
			ret[(N - 1) - i] = arr[i].clone();

		return ret;
	}

	// 좌우반전
	public static int[][] turn2(int[][] arr) {

		int ret[][] = new int[N][M];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				ret[j][i] = arr[j][(M - 1) - i];
			}
		}

		return ret;
	}

	// right 90도 회전
	public static int[][] turn3(int[][] arr) {

		int ret[][] = new int[arr[0].length][arr.length];

//        ret[0][2] = arr[0][0];
//        ret[1][2] = arr[0][1];
//        ret[2][2] = arr[0][2];

		// 상 -> 우
		int i = 0;
		for (int col = 0; col < arr.length; col++) { // 원본의 ""한 행에 대한 열"" 을
			for (int row = 0; row < ret.length; row++) { // 새 배열의 ""한 열에 대한 행"" 으로

//                System.out.println("(" + row + ", " + (ret.length-1-row) + "), (" + col + ", " + row + ")");
				ret[row][ret[0].length - 1 - col] = arr[col][row];
			}
		}

		return ret;
	}

	// left 90도 회전
	public static int[][] turn4(int[][] arr) {

		int ret[][] = new int[arr[0].length][arr.length];

//        ret[2][0] = arr[0][0];
//        ret[1][0] = arr[0][1];
//        ret[0][0] = arr[0][2];

		// 상 -> 좌
		int i = 0;
		for (int col = 0; col < arr.length; col++) { // 원본의 ""한 행에 대한 열"" 을
			for (int row = 0; row < ret.length; row++) { // 새 배열의 ""한 열에 대한 행"" 으로

//                System.out.println("(" + row + ", " + (ret.length-1-row) + "), (" + col + ", " + row + ")");
				ret[ret.length - 1 - row][col] = arr[col][row];
			}
		}

		return ret;
	}

	// 4분할 이후, 시계방향 이동
	public static int[][] turn5(int[][] arr) {

		int yLen = arr.length;
		int xLen = arr[0].length;

		// 2사분면, 3사분면, 4사분면, 1사분면 순 할당
		int section2[][] = divideArr(arr, 0, 0, yLen / 2, xLen / 2); // 2사분면
		int section3[][] = divideArr(arr, yLen / 2, 0, yLen, xLen / 2); // 3사분면
		int section4[][] = divideArr(arr, yLen / 2, xLen / 2, yLen, xLen); // 4사분면
		int section1[][] = divideArr(arr, 0, xLen / 2, yLen / 2, xLen); // 1사분면

		int tmpSection[][] = new int[yLen / 2][xLen / 2];
		int ret[][] = new int[N][M];

		// 2사분면, 3사분면, 4사분면, 1사분면 순으로 채우기
		int ny = 0, nx;
		for (int i = 0; i < yLen / 2; i++) {
			nx = 0;
			for (int j = 0; j < xLen / 2; j++) {
				ret[i][j] = section3[ny][nx]; // 2사분면 <- 3사분면
				nx++;
			}
			ny++;
		}

		ny = 0;
		nx = 0;
		for (int i = yLen / 2; i < yLen; i++) {
			nx = 0;
			for (int j = 0; j < xLen / 2; j++) {
				ret[i][j] = section4[ny][nx]; // 3사분면 <- 4사분면
				nx++;
			}
			ny++;
		}

		ny = 0;
		nx = 0;
		for (int i = yLen / 2; i < yLen; i++) {
			nx = 0;
			for (int j = xLen / 2; j < xLen; j++) {
				ret[i][j] = section1[ny][nx];
				nx++;
			}
			ny++;
		}

		ny = 0;
		nx = 0;
		for (int i = 0; i < yLen / 2; i++) {
			nx = 0;
			for (int j = xLen / 2; j < xLen; j++) {
				ret[i][j] = section2[ny][nx];
				nx++;
			}
			ny++;
		}

		return ret;
	}

	// 4분할 이후, 반시계방향 이동
	public static int[][] turn6(int[][] arr) {

		int yLen = arr.length;
		int xLen = arr[0].length;

		// 2사분면, 3사분면, 4사분면, 1사분면 순 할당
		int section2[][] = divideArr(arr, 0, 0, yLen / 2, xLen / 2); // 2사분면
		int section3[][] = divideArr(arr, yLen / 2, 0, yLen, xLen / 2); // 3사분면
		int section4[][] = divideArr(arr, yLen / 2, xLen / 2, yLen, xLen); // 4사분면
		int section1[][] = divideArr(arr, 0, xLen / 2, yLen / 2, xLen); // 1사분면

		int tmpSection[][] = new int[yLen / 2][xLen / 2];
		int ret[][] = new int[N][M];

		// 2사분면, 3사분면, 4사분면, 1사분면 순으로 채우기
		int ny = 0, nx;
		for (int i = 0; i < yLen / 2; i++) {
			nx = 0;
			for (int j = 0; j < xLen / 2; j++) {
				ret[i][j] = section1[ny][nx]; // 2사분면 <- 3사분면
				nx++;
			}
			ny++;
		}

		ny = 0;
		nx = 0;
		for (int i = yLen / 2; i < yLen; i++) {
			nx = 0;
			for (int j = 0; j < xLen / 2; j++) {
				ret[i][j] = section2[ny][nx]; // 3사분면 <- 4사분면
				nx++;
			}
			ny++;
		}

		ny = 0;
		nx = 0;
		for (int i = yLen / 2; i < yLen; i++) {
			nx = 0;
			for (int j = xLen / 2; j < xLen; j++) {
				ret[i][j] = section3[ny][nx];
				nx++;
			}
			ny++;
		}

		ny = 0;
		nx = 0;
		for (int i = 0; i < yLen / 2; i++) {
			nx = 0;
			for (int j = xLen / 2; j < xLen; j++) {
				ret[i][j] = section4[ny][nx];
				nx++;
			}
			ny++;
		}

		return ret;
	}

	public static int[][] divideArr(int[][] arr, int sy, int sx, int ey, int ex) {

		int[][] ret = new int[ey - sy][ex - sx];

		int nx = 0, ny = 0;
		for (int i = sy; i < ey; i++) {
			nx = 0;
			for (int j = sx; j < ex; j++) {
				ret[ny][nx] = arr[i][j];
				nx++;
			}
			ny++;
		}

		return ret;
	}

	// 4분할 이후, 좌측 이동

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int R = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] tmpMap;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int operation = Integer.parseInt(st.nextToken());
			switch (operation) {
			case 1:
				map = turn1(map);
				break;
			case 2:
				map = turn2(map);
				break;
			case 3:
				tmpMap = turn3(map);
				N = tmpMap.length;
				M = tmpMap[0].length;
				map = new int[tmpMap.length][tmpMap[0].length];
				map = tmpMap;

				break;
			case 4:
				tmpMap = turn4(map);
				map = new int[tmpMap.length][tmpMap[0].length];

				N = tmpMap.length;
				M = tmpMap[0].length;
				map = tmpMap;

				break;

			case 5:
				map = turn5(map);
				break;

			case 6:
				map = turn6(map);
				break;
			}
		}

		show(map);
		bw.write(sb.toString());
		bw.flush();
	}

	// --------------for debug log
	public static void show(int[][] arr) {

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

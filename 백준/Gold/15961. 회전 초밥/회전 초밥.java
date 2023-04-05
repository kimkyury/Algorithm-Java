
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 17472 다리 만들기 2
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static StringBuilder sb;
	static StringTokenizer st;

	// ------------- Variable for Problem ------------

	static int N, d, k, c;
	static int maxCnt = 0;

	public static void func() {

	}

	public static void main(String[] args) throws IOException {
		// 같은 V를 가지는 Node가 둘 이상 존재 가능

		// K개의 접시를 연속해서 먹으면 할인된 정액 가격 제공

		// K연속할인이벤트 참가하면, 지정된 V를 그냥 줌
		// 없으면 만들어서라도 줌

		// 위 행사에서 간으한 다양한 종류의 초밥을 먹을 것임

		// 8 30 4 30 // 접시수N, 초밥가짓수d, 연속해서먹는접시수K, 쿠폰초밥번호C
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
//		HashMap<Integer, Boolean> sushiSelected = new HashMap<>();

		// INPUT
		int[] sushiOrder = new int[N];
		for (int i = 0; i < N; i++)
			sushiOrder[i] = Integer.parseInt(br.readLine());
		int getCnt[] = new int[d + 1];

		// Window
		// 접시수N, 초밥가짓수d, 연속해서먹는접시수K, 쿠폰초밥번호C
		int lt = 0; //사실상 먹은 초밥가지
		int rt = 0; // 기존개수 (max)

		// 초밥K개 택하기, 택한 종류 수 lt로 체킹
		for (int i = 0; i < k; i++) {
			if (getCnt[sushiOrder[i]] == 0) lt++;
			getCnt[sushiOrder[i]]++;
		}
		rt = lt; // 초기 맥

		// 윈도우 시작
		for (int i = 1; i < N; i++) {

			// max갱
			if (rt <= lt) {
				// 보너스 먹은 적 없으면 +1
				if (getCnt[c] == 0)
					rt = lt + 1;
				else
					rt = lt;
			}

			// 첫번째꺼 안 먹었다 치
			getCnt[sushiOrder[i - 1]]--;

			// 만약 윗작업으로 인해 먹은 전적을 잃었다면
			if (getCnt[sushiOrder[i - 1]] == 0)
				lt--;

			// 마지막 꺼 먹고 카운
			int lastIdx = (i - 1 + k) % N;
			if (getCnt[sushiOrder[lastIdx]] == 0)
				lt++;
			getCnt[sushiOrder[lastIdx]]++;
		}

		bw.write(String.valueOf(rt) + "\n");
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

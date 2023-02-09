import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, M;
	static String str;
	static int[] condition; // 0: A, 1: G, 2:C, 3:T

	static int answer = 0;

	public static void solve(int lt, int rt, int[] countAGCT) {

		while (rt < N) {

			char tmpLeft = str.charAt(lt);
			char tmpRight = str.charAt(rt);
			// System.out.println(tmpLeft + " " + tmpRight);

			if (tmpLeft == 'A')
				countAGCT[0]--;
			else if (tmpLeft == 'C')
				countAGCT[1]--;
			else if (tmpLeft == 'G')
				countAGCT[2]--;
			else if (tmpLeft == 'T')
				countAGCT[3]--;

			if (tmpRight == 'A')
				countAGCT[0]++;
			else if (tmpRight == 'C')
				countAGCT[1]++;
			else if (tmpRight == 'G')
				countAGCT[2]++;
			else if (tmpRight == 'T')
				countAGCT[3]++;

			int correctCnt = 0;
			for (int i = 0; i < 4; i++) {
				// System.out.print(countAGCT[i] + " ");
				if (countAGCT[i] >= condition[i]) {
					correctCnt++;
				}
			}
			// System.out.println(" " + correctCnt);

			if (correctCnt == 4) {
				answer++;
			}

			lt++;
			rt++;
		}

	}

	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		str = br.readLine();
		condition = new int[4]; // 0: A, 1: G, 2:C, 3:T
		// resultCnt = new int[N - M + 1]; // 길이 M만큼은 존재하지 않음

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			condition[i] = Integer.parseInt(st.nextToken());
		}

		int countAGCT[] = new int[4]; // 0: A, 1: G, 2:C, 3:T
		// init Counting

		// 해당 개수 세기
		for (int i = 0; i < M; i++) {
			char tmp = str.charAt(i);
			if (tmp == 'A')
				countAGCT[0]++;
			else if (tmp == 'C')
				countAGCT[1]++;
			else if (tmp == 'G')
				countAGCT[2]++;
			else if (tmp == 'T')
				countAGCT[3]++;
		}

		int correctCnt = 0;
		for (int i = 0; i < 4; i++) {
			if (countAGCT[i] >= condition[i]) {
				correctCnt++;
			}
		}
		if (correctCnt == 4)
			answer++;
		// resultCnt[resultIndex++] = correctCnt;
		// (뺄값, 더할값, 현재 AGCT개수, )
		solve(0, M, countAGCT);

		bw.write(String.valueOf(answer));

		//
		bw.flush();
	}
}

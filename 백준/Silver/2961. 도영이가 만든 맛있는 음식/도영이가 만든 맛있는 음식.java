import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Taste {

	int bitter;
	int sour;

	Taste(int bitter, int sour) {
		this.bitter = bitter;
		this.sour = sour;
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static int minDiff;
	static Taste[] tastes;

	public static void solve(int sideIdx, int idx, int totalBitter, int totalSour) {

		if (sideIdx == N) {
			if (idx == 0)
				return;
//			System.out.println(sideIdx + " " + idx + " " + totalBitter + " " + totalSour);
//			System.out.println("어?");
			minDiff = Math.min(minDiff, Math.abs(totalBitter - totalSour));
			return;
		}

		Taste tmpT = tastes[sideIdx];
		solve(sideIdx + 1, idx + 1, totalBitter * tmpT.bitter, totalSour + tmpT.sour);
		solve(sideIdx + 1, idx, totalBitter, totalSour);

	}

	public static void main(String[] args) throws IOException {

		// 음식의 신 맛 = 신맛의 곱
		// 음식의 쓴맛 = 신맛의 합
		// abs[신맛의 곱 - 신맛의 합] 가장 작은 요리 찾기

		N = Integer.parseInt(br.readLine());
		tastes = new Taste[N];
		minDiff = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sourCnt = Integer.parseInt(st.nextToken());
			int bitterCnt = Integer.parseInt(st.nextToken());
			tastes[i] = new Taste(sourCnt, bitterCnt);
		}

		if (N == 1) {
			minDiff = Math.abs(tastes[0].sour - tastes[0].bitter);
			bw.write(String.valueOf(minDiff));
			bw.flush();
			return;
		}

		// 조합을 구해야한다
		solve(0, 0, 1, 0);

		bw.write(String.valueOf(minDiff));

		//
		bw.flush();
	}
}

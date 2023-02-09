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

	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(br.readLine());
		tastes = new Taste[N];
		minDiff = Integer.MAX_VALUE;

		// 비트마스크를 사용하기
		// 음식으로 만들 수 있는 모든 조합의 수를 만들자

		int subsetCnt = 1 << N;

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int bitter = Integer.parseInt(st.nextToken());
			int sour = Integer.parseInt(st.nextToken());
			tastes[i] = new Taste(bitter, sour);
		}

		Taste tmpT;

		int min = Integer.MAX_VALUE;
		for (int i = 1; i < subsetCnt; i++) { // 여기 0 제외처리
			int totalBitter = 1;
			int totalSour = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {

					tmpT = tastes[j];
					totalBitter *= tmpT.bitter;
					totalSour += tmpT.sour;

				}
			}
			min = Math.min(min, Math.abs(totalBitter - totalSour));
		}

		bw.write(String.valueOf(min));

		//
		bw.flush();
	}
}

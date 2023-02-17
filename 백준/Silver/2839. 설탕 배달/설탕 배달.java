
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

	public static void solve(int r, int c, int s) {

	}

	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		// 3과 5의 최소공배수 까지의 케이스를 생각함
		int answer;
		if (N % 5 == 0) {
			answer = N / 5;
		}

		else if ((N - 3) % 5 == 0) {
			answer = (N - 3) / 5 + 1;
		}

		else if (N > 5 && (N - 6) % 5 == 0) {
			answer = (N - 6) / 5 + 2;
		}

		else if (N > 8 && (N - 9) % 5 == 0) {
			answer = (N - 9) / 5 + 3;
		}

		else if (N > 11 && (N - 12) % 5 == 0) {
			answer = (N - 12) / 5 + 4;
		}

		else
			answer = -1;

		bw.write(String.valueOf(answer));
		bw.flush();
	}

}

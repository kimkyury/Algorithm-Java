import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int A, B;
	static int N;

	public static int gcd(int a, int b) {
		while (b != 0) {
			int rest = a % b;
			a = b;
			b = rest;
		}

		return a;
	}

	public static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int gcdResult = gcd(A, B);
			int lcmResult = A * B / gcdResult;
			bw.write(String.valueOf(lcmResult) + "\n");
		}

		// 최소공약수 : 둘 중 작은 수를 잡고, 그 수의 큰 값으로부터 동시에 나머지가 0인 것을 잡으면 됨

		// 최대 공배수: 작은 수부터 나누다가 더이상 나누어 지지 않을 때,
		// 그때까지의 곱한 수 x 나머지 하기
		// -> xxxxx 유클리드 호제법으로

		bw.flush();

	}
}

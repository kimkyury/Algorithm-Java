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

	static String N;
	static int B;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = st.nextToken();
		B = Integer.parseInt(st.nextToken());

		// 각 자리수 ^0, ^1, ^2 를 더해주면 된다
		int sum = 0;
		char[] arr = N.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			// System.out.println(arr[arr.length - 1 - i]);

			int num = arr[arr.length - 1 - i] - '0';
			// System.out.println(('A' - '0'));
			if (num >= 10)
				num -= 7;

			// System.out.println(num);
			sum += num * Math.pow(B, i);
		}

		bw.write(String.valueOf(sum));
		bw.flush();
	}
}

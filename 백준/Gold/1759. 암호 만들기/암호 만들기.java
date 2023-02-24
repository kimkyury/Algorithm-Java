import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N;
	static int L, C;

	static boolean[] isPassedConsonants;
	static boolean[] isPassedVowels;
	static char[] candidate;
	static char[] result;

	static ArrayList<String> answer = new ArrayList<>();

	public static void combi(int pIndex, int rIndex) throws IOException {

//		System.out.print(pIndex + " " + rIndex + "\n");

		if (rIndex == L) {
			if (confirm(result)) {

				Arrays.sort(result);
				answer.add(String.valueOf(result));
//				for (char c : result)
//					bw.write(c);
//				bw.write("\n");
			}

			return;
		}

		if (pIndex == C) {
//			System.out.println("hI");
			return;
		}

		combi(pIndex + 1, rIndex);
		result[rIndex] = candidate[pIndex];

		combi(pIndex + 1, rIndex + 1);
	}

	public static boolean confirm(char[] arr) {

		int cntConsonant = 0;
		int cntVowel = 0;
		for (char c : arr) {

			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				cntConsonant++;
			} else {
				cntVowel++;
			}
		}

		if (cntConsonant >= 1 && cntVowel >= 2) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken()); // 암호문 문자의 길이
		C = Integer.parseInt(st.nextToken()); // 입력될 문자의 후보 수

		candidate = new char[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			candidate[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(candidate);
		result = new char[L];
		combi(0, 0);

		Collections.sort(answer);
		for (String s : answer) {
			System.out.println(s);
		}

//		bw.write(String.valueOf(0));
		bw.flush();
	}
}

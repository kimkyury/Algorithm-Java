import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[] input;
	static int[] answer;
	static int cnt;
	static boolean isPassed[];
	static int N, M;

	static StringBuilder sb;

	public static void recur(int index, int cnt) throws IOException{
		
		if (cnt == M) {
			for(int i =1; i<=M; i++) {
				bw.write(String.valueOf(answer[i]) + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i =1; i<=N; i++) {
			if ( isPassed[i]) continue;
			
			isPassed[i] = true;
			answer[index] = input[i];
			recur(index+1, cnt+1);
			isPassed[i] = false;
		}
		


	}

	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			input[i] = i;
		}
//		sb = new StringBuilder();
		answer = new int[M+1];
		isPassed = new boolean[N + 1];

		recur(1, 0);
		


		bw.flush();

	}
}

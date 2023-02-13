import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer> arr = new LinkedList<>();
		List<Integer> answer = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			arr.add(i);
		}

		int curIndex = M - 1;
		while (!(arr.size() == 0)) {
			if (curIndex < arr.size()) {
				answer.add(arr.get(curIndex));
				arr.remove(curIndex);
			} else {
				curIndex = curIndex % arr.size();
				answer.add(arr.get(curIndex));
				arr.remove(curIndex);
			}
			curIndex += M - 1;
		}

		bw.write("<");

		for (int i = 0; i < answer.size() - 1; i++) {
			bw.write(String.valueOf(answer.get(i) + ", "));
		}

		bw.write(String.valueOf(answer.get(answer.size() - 1)));
		bw.write(">");

		bw.flush();
	}
}

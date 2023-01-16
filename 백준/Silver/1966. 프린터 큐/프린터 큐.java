import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Doc {
	int order;
	int importance;

	Doc(int order, int importance) {
		this.order = order;
		this.importance = importance;
	}

}

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;

	public static int solve(int N, int M, ArrayList<Doc> docs) {

		// ArrayList: 조회가 빠름
		// linkedList: 삽입/삭제가빠름
		// 나는 조회/삽입/삭제의 작업이 다 필요한데, 이때 조회의 개수가 더 많을 것이므로 ArrayList로 우선 구현해보자

		// 첫번째 원소를 POLL시킨다

		// 나머지 원소 중에서 첫원소.impotance보다 큰 것을 발견하면 맨 뒤로 옮긴다
		// 현재의 첫원소가 확실히 out될 것일 때, 내가 찾는 order인지 확인한다
		// 최종적으로 반복한 횟수를 return시킨다

		Doc tmp;
		int cnt = 0;

		boolean isHighest;
		while (!docs.isEmpty()) {
			isHighest = true;
			tmp = docs.get(0);
			docs.remove(0);

			for (Doc doc : docs) {
				if (tmp.importance < doc.importance) {
					isHighest = false;
					docs.add(tmp);
					break;
				}
			}
			if (isHighest) {
				cnt++;
				if (tmp.order == M) {
					break;
				}
			}

		}

		return cnt;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		int N, M;
		int order;
		ArrayList<Doc> docs;
		for (int i = 0; i < T; i++) {
			 docs = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			order = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {

				int importance = Integer.parseInt(st.nextToken());
				docs.add(new Doc(order++, importance));
			}

			int answer = solve(N, M, docs);
			bw.write(String.valueOf(answer) + '\n');

		}
		
		bw.flush();

	}

}

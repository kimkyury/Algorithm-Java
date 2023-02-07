import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Student {

	int gender;
	int number;

	Student(int gender, int number) {
		this.gender = gender;
		this.number = number;
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;

	public static int[] solve(int[] switchs, Student[] students) throws IOException {

		for (Student student : students) {
			int gender = student.gender;
			int number = student.number;

			if (gender == 1) {
				for (int i = 1; i <= N; i++) {
					if (i % number == 0) {

						if (switchs[i - 1] == 0)
							switchs[i - 1] = 1;
						else
							switchs[i - 1] = 0;
					}
				}

			} else if (gender == 2) {
				number--; // 인덱스 맞추기
				// number을 기준으로 좌우 탐색
				int left = number - 1;
				int right = number + 1;

				if (switchs[number] == 0)
					switchs[number] = 1;
				else
					switchs[number] = 0;

				while (left >= 0 && right <= N - 1) {
					if (switchs[left] == switchs[right]) {
						// left
						if (switchs[left] == 0)
							switchs[left] = 1;
						else
							switchs[left] = 0;

						// right
						if (switchs[right] == 0)
							switchs[right] = 1;
						else
							switchs[right] = 0;

						left--;
						right++;
					} else
						break;
				}
			}
		}
		return switchs;
	}

	public static void main(String[] args) throws IOException {

//		StringTokenizer st = new StringTokenizer(br.readLine());

		// 스위치는 커져있거나 꺼져있다
		// boy : (스위치번호 % 본인 수 ) == 0 -> 스위치 상태 바꾸기
		// girl : 좌우대칭이 끝나는 지점까지 찾아가기, 그 후 해당 구간의 스위치 상태 모두 반전
		// 단, 이 구간에 속한 스위치 개수는 항상 홀수가 될 것임

		N = Integer.parseInt(br.readLine());

		int[] switchs = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			if (st.nextToken().equals("0"))
				switchs[i] = 0;
			else
				switchs[i] = 1;
		}

		int cntStudent = Integer.parseInt(br.readLine());
		Student[] students = new Student[cntStudent];

		for (int i = 0; i < cntStudent; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			Student student = new Student(gender, number);
			students[i] = student;
		}

		int[] results = solve(switchs, students);
//		System.out.println(results.toString());

		int cnt = 0;
		for (int result : results) {
			cnt++;
			bw.write(String.valueOf(result) + " ");
			if (cnt % 20 == 0) {
				bw.write("\n");
			}
		}

		bw.flush();

	}
}

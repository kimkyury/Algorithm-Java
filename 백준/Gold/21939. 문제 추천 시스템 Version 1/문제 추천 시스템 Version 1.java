import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Problem {

  int P; //
  int L; //level

  Problem(int P, int L) {
    this.P = P;
    this.L = L;
  }
}

public class Main {

  static HashMap<Integer, Problem> hash;
  static PriorityQueue<Problem> ascProblems;
  static PriorityQueue<Problem> descProblems;

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static void add(int P, int L) {
    Problem p = new Problem(P, L);
    hash.put(P, p);
    ascProblems.add(p);
    descProblems.add(p);
  }

  public static int recommend(int R) {
    Problem p;
    if (R == 1) {
      p = ascProblems.peek();
      return p.P;
    } else {
      p = descProblems.peek();
      return p.P;
    }
  }

  public static void solved(int P) {
    Problem p = hash.get(P);
    ascProblems.remove(p);
    descProblems.remove(p);
    hash.remove(P);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    // 문제의 개수 N
    hash = new HashMap<>();
    ascProblems =
      new PriorityQueue<>((o1, o2) -> {
        if (o1.L == o2.L) return o2.P - o1.P;
        return o2.L - o1.L;
      });

    descProblems =
      new PriorityQueue<>((o1, o2) -> {
        if (o2.L == o1.L) return o1.P - o2.P;
        return o1.L - o2.L;
      });

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      // 문제번호 P + 난이도 L
      st = new StringTokenizer(br.readLine());
      int P = Integer.parseInt(st.nextToken());
      int L = Integer.parseInt(st.nextToken());

      Problem p = new Problem(P, L);
      hash.put(P, p);
      descProblems.add(p);
      ascProblems.add(p);
    }

    int M = Integer.parseInt(br.readLine());
    String command;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      command = st.nextToken();

      int P, L, R;
      if (command.equals("add")) {
        P = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        add(P, L);
      } else if (command.equals("recommend")) {
        R = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(recommend(R)) + '\n'); // TODO: return받기
      } else if (command.equals("solved")) {
        P = Integer.parseInt(st.nextToken());
        solved(P);
      }
    }

    bw.flush();
  }
}

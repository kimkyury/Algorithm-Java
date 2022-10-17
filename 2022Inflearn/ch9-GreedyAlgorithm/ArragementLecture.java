import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Lecture implements Comparable<Lecture> {

    int M;
    int D;

    Lecture(int M, int D) {
        this.M = M;
        this.D = D;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.D - this.D;
    }
}

class Main {

    static int maxD = Integer.MIN_VALUE;
    static int N;
    static ArrayList<Lecture> lectures = new ArrayList<>();

    public static int solve() {

        int answer = 0;

        Collections.sort(lectures);

        // root가 MAX인 힙, 가장 큰 값을 우선으로 뱉게 됨
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        int j = 0;
        for (int i = maxD; i >= 1; i--) {

            while (j < N) {
                if (lectures.get(j).D < i)
                    break;
                pQ.offer(lectures.get(j).M);
                j++;
            }

            if (!pQ.isEmpty())
                answer += pQ.poll();

        }

        return answer;

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            if (D > maxD)
                maxD = D;
            lectures.add(new Lecture(N, D));

        }

        int answer = solve();

        System.out.println(answer);

    }

}
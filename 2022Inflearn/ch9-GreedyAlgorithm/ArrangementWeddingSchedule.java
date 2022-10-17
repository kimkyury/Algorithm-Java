import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class TimeNode implements Comparable<TimeNode> {
    int value;
    char state;

    TimeNode(int value, char state) {
        this.value = value;
        this.state = state;
    }

    @Override
    public int compareTo(TimeNode o) {
        if (this.value == o.value)
            return this.state - o.state; // e 다음에 s 가 나오도록

        return this.value - o.value;
    }

}

class Main {

    static int max;
    static int N;
    static int time[] = new int[73];
    static ArrayList<TimeNode> list = new ArrayList<>();

    public static void solve() {

        Collections.sort(list);

        max = Integer.MIN_VALUE;
        int cnt = 0;
        for (TimeNode node : list) {

            if (node.state == 'S') {
                cnt++;
            } else {
                cnt--;
            }

            max = Math.max(max, cnt);
        }

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            list.add(new TimeNode(start, 'S'));

            int end = Integer.parseInt(st.nextToken());
            list.add(new TimeNode(end, 'E'));

        }

        solve();

        System.out.println(max);

    }

}
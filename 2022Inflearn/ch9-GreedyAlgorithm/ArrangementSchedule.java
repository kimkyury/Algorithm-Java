import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Metting implements Comparable<Metting> {
    int start;
    int end;
    int length;

    Metting(int start, int end) {
        this.start = start;
        this.end = end;
        this.length = end - start;
    }

    @Override
    public int compareTo(Metting o) {

        if (this.end == o.end)
            return this.start - o.start; // 시간 오름차순
        return this.end - o.end; // 종료시간에 대한 오름차순
    }
}

class Main {

    static int N;
    static int[] room;
    static ArrayList<Metting> mettings;

    public static int solve() {

        Collections.sort(mettings);

        int cnt = 0;

        int end = 0;
        for (Metting metting : mettings) {
            if (metting.start >= end) {
                cnt++;
                end = metting.end;
            }
        }

        return cnt;

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        mettings = new ArrayList<>();
        room = new int[25];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            mettings.add(new Metting(start, end));
        }

        int answer = solve();
        System.out.println(answer);

    }

}
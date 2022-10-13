import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class BodyInfo implements Comparable<BodyInfo> {
    int height;
    int weight;

    BodyInfo(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(BodyInfo o) {
        return o.height - this.height; // 내림차순
    }

}

class Main {

    static int N;
    static ArrayList<BodyInfo> infos;

    public static void solve() {

        Collections.sort(infos);

        int cnt = 0;

        int max = Integer.MIN_VALUE;
        for (BodyInfo body : infos) {
            if (body.weight > max) {
                max = body.weight;
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        infos = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            infos.add(new BodyInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        solve();

    }

}
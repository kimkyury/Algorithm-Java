import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

    static int N;

    static HashMap<Integer, Integer> hash = new HashMap<>();

    public static void solve() {
        ArrayList<Integer> list = new ArrayList<>(hash.keySet());
        list.sort((int1, int2) -> int1.compareTo(int2));

        int cnt = N;
        for (int i = 0; i < N; i++) {
            // A를 한 명씩 지정한다, 어차피 얘는 키 순서상 뒤에 애보단 작다
            int A = list.get(i);
            // System.out.print("\n" + list.get(i) + " " + hash.get(list.get(i)));

            for (int j = i + 1; j < N; j++) {
                // 몸무게 마저도 더 큰 선수를 만나면 탈락시킨다
                if (hash.get(A) < hash.get(list.get(j))) {
                    cnt--;
                    break;
                }
            }

        }

        System.out.println(cnt);

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            hash.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        solve();

    }

}
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static StringTokenizer st;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static int cnt;
    static int[][] lcs;

    public static void main(String[] args) throws IOException {

        // 1 ~ 10^9 양수, 음수
        // 두 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들기

        // 산,약 정렬된 순서로 주어짐
        // 출력: 오름차순
        //

        // st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine()); // 2 < N < 10^5
        // M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Long> arr = new ArrayList<>();
        Set<Long> set = new HashSet<>();

        for (int i = 0; i < N; i++) {

            long next = Long.parseLong(st.nextToken());
            if (!set.contains(next)) {
                arr.add(next);
                set.add(next);
            }
        }

        int lt = 0, rt = arr.size() - 1;

        if (lt == rt) {
            bw.write(arr.get(lt) + " " + arr.get(lt));
            bw.flush();
            return;
        }

        Long min = Long.MAX_VALUE;

        int minLIdx = lt;
        int minRIdx = rt;
        while (lt < rt) {

            long sum = arr.get(lt) + arr.get(rt);

            if (min > Math.abs(sum)) {
                minLIdx = lt;
                minRIdx = rt;
                min = Math.abs(sum);
            }

            if (sum == 0) {
                break;
            }

            // 두 케이스에서, lt<rt를 어긴다면 관둔다
            if (sum < 0) {
                // 합이 음수라면, lt를 줄여본다
                lt++;
                continue;
            } else if (sum > 0) {
                // 합이 양수라면, rt를 줄여본다
                rt--;
                continue;
            }

        }

        bw.write(arr.get(minLIdx) + " " + arr.get(minRIdx));
        bw.flush();
    }

    public static void show(int[][] map) {

        System.out.println("------------------");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
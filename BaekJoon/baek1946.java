import java.io.*;

public class baek1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            // 각 케이스마다 반복한다
            int n = Integer.parseInt(br.readLine());
            if (n == 1) {
                System.out.println(1);
                return;
            }

            int[] index = new int[n + 1];
            int cnt = 1;

            for (int j = 1; j <= n; j++) {
                String[] map = br.readLine().split(" ");
                int key = Integer.parseInt(map[0]);
                int value = Integer.parseInt(map[1]);
                index[key] = value;
            }

            loop: for (int k = 2; k <= n; k++) {
                int value = index[k];

                // 점수가 1등이면 당연히 합격이니까 카운트해주자
                if (value == 1) {
                    cnt++;
                    continue;
                }

                // 합격 기준이면 카운트해주자
                for (int w = k - 1; w > 0; w--) {
                    if (index[w] < value)
                        continue loop;
                }
                cnt++;
            }
            System.out.println(cnt);
        }
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n;
    static int[] ch;

    // L이란 원소를 사용한다 vs 사용 안 한다
    public void DFS(int L) {
        if (L == n + 1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    tmp += (i + " ");
                }
            }
            if (tmp.length() > 0)
                System.out.println(tmp);

        } else {

            ch[L] = 1;
            DFS(L + 1); // left

            ch[L] = 0;
            DFS(L + 1); // right
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        ch = new int[n + 1];

        main.DFS(1);
    }
}
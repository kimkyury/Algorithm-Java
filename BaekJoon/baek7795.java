import java.util.*;
import java.io.*;

public class baek7795 {
    
    static int[] A;
    static int[] B;
    static int[] cnts;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        cnts = new int [T];

        for (int i = 0; i < T; i++) {
            int count = 0;
            input();

            Arrays.sort(B);

            for (int j = 0; j < A.length; j++) {
                for (int k = 0; k < B.length; k++) {
                    if (A[j] > B[k]) {
                        count++;
                    } else {
                        break;
                    }

                }
            }
            cnts[i] = count;

        }
        for (int i = 0; i < T; i++) {
             System.out.println(cnts[i]);
        }
        
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new int[N];
        B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
    }
}
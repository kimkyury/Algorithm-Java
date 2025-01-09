import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N,M, T, K;

    static Set<Integer> nodes;
    static Map<Integer, Integer> parent ;
    static Map<Integer, Integer> depth ;
    static Map<Integer, List<Integer>> tree ;


    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        long pNum = factorial(1, 1, N);

        long cNum = factorial(1, 1, K) * factorial(1, 1, N-K);

        bw.write( (pNum / cNum) + " ");


        bw.flush();
    }


     static long factorial(long sum, int n, int limit){

        if ( n > limit){
            return sum;
        }

        return factorial(sum*n, n+1, limit);
    }

    

}

import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static long N, M, Q;    
    static int cnt;
    static int len = 0;

    static ArrayList<ArrayList<int []>> graph;

    public static void main (String [] args) throws IOException{

        N = Long.parseLong(br.readLine());

        // 안뜰의 면적이 주워진다
        
        double result = Math.sqrt(N);
        bw.write(String.format("%.8f", 4*result) + "\n");

        // axa = area
        // 4a

        bw.flush();

    }   

}
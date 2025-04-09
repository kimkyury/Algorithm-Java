import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, L, R;

    public static void main(String[] args) throws Exception {

        // i번째 석판: i번째 알파벳 대문자
        
        int cnt =84;

        char s = br.readLine().charAt(0);
        cnt += Math.abs(s - 'I');
        
        bw.write(cnt + "");
        bw.flush();
    }

}
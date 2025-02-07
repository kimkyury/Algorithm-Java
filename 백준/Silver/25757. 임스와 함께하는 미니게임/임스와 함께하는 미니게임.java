import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;
    public static void main (String [] args) throws IOException{
       
       // 플레이 신청 수:N, 플레이할 게임 종류
       // 쵣 몇번이나 플레이할 수 있는가?

       st = new StringTokenizer(br.readLine());

       N = Integer.parseInt(st.nextToken());

       HashMap<Character, Integer> numByGame = new HashMap<>();
       numByGame.put('Y', 1);
       numByGame.put('F', 2);
       numByGame.put('O', 3);
    
       int num = numByGame.get(st.nextToken().charAt(0));

       HashSet<String> set = new HashSet<>();
       for(int i =0; i<N; i++){

        set.add(br.readLine());
       }
       
       bw.write( (set.size()/num) +"\n");
       bw.flush();
    }
}
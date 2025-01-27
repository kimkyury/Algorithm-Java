import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M, Q;    
    static int cnt;
    static int len = 0;

    static ArrayList<ArrayList<int []>> graph;

    public static void main (String [] args) throws IOException{

        N = Integer.parseInt(br.readLine());

        // queue 두 개를 이용한다
        // queue 두 개의 용량 균형을 맞춘다
        // maxPQ, minPQ

        // 1. maxPQ에 먼저 넣는다
        // 2. maxPQ.peek()의 음수값이  minPQ.peek()보다 크다면 교환한다

        // 3. 사이즈가 더 큰 쪽의 것을 꺼내 부등호를 반대로 하여 반대에 넣는다?


        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(
        (o1, o2) -> {
            return o2 -o1;
        });

        PriorityQueue<Integer> minPQ = new PriorityQueue<>( (o1, o2) ->{
            return o1-o2;
        });
        // output: 1 1 2 2 2 5 5
    
        for(int i =0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            maxPQ.offer(num);

            if ( !minPQ.isEmpty()){
                if ( minPQ.peek() < maxPQ.peek()){
                    minPQ.offer(maxPQ.poll());
                }
            }

            if ( maxPQ.size()> minPQ.size()+1){
                minPQ.offer(maxPQ.poll());
            }else if ( maxPQ.size() < minPQ.size()){
                maxPQ.offer(minPQ.poll());
            }

            bw.write(maxPQ.peek() + "\n");
        }


        bw.flush();

    }   

}
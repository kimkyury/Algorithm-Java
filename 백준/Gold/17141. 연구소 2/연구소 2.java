import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;
    static int map [][];
    static int time;

    static int [] dy = { 0, 1, 0, -1};
    static int [] dx = { 1, 0, -1, 0};

    public static void main (String [] args) throws IOException{
        
        // M개 바이러스 -> 상하좌우 전염
        // N 정사각형 map
        // 빈칸, 벽


        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // <= 50
        M = Integer.parseInt(st.nextToken()); // <= 10

        List<int []> poses = new ArrayList<>();
        time = Integer.MAX_VALUE;

        map = new int [N][N];
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            
                if ( map[i][j] == 2){
                    poses.add(new int [] {i, j});
                }
            }
        }


        // 1. M개의 바이러스를 뽑는다
        getSubSet(poses.size(), 0, new ArrayList<int []>(), poses);
        // 2. 해당 바이러스 조합으로 전염했을 때, 모두 전염시키는 최소 시간을 구한다

        if ( time == Integer.MAX_VALUE){
            bw.write("-1");
        }else{
            bw.write(time +"\n");
        }
        bw.flush();

    }


    private static void getSubSet(int size, int cur, List<int []> selected, List<int []> poses){

        if (selected.size() == M){
            calculate(selected);
            return;
        }

        for(int i =cur; i<size; i++){
            selected.add(poses.get(i));
            getSubSet(size, i+1, selected, poses);
            selected.remove(poses.get(i));
        }
    }


    private static void calculate(List<int []> selected){

        ArrayDeque<int []> dq = new ArrayDeque<>();
        boolean [][] passed = new boolean [N][N];
        
        for(int [] pos : selected){
            dq.offer(pos);
            passed[pos[0]][pos[1]] = true;
        }

        int curTime = 0;
        while(!dq.isEmpty()){

            if ( curTime >= time){
                return;
            }

            int size = dq.size();
            for(int i =0; i<size; i++){

                int [] cur = dq.poll();

                for(int k =0; k<4; k++){
                    int ny = cur[0] + dy[k];
                    int nx = cur[1] + dx[k];

                    if ( ny < 0 || nx < 0 || ny > N-1 || nx > N-1){
                        continue;
                    }

                    if ( passed[ny][nx] ){
                        continue;
                    }

                    if (map[ny][nx] == 1){
                        continue;
                    }

                    passed[ny][nx] = true;
                    dq.offer(new int []{ny, nx});
                }
            }
            curTime++;
        }

        boolean isFull = check(passed);

        if ( isFull){
            time = curTime-1;
        }
        // System.out.println("curtime:" + curTime);
    }


    private static boolean check(boolean [][] isPassed){

        for(int i =0; i<N; i++){
            for(int j =0; j<N; j++){

                if ( map[i][j] == 1){
                    continue;
                }

                if ( !isPassed[i][j]){
                    return false;
                }

            }
        }
        return true;
    }
}
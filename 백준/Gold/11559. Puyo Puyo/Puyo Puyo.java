import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    // static long N, M, Q;    
    static int N, M, K;

    static int [] dy= { 0, 1, 0, -1};
    static int [] dx = { 1, 0, -1, 0}; 

    static char [][] map;
    static boolean [][] passed;
    static boolean [][] passedF;

    static ArrayDeque<int []> dq;
    static ArrayDeque<int []> dqF;


    static int cntJ, R, C;

    public static void main (String [] args) throws IOException{

        // 1. 같은색의 뿌요가 4개 이상 상하좌우로 연결되어있으면 없어짐
        // 2. 상위에 있던 뿌요가 아래로 내려감
        // 3. 연쇄 횟수 세기


        R = 12; C = 6;

        map = new char [R][C];

        // 1. '.'이 아닌 공간에 대해서 BFS 결과 4개 이상인지 확인한다
        // 2. 더 이상 탐색할 부분이 없을 때, 해당 범위가 4개 이상인 경우 해당 자리를 없앤다
        // 3. 전체 맵에 대하여, 하단의 빈공간이 없도록 위치를 내려버린다


        for(int i =0; i<R; i++){
            String line = br.readLine();
            for(int j =0; j<C; j++){

                map[i][j] = line.charAt(j);
            }
        }

        int cnt =0;

        while(true){

            List<int []> beRemoved = new ArrayList<>();

            for(int i =0; i<R; i++){
                for(int j =0; j<C; j++){

                    if ( map[i][j] != '.'){
                        
                        // 1. 연결 원소 구하기
                        List<int []> curBeRemoved= getBeRemoved(i, j);

                        // 2. 4개 이상인 경우 삭제/이동 대상
                        if ( curBeRemoved.size() >=4){
                            beRemoved.addAll(curBeRemoved);
                        }
                    }
                }
            }


            if (beRemoved.size() == 0){
                break;
            }

            // 3.  삭제 및 이동
            cnt++;
            remove(beRemoved);
            // show(map);
            move();
            // show(map);
        }
        bw.write(cnt +"\n");
        bw.flush();
    }   

    private static void show(char [][]map){

        System.out.println("----------SHOW------------");
        for(int i =0; i<R; i++){
            for(int j =0; j<C; j++){
                System.out.print(map[i][j] + " " );

            }
            System.out.println("");
        }
    }

    private static void remove(List<int []> tgts){

        for( int [] tgt : tgts){
            map[tgt[0]][tgt[1]] = '.';
        }
    }


    private static void move(){

        for(int j =0; j<C; j++){
            // 각 열에 대해서

            int top = R-2;

            List<int []> movePos = new ArrayList<>();
            while(top >= 0){
                movePos.add(new int []{top, j});
                top--;
            }

            int bottom = R-1;
            for(int [] pos: movePos){
                
            
                while(map[bottom][j] != '.'){
                    if ( bottom == pos[0]){
                        break;
                    }
                    bottom--;
                }

                if ( bottom == pos[0]){
                    continue;
                }

                map[bottom][j] = map[pos[0]][pos[1]];
                map[pos[0]][pos[1]] = '.';
            }
        }
    }

    private static List<int []> getBeRemoved(int y, int x){

        char c = map[y][x];

        ArrayDeque<int []> dq = new ArrayDeque<>();
        dq.offer(new int[]{y, x});

        List<int []> beRemoved = new ArrayList<>();
        beRemoved.add(new int[]{y, x});

        boolean [][] passed = new boolean [R][C];
        passed[y][x] = true;

        while(!dq.isEmpty()){
            
            int size = dq.size();

            for(int i =0; i<size; i++){

                int [] cur = dq.poll();

                for(int k =0;k<4; k++){

                    int ny = cur[0] + dy[k];
                    int nx = cur[1] + dx[k];

                    if ( ny < 0 || nx < 0 || ny > R-1 || nx > C-1){
                        continue;
                    }

                    if ( map[ny][nx] != c){
                        continue;
                    }

                    if ( passed[ny][nx] ){
                        continue;
                    }

                    passed[ny][nx] = true;

                    int [] tgt = new int []{ny, nx};
                    dq.offer(tgt);
                    beRemoved.add(tgt);
                }
            }
        }


        return beRemoved;
    }
}
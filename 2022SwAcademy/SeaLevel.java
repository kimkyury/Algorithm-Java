import java.util.*;
import java.io.*;

class SeaLevel{

    static int[] dx = {1, -1, 0, 0}; // (1,0), (-1, 0)
    static int[] dy = {0, 0, 1, -1}; // (0, 1), (0, -1)
    static boolean [][] visited;
    static int [][] grid;
    static int length;


    public static void printGrid(int [][] grid){
        for(int i =0; i<grid.length; i++){
            for(int j =0; j<grid.length; j++){
                    System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static void dfs(int x, int y, int len) {
        visited[x][y] = true;
        for(int i =0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < length && ny < length){
                if(!visited[nx][ny]) {
                    if(grid[nx][ny] > len) dfs(nx, ny, len);
                }
            }
        }
    }

	public static void main(String args[]) throws Exception{

		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt(); //2


        int testNumber = 0;
		for(int test_case = 1; test_case <= T; test_case++){
           String testIndex = "#" + (++testNumber);

            length = sc.nextInt(); // 2
           int maxLength=Integer.MIN_VALUE; //최대 x년(최대 x길이)
           grid = new int [length][length];

           // 입력받기, 최대 x년 구하기
           for(int i =0; i<length; i++){
                for(int j =0; j<length; j++){
                        grid[i][j] = sc.nextInt();
                        if(maxLength < grid[i][j]) maxLength = grid[i][j];
                }
            }

            int maxCnt = 0;
            for(int len =0; len<=maxLength; len++){
                visited = new boolean[length][length];
                int cnt = 0;
                for(int i =0; i<length; i++){
                    for(int j=0; j<length; j++){
                        if(!visited[i][j] && grid[i][j] > len){
                            cnt ++;
                            dfs(i, j, len);
                        }
                    }
                }
                maxCnt = Math.max(maxCnt, cnt);
            }

            System.out.println(testIndex + " " + maxCnt);
            //printGrid(rowHight);

		}
	}



}
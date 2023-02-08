

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][] a = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				a[i][j]=Integer.parseInt(st.nextToken());
			}
		} 
		//입력 끝
		
		//구간합 시작
		int [][] b = new int[N+1][N+1];
		
		for (int i=1;i<N+1;i++) {
			for (int j=1;j<N+1;j++) {
				b[i][j]=b[i-1][j]+b[i][j-1]-b[i-1][j-1]+a[i-1][j-1];
			}
		}
		
//		for (int[] is : b) {
//			System.out.println(Arrays.toString(is));
//		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			
			int answer = b[x2][y2]+b[x1-1][y1-1]-b[x1-1][y2]-b[x2][y1-1];
			
			System.out.println(answer);
			
		}
	}

}

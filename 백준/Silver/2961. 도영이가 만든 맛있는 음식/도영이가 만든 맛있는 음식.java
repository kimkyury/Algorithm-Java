
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] a;
	static int answer= Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		a = new int[N][2];
		StringTokenizer st; 
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			a[i][0]=Integer.parseInt(st.nextToken());
			a[i][1]=Integer.parseInt(st.nextToken());
		}
		
		find(0,0);
		System.out.println(answer);
		
	}
	
	static void find(int idx,int mask) {
		if(idx==N) {
			if (mask==0) return;
			int c=1; //신맛
			int s=0; //쓴맛
			
			for(int i=0;i<N;i++) {
				if((mask&1<<i)>0) {
					c*=a[i][0];
					s+=a[i][1];
				}
			}
			
			answer=Math.min(answer, Math.abs(c-s));
			return;
		}
		
		
		find(idx+1,mask|1<<idx);
		
		find(idx+1,mask);
	}

}
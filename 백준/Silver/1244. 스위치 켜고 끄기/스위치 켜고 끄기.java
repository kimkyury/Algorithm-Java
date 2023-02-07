import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int s_num = Integer.parseInt(br.readLine());
		
		int[] swt = new int[s_num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<s_num;i++) {
			swt[i]=Integer.parseInt(st.nextToken());
		}
		int student_n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<student_n;i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st1.nextToken())==1) swt=man(swt,Integer.parseInt(st1.nextToken())); //남학생
			else swt=woman(swt,Integer.parseInt(st1.nextToken())); //여학생
			
		}
		
		for (int i=0; i<swt.length;i++) {
			if(i%20==0 && i!=0) System.out.println();
			System.out.print(swt[i]+" ");
			
		}
		
		
	}
	
	static int[] man(int[] swt,int n) { //배수면 토글
		
		int i=1;
		int temp=n;
		while(n-1<swt.length) {
			
			if(swt[n-1]==1) swt[n-1]=0;
			else swt[n-1]=1;
			i+=1;
			n=(temp)*i;
		}
		return swt;
	}
	
	static int[] woman(int[] swt,int n) { //양옆이 같으면 토글
		n-=1;
		if(swt[n]==1) swt[n]=0;
		else swt[n]=1;
		
		int i=1;
		while(n-i>=0 && n+i<swt.length) {
			if(swt[n-i]!=swt[n+i]) break;
			else {
				if(swt[n-i]==1) {
					swt[n-i]=0;
					swt[n+i]=0;
				}
				else {
					swt[n-i]=1;
					swt[n+i]=1;
				}
			}
			i+=1;
		}
		return swt;
	}

}

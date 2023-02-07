import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	static int N;
	static int M;
	static ArrayList<Integer> array = new ArrayList<>();
	static boolean [] check;
	static int [] num;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String value=br.readLine();
		
		String[] a;
		a=value.split(" ");
		
		N = Integer.parseInt(a[0]);
		M = Integer.parseInt(a[1]);
		check = new boolean [N];
		num = new int[N];
		for(int i=1;i<N+1;i++) {
			num[i-1]=i;
		}
		
		perm(0);
	}
	
	static void perm(int idx) {
		if(idx==M) {
			for (Integer integer : array) {
				System.out.print(integer+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(check[i]) continue;
			
			check[i]=true;
			array.add(num[i]);
			perm(idx+1);
			array.remove(array.size()-1);
			check[i]=false;
		}
		
		
	}

}

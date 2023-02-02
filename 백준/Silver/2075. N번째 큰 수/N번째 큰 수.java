import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n;j++) {
				int a = Integer.parseInt(st.nextToken());
				pq.add(a);
			}
			
		}
		
		for(int i = 0;i<n-1;i++) {
			pq.poll();
		}
		System.out.println(pq.peek());
	}

}

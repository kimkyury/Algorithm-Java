import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i=1;i<N+1;i++) {
			q.offer(i);
		}
		int temp;
		while(true) {
			if(q.size()==1) {
				System.out.println(q.poll());
				break;
			}
			if(q.size()>=2) {
				q.poll();
				q.offer(q.poll());
			}
		}

	}

}

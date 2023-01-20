import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		ArrayList<Integer> result = new ArrayList();
	
		for (int i = 0; i < N; i++) {
			q.add(i+1);
		}
		
		int cnt = 1;
		
		sb.append("<");
		
		while(!q.isEmpty()) {
			if(q.size() == 1) {
				sb.append(q.poll()).append(">");
				break;
			}
			if(cnt == K) {
				sb.append(q.poll()).append(", "); 
				
				cnt = 1;
			} else {
				q.add(q.poll()); cnt++;
			}
		}
		
		System.out.println(sb.toString());
		
	}
}

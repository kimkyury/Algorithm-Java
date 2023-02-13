import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue= new LinkedList<>();
		
		int[] input = new int[N+1];
		for(int i=1;i<=N;i++) {
			queue.offer(i);
		}
		
		sb.append("<");		
		//죽으면 0으로 표시해서 산, 죽음 구분
		int alive=1;
		while (!queue.isEmpty()) {
			int num = queue.poll();
			if(alive % K ==0) {
				sb.append(num + ", ");
			}else {
				queue.offer(num);
			}
			alive++;
		}
		
	sb.setLength(sb.length()-2);
	sb.append(">");
	System.out.println(sb);
	
	}
}
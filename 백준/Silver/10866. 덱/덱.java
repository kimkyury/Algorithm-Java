import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Scanner sc = new Scanner(System.in);
		Deque q = new LinkedList<>();
		
		for(int tc= 0; tc < n; tc++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			String x = st.nextToken();
			int a = 0;
			
			if(x.equals("push_back")) {
				a = Integer.parseInt(st.nextToken());
				q.addLast(a);
			}
			if(x.equals("push_front")) {
				a = Integer.parseInt(st.nextToken());
				q.addFirst(a);
			}
			if(x.equals("front")) {
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(q.peekFirst());
			}
			if(x.equals("back")) {
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(q.peekLast());
			}
			if(x.equals("size")) {
				System.out.println(q.size());
			}
			if(x.equals("pop_front")) {
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(q.poll());
			}
			if(x.equals("pop_back")) {
				if(q.isEmpty()) System.out.println(-1);
				else System.out.println(q.pollLast());
			}
			if(x.equals("empty")) {
				if(q.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			
		}
	}

}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		int n = sc.nextInt();
		for(int i = 0 ;i<n;i++) {
			q.add(i+1);
		}
		while(true) {
			if(q.size() == 1) {
				break;
			}
			q.poll();
			q.add(q.poll());
		}
		System.out.println(q.poll());
		
		
	}

}

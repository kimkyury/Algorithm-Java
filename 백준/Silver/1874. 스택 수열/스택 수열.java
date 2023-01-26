import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		StringBuilder result = new StringBuilder();
		Stack<Integer> q = new Stack<>();
		for(int i = 0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int idx = 0;
		int x = 1;
		q.add(x++);
		result.append('+').append('\n');
		boolean flag = true;
		
		while (true) {
			
			if(x > n) {
				if(arr[idx] != q.peek()) {
					flag = false;
					break;
				}
				while(true) {
					if (q.isEmpty()) {
						break;
					}
					if(arr[idx] != q.peek()) {
						flag = false;
						break;
					}
					else {
						q.pop();
						result.append('-').append('\n');
						idx++;
					}
				}
			}
			
			if (flag == false) {
				break;
			}
			
			if(q.isEmpty()) {
				break;
			}
			while(true) {
				if (q.empty()) {
					break;
				}
				if(arr[idx] == q.peek()) {
					q.pop();
					result.append('-').append('\n');
					idx++;
				}
				else break;
			}
			q.add(x++);
			result.append('+').append('\n');
			
		}
		
		if(flag == false) {
			System.out.println("NO");
		}
		else {
			System.out.print(result);
		}
		
	}

}

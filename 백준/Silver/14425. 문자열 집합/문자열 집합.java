import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Set<String> arr = new HashSet<>();
		
		for(int i = 0;i<n;i++) {
			arr.add(br.readLine());
		}
		int result = 0;
		for(int i = 0;i<m;i++) {
			String s = br.readLine();
			if(arr.contains(s)) {
				result++;
			}
		}
		System.out.println(result);
	}

}

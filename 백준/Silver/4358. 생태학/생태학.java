import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map < String, Double > arr = new TreeMap<>();
		String s;
		double cnt = 0.0;
		while((s = br.readLine()) != null) {
			if(s.equals("")) break;
			if(arr.containsKey(s)) {
				arr.put(s, arr.get(s)+1);
				cnt++;
			}
			else {
				arr.put(s, 1.0);
				cnt++;
			}
		}
		
		for(Entry<String,Double> entrySet : arr.entrySet()){
			System.out.printf("%s %.4f",entrySet.getKey(),entrySet.getValue()/cnt*100);
			System.out.println();
		}
	}

}

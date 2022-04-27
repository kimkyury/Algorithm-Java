import java.util.*;

public class SelectPresident {
    
    public char solution (int n, String str){
        char answer=' ';

        HashMap<Character, Integer> map = new HashMap<>();

        for( char x : str.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        int max = Integer.MIN_VALUE;

        for( char x : map.keySet() ) {
            if(map.get(x) > max){
                max = map.get(x);
                answer = x;
            }
        }
        
        return answer;
    }


    public static void main (String [] args) {

        Main T = new Main();
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
        String str = sc.next();

		System.out.print(T.solution(n, str));
    }
}

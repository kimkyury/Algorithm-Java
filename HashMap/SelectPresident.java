import java.util.*;

 public class SelectPresident {
    public String solution (String str){
        String answer="";
        int max = Integer.MIN_VALUE;

        HashMap<Character, Integer> map = new HashMap<>();

        for( char x : str.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        for( char x : map.keySet() ) {
            if(map.get(x) > max){
                max = map.get(x);
                answer = String.valueOf(x);
            }
        }
        return answer;
    }


    public static void main (String [] args) {

        SelectPresident T = new SelectPresident();
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
        String str = sc.next();
        String answer = T.solution(str);
		System.out.print(answer);
    }
}

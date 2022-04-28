import java.util.*;

class Anagram {

    public String solution (String str1, String str2){
        String answer = "YES";
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for( char x : str1.toCharArray()){
            map1.put(x, map1.getOrDefault(x, 0)+1);
        }
        
        for( char x : str2.toCharArray()){
            map2.put(x, map2.getOrDefault(x, 0)+1);
        }

        for( char x : str1.toCharArray()){
            // System.out.println(
            //         "x: " + x + ", map1's x: " 
            //         + map1.get(x) + ", map2's x:"
            //         + map2.get(x) 
            //     );
                
            if ( map1.get(x) != map2.get(x)){
                answer = "NO";
            }
        }
        return answer;
    }

    public static void main (String [] args) {

        Anagram T = new Anagram();
		Scanner sc = new Scanner(System.in);
		String str1 =sc.nextLine();
        String str2 = sc.nextLine();

		System.out.print(T.solution(str1, str2));
    }
}
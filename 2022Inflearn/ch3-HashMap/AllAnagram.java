package HashMap;

import java.util.HashMap;
import java.util.Scanner;


class AllAnagram{
    public int solution(String s, String t ){
        int answer = 0;
        // bacaAacba
        // abc

        HashMap<Character, Integer> mapS= new HashMap<>();
        HashMap<Character, Integer> mapT= new HashMap<>();
        

        for(int i =0; i<t.length(); i++){
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) +1);
        }

        int lt = 0;
        int cnt;
        for(int rt = t.length(); rt <s.length(); rt++){
            cnt =0;
            
            for(Character c : mapT.keySet()){
                if( mapS.get(c) == mapT.get(c)) cnt ++;
                else break;
            }

            if(cnt == mapT.size()) answer++;

            mapS.put(s.charAt(lt), mapS.get(s.charAt(lt)) -1);   
            mapS.put(s.charAt(rt), mapS.getOrDefault(s.charAt(rt),0) +1);   
            if(mapS.get(t.charAt(lt)) == 0 ) mapS.remove(t.charAt(lt));
            lt++;
 
        }
        cnt=0;
        for(Character c : mapT.keySet()){
            if( mapS.get(c) == mapT.get(c)) cnt ++;
            else break;
        }
        if(cnt == mapT.size()) answer++;
        


         return answer;
    }

    public static void main(String [] args){
        AllAnagram T =  new AllAnagram();

        Scanner sc= new Scanner(System.in);
        // 500이하의 음이 아닌 정수
        String s = sc.nextLine();
        String t = sc.nextLine();

        System.out.print(T.solution(s,t));

    }
}
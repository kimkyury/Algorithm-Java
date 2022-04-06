package HandlingString;

import java.util.*;

class ReverseSpecificWord {
    public ArrayList<String> solution (int n, String [] str){
        ArrayList<String> answer = new ArrayList<>();

        for(String x : str) {
            char [] s = x.toCharArray();
            int lt = 0, rt =x.length() -1;

            while(lt < rt){
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt ++;
                rt --;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }
        return answer;

        /*

        Character tmp;
        int index =0;
        for(String x : str){
            StringBuilder sb = new StringBuilder();
            for ( int i = x.length() -1; i>=0; i--){
                tmp= x.charAt(i);
                sb.append(tmp);
            }
            answer.add(index, sb.toString());
            index++;
        }
        return answer; */
    }
    public static void main (String [] args){
        ReverseSpecificWord T = new ReverseSpecificWord();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        String [] str = new String [n];

        for (int i =0; i<n; i++){
            str[i] = sc.next();
        }

        for(String x : T.solution(n, str)) {
            System.out.println(x);
        }
    }
}
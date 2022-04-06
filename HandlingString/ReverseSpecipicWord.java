package HandlingString;


import java.util.*;

class ReverseSpecificWord {
    public String solution (String str){

        String answer;

        // 알파벳, 특수문자로 구성 -> 영어 알파벳만 뒤집기, 특수문자는 그대로
        // a#b!GE*T@S
        //  (ASKII) 48 <= 특수문자 <= 57,  91 <= 특수문자 <= 96
        //  (ASKII) 65 <= 영어 소문자 <= 90, 97 <= 영어 대문자 <= 122

        char [] cArray = str.toCharArray();
        int lt =0, rt= cArray.length -1;

        
        while(lt < rt) {
            if(!Character.isAlphabetic(cArray[lt])) lt++;
            else if(!Character.isAlphabetic(cArray[rt])) rt++;
            else{
                char tmp=cArray[lt];
                cArray[lt] = cArray[rt];
                cArray[rt] = tmp;
                lt++;
                rt--;

            }
        }

            

        /* 내가 짠 코드
        while (lt < rt){
            if ( Character.isAlphabetic(cArray[lt])){
                char tmp = cArray[lt];
                
                if (Character.isAlphabetic(cArray[rt])){
                    cArray[lt] = cArray[rt];
                    cArray[rt] = tmp;
                    rt--;
                    lt++;
                }else{
                    rt--;
                }
                
            }else{
                lt++;
            }
        } */


        answer = String.valueOf(cArray);

 
        return answer; 
    }
    public static void main (String [] args){
        ReverseSpecificWord T = new ReverseSpecificWord();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.print(T.solution(str));

    }
}
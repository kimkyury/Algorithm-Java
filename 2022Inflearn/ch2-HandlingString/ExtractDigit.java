package HandlingString;

import java.util.Scanner;

class ExtractDigit {
    public int solution (String str){

        int answer = 0;

        String answerStr = "";

        for(char c : str.toCharArray()){
            if( c >=48 && c <=57){  //or Chracter.isDigit(x)
                answerStr += (c-48);
            }
        }
        answer = Integer.valueOf(answerStr);

        /*
        //int로 해결하기
        int answer=0;
        int mul = 10;

        for ( char c : str.toCharArray() ){
            int charToInt = c;
            if ( charToInt >= 48 && charToInt <= 57 ){
                answer = answer*mul + (charToInt-48);
            }
        } */
        return answer;
    }

    public static void main (String [] args){
        ExtractDigit T = new ExtractDigit();  
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.print(T.solution(str));
    }
}
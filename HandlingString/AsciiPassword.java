import java.util.Scanner;

class AsciiPassword {
    public String solution (int cntChar, String str){
        // CompressionString

        String answer="";
        // '#*****#' -> 이진수로 바꾸기, #:1, *:0
        // 2진수를 10진수화 하기
        // 아스키 번호에 대해서 문자로 변환하기


        for (int i =0; i<cntChar; i++){
            String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            answer += (char) num;
            str = str.substring(7); // 이렇게 하면 7자리 이상만 남는다
        }


        /*
        String binary;
        String ascii;
        int asciiToInt;

        String str2;
        char asciiToChar;
        for ( int i =0; i<cntChar; i++){
            str2 = str.substring(i*7, (i+1)*7);
            binary = "";
            for ( int j =0; j<7; j++){
                if ( str2.charAt(j) == '#') binary += 1;
                else binary += 0;
            }
            ascii = String.valueOf(Integer.parseInt(binary));
            
            asciiToInt = Integer.parseInt(ascii, 2);
            asciiToChar = (char)asciiToInt;
            answer += asciiToChar;
        } */


        return answer;

    }
    public static void main (String [] args){
        AsciiPassword T = new AsciiPassword();  
        Scanner sc = new Scanner(System.in);

        int cntChar = sc.nextInt();
        String str = sc.next(); //대문자로 입력받는다

        System.out.print(T.solution(cntChar, str)); 
    }
}
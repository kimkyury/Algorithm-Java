import java.io.*;
import java.util.*;

public class JustNowMusic {
    public String solution(String m, String [] musicinfos){
       String answer = "(None)";

        // case1: 전체음악
        // case2: 부분음악 - 멜로디 구간이 존재해도, 해당 음악이 아닐 수 있음

        // 조건 일치 음악이 여러 개 일시, 라디오에서 재생된 시간이 제일 긴 음악 제목 반환
        // 재생된 시간이 같은 경우 먼저 입력된 음악 제목 반환

        // ',' 기준으로 문자열을 분리한다
        // int i = st[0]; i<st[2] 까지하여 tmp에 st[4]를 반복하여 저장한다
        // 그 값이 입력된 m과 일칙하는지 확인한다

        int maxTime = 0; // 재생시간
        for( String musicinfo : musicinfos){
            StringTokenizer st = new StringTokenizer(musicinfo, ",");
            String startTime = st.nextToken();
            String endTime = st.nextToken();
            String title = st.nextToken();
            String sheetMusic = convertToLength1s(st.nextToken());

            int takenTime = calTime(startTime, endTime);
            //System.out.println("걸린시간" + takenTime);

            String allMelody ="";
            char [] stringToCarArray = sheetMusic.toCharArray();
            int index = 0;
            for(int i =0; i<takenTime; i++){
                if(index >= stringToCarArray.length){
                    index = 0;
                }
                allMelody += stringToCarArray[index++];
            }
            //System.out.print("전체멜로디: " + allMelody + "\n");

            String findSheet = convertToLength1s(m);
            if(allMelody.contains(findSheet)){
                if(maxTime < allMelody.length()){
                    maxTime = allMelody.length();
                    answer = title;
                }
            }
        }

        /* System.out.println("시작시간:" + startTime +
        "\n끝난시간:" + endTime +
        "\n제목:" + title +
        "\n악보:" + sheetMusic ); */

        return answer;
    }

    public String convertToLength1s(String sheet){

        String result = sheet;
        result = result.replaceAll("A#", "1");
        result = result.replaceAll("C#", "2");
        result = result.replaceAll("D#", "3");
        result = result.replaceAll("F#", "4");
        result = result.replaceAll("G#", "5");
       // System.out.print("\n바꾸기:" + result);
        return result;
    }

    public int calTime(String startTime, String endTime){
        int result = 0;

        StringTokenizer st = new StringTokenizer(startTime, ":");
        int starttimeToMinute = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        st = new StringTokenizer(endTime, ":");
        int endtimeToMinute = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        

        result = endtimeToMinute - starttimeToMinute;
        return result;
    }





    public static void main (String [] args) throws IOException{
        JustNowMusic Problem = new JustNowMusic();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String m = "CC#BCC#BCC#BCC#B"	;
        // 시작시간, 끝난 시간, 음악 제목, 악보정보
        String musicinfos [] = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};

        System.out.print(Problem.solution(m, musicinfos));

    }
}
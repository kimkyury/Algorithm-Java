import java.io.*;
import java.util.*;

public class Cache {
    public int solution(int cacheSize, String [] cities){
        // DB캨시 적용시 크기에 따른 실행시간 측정 프로그램 작성
        // Least Recently Used 알고리즘 사용하기

        int answer = 0;
        LinkedList <String> cache = new LinkedList<>();
        Integer [] cacheTime = new Integer [cacheSize];


        if ( cacheSize == 0) return cities.length*5;

        // city가 배열 안에서 발견 -> hit순으로 정렬되어야 함
        for(String city : cities){
            city = city.toUpperCase();
            boolean isExist = false;

           
            if ( cache.contains(city)) {
                isExist = true;
                cache.remove(city);
                cache.add(city);
            }
            
            if(!isExist){
                if ( cache.size() == cacheSize) cache.remove(0);
                cache.add(city);
                answer += 5;
            }
            
        }

        return answer;
    }
    public static void main (String [] args) throws IOException{
        Cache Problem = new Cache();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cacheSize = 3;
        String [] cities = {
            "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
        };

        System.out.print(Problem.solution(cacheSize, cities));

    }
}
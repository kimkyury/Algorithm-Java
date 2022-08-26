package HandlingString;

import java.util.*;

class DistanceChar {
    public int[] solution (String str, char c){
        //distanceChar

        int [] distance = new int [str.length()];


        int tmpD = 1000;
        for (int i =0; i<str.length(); i++){
            if(str.charAt(i) == c){
                tmpD = 0;
                distance[i] = tmpD;
            } else{
                distance[i] = tmpD;
            }
            tmpD++;
        }

        tmpD = 1000;
        for ( int i =str.length()-1; i>=0; i--){
            if ( str.charAt(i) == c){
                tmpD = 0;
                //tmpD = 0;
                //distance[i] = tmpD;
            }else{
                distance[i] = Math.min(distance[i], tmpD);
                /*if (distance[i] > tmpD){
                    distance[i] = tmpD;
                }*/
            }
            tmpD++;
        }


        return distance;
    }

    public static void main (String [] args){
        DistanceChar T = new DistanceChar();  
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char c = sc.next().charAt(0);
        int [] distance = T.solution(str, c);

        for (int i =0; i<str.length(); i++){
            System.out.print(distance[i] + " ");
        }
    }
}
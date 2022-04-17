import java.util.Scanner;

class Erastothenes {
    public int solution (int n ){
        
        int answer = 0;

        int [] intArr = new int [n+1];

        for(int i =2; i<= n; i++){
            if ( intArr[i] == 0){
                answer++;
                for(int j =i; j<=n; j = j+i){
                    intArr[j] = 1;
                }
            }
        }
        return answer;

    }
    public static void main (String [] args){
        Erastothenes T = new Erastothenes();  
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.print(T.solution(n));
    }
}


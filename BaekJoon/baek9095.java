import java.io.*;

public class baek9095 {
    static int dp [] = new int [11];
    public static void main(String [] args) throws IOException{
        dp[1] = 1;// 1
        dp[2] = 2; // 2= 1+1 
        dp[3] = 4; // 3= 1+1+1= 1+2= 2+1

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));    
        int T = Integer.parseInt(br.readLine());
        int [] answer = new int [T];

        // 케이스마다 입력될 n에 대한 개수를 구하는 함수를 호출한다
        for (int i =0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            answer[i] = recursive(n);
        }

        for(int i =0; i<T; i++){
            System.out.print(answer[i]+"\n");
        }
    }

    // T케이스가 크다고 생각하면...... 어? 생각해도 그냥 저장해야겠네. 어차피 문제에선 11이니까 이게 제일 낫다.
    static int recursive(int n){
        //만약 넘어온 n값이 이미 카운트 된 값이라면, 바로 출력하도록 하자
        if(dp[n] != 0){
            return dp[n];
        }
        // 4부터 시작하여 n까지 점화식으로 구한다
        for(int i=4; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
}

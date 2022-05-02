import java.util.Scanner;


class Lotto_Lanking{
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0,0};
        //44, 1, 0, 0, 31 25
        //31, 10, 45, 1, 6, 19

        int same_cnt = 0;
        int zero_cnt = 0;
        for( int i =0; i<6; i++){
            if( lottos[i] == 0)  zero_cnt++;
        }

        for(int i =0; i<6; i++){
            for(int j =0; j<6; j++){
                if( lottos[i] == win_nums[j]){
                    same_cnt++;
                    break;
                }
            }
        }
        
        int max_cnt = zero_cnt + same_cnt;
        int min_cnt = same_cnt;

        answer[0] = 7-max_cnt;
        answer[1] = 7-min_cnt;

        if( answer[0] > 6) answer [0] = 6;
        if( answer[1] > 6) answer [1] = 6;
         return answer;
    }

    public static void main(String [] args){
        Lotto_Lanking T =  new Lotto_Lanking();

        Scanner sc= new Scanner(System.in);
        int [] lottos = new int [6];
        int [] win_nums = new int [6];
        for ( int i =0; i<6; i++){
            lottos[i] = sc.nextInt();
        }

        for(int i =0; i<6; i++){
            win_nums[i] = sc.nextInt();
        }

        for(int x : T.solution(lottos, win_nums)){
            System.out.print(x + " ");
        }

    }
}
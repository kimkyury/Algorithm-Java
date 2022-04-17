import java.util.Scanner;

class Ranking {

    public int [] solution (int [] arr){
        int [] answer = new int [arr.length];

        int rank;
        for(int i =0; i<arr.length; i++){
            rank=1;
            for(int j = 0; j<arr.length; j++){
                if(arr[i] < arr[j]){
                    rank ++;
                }
            }   
            answer[i] = rank;
        }


        return answer;
    }
    public static void main (String [] args){
		Ranking T = new Ranking();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}

        for(int x : T.solution(arr)){
            System.out.print(x + " ");
            
        }
	
    }
}


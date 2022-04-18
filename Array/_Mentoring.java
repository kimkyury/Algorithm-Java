import java.util.Scanner;
class Mentoring {

    public int solution (int [][] arr, int n, int m){

        int answer=0;


        /*
        for(int i = 1 ; i<=n; i++){ //student
            for(int j=1; j<=n; j++){ //studnet
                int cnt =0;
                for(int k=0; k<m; k++){ //test
                    int pi=0, pj=0;
                    for(int s=0; s<n; s++){ //rank
                        if(arr[k][s] ==i) pi=s;
                        if(arr[k][s] ==j) pj=s;
                    }

                }
            } */


        
        int pi=0, pj=0;
        int cnt =0;
        for(int i=1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                cnt =0;
                
                for(int k=0; k< m; k++){
                    for(int s =0; s<n; s++){
                        if(arr[k][s] == i)
                            pi = s;
                        if(arr[k][s] == j)
                            pj =s;
                    } if(pi < pj){
                        cnt ++;
                    }
                }
                if( cnt == m){
                    answer++;
                }
            }
        }
        return answer;
    }
    public static void main (String [] args){
		Mentoring T = new Mentoring();
		Scanner kb = new Scanner(System.in);
		int cntS =kb.nextInt();
        int cntT = kb.nextInt();
		int[][] arr=new int[cntT][cntS];
		for(int i=0; i< cntT; i++){
            for(int j =0; j<cntS; j++){
                arr[i][j]=kb.nextInt();
            }
		}
        System.out.print(T.solution(arr, cntS, cntT));
        
        
	
    }
}


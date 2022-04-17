import java.util.Scanner;

class BiggerThanEWSN {
    /*
    public Boolean isMax (int [] arr, int num){
        
        int max =0;
        for(int i =0; i<arr.length; i++){
            if( max < arr[i]) max = arr[i];
        }

        if( num <= max)return false;
        else return true;
        
    } */

    public int solution (int [][] arr){
        int [] dx = {1, 0, -1, 0};
        int [] dy = {0, -1, 0, 1};

        int answer = 0;
        for(int i =0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                boolean isBigger = true;

                for(int k=0; k<4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    
                    if(
                            (nx >= 0 && nx <arr.length) &&
                            ( ny >= 0 && ny <arr.length) &&
                            arr[nx][ny] >= arr[i][j] ){
                        isBigger = false;
                        break;
                    }
                
                }   
                if(isBigger == true){
                    answer++;
                }
            }
        }


        /*
        int [] ewsn = new int [4];
        int maxValue = 0;
        for(int i =1; i<arr.length-1; i++){
            for(int j =1; j<arr.length-1; j++){
                maxValue = arr[i][j];
                ewsn[0] = arr[i+1][j];
                ewsn[1] = arr[i-1][j];
                ewsn[2] = arr[i][j+1];
                ewsn[3] = arr[i][j-1];
                if(isMax(ewsn, maxValue)){
                    answer ++;
                }
            }

        } */

        return answer;
    }
    public static void main (String [] args){
		BiggerThanEWSN T = new BiggerThanEWSN();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[][] arr=new int[n][n];
		for(int i=0; i<n; i++){
            for(int j =0; j< n; j++){
                arr[i][j]=kb.nextInt();
            }
		}

        System.out.print(T.solution(arr));
        
        
	
    }
}


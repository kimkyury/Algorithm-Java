


class Matrix_border{
    public int[] solution(int rows, int columns, int[][] queries){
        int [] answer = new int [queries.length];
        int [][] initMatrix = new int [rows][columns];

        int number = 1;
        for(int i = 0; i< rows; i++){
            for ( int j =0; j<columns; j++)
                initMatrix[i][j] = number++;
        }
        /*
        for(int[] arr : initMatrix){
            for(int x : arr)
                System.out.print(x + "\t");
            System.out.println("");
        }
        System.out.println(""); */

        int index = 0;
        for(int [] arr: queries){
            int  min = Integer.MAX_VALUE;
            //(x,y) : (2,2), (4, 5) => (1,1) (3,4)
            int x1 = arr[1]-1; //1
            int y1 = arr[0]-1;  //4
            int y2 = arr[2]-1; //5
            int x2 = arr[3]-1; //2
            // 00 01 02, 02 12 22 32, 32 31 30, 30 20 10 00
            
            int edge = initMatrix[y1][x2];
            if(min > edge) min = edge;
            for(int i =x2; i > x1; i--) {
                initMatrix[y1][i] = initMatrix[y1][i-1];
                if (min > initMatrix[y1][i-1]) min = initMatrix[y1][i-1];
            }
            for(int i = y1; i <y2 ; i++){ // 1, 2
                initMatrix[i][x1] = initMatrix[i+1][x1];
                if (min > initMatrix[i+1][x1]) min = initMatrix[i+1][x1];
            }
            for(int i =x1; i < x2; i++){  // 1, 2, 3
                initMatrix[y2][i] = initMatrix[y2][i+1];
                if (min > initMatrix[y2][i+1]) min = initMatrix[y2][i+1];
            }
            for(int i = y2; i >y1 ; i--){  // 3, 2
                initMatrix[i][x2] = initMatrix[i-1][x2];
                if (min > initMatrix[i-1][x2]) min = initMatrix[i-1][x2];
            }
            answer[index++] = min;
            initMatrix[y1+1][x2] = edge;

            for(int[] arr2 : initMatrix){
                for(int x : arr2){
                    System.out.print(x + "\t");
                }
                System.out.println("");
            }
            System.out.println(""); 

        }

         return answer;
    }

    public static void main(String [] args){
        Matrix_border T =  new Matrix_border();

        int rows = 3;
        int columns = 3;
        int [][] queries = {{1,1,2,2}, {1,2,2,3}, {2,1,3,2}, {2,2,3,3}};
        
        for(int x: T.solution(rows, columns, queries)){
            System.out.print(x+ " ");
        }

    }
}
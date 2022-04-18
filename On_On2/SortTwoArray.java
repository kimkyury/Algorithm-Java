import java.util.*;
import java.util.Scanner;

class SortTwoARray {

    public ArrayList<Integer> solution (int n, int [] nArr, int m, int [] mArr){

        ArrayList<Integer> array = new ArrayList<Integer>();


        int p1=0, p2=0;

        while(p1 <n && p2 <m){
            if(nArr[p1] < mArr[p2]){
                array.add(nArr[p1++]);
            }else{
                array.add(mArr[p2++]);
            }
        }

        while(p1 <n) array.add(nArr[p1++]);
        while(p2 <m) array.add(mArr[p2++]);


    //    for(int i =0; i<n; i++){
    //        for(int j =0; j<m; j++){
    //            if( i<n && (nArr[i] < mArr[j])){
    //                 array.add(nArr[i]);
    //                 i++;
    //            }else{
    //                if(j<m){
    //                 array.add(mArr[j]);
    //                 j++;
    //                }else{
    //                    continue;
    //                }
    //            }
    //        }
    //    }


        return array;
    }
    public static void main (String [] args){
		SortTwoARray T = new SortTwoARray();
		Scanner sc = new Scanner(System.in);

		int n =sc.nextInt();
        int [] nArray = new int [n];
        for(int i=0; i<n; i++){
            nArray[i] = sc.nextInt();
        }

        int m =sc.nextInt();
        int [] mArray = new int [m];
        for(int i=0; i<m; i++){
            mArray[i] = sc.nextInt();
        }


        for(int x : T.solution(n, nArray, m, mArray)){
            System.out.print(x + " ");
        }
        
        
	
    }
}


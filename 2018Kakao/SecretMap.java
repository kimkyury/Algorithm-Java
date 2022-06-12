import java.io.*;

public class SecretMap {
    public String[] solution(int n, int [] arr, int []arr2){
        
        String answer[] = new String[n];

        for(int i = 0; i<n; i++){ 
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            sb1.append(Integer.toBinaryString(arr[i]));
            sb2.append(Integer.toBinaryString(arr2[i]));

            while ( sb1.length() < n)
                sb1.insert(0, '0');
            while ( sb2.length() < n)
                sb2.insert(0, '0');

            answer[i] = "";
            for(int j=0; j<n; j++){
                
                if( sb1.charAt(j) == '1' || sb2.charAt(j) == '1'){
                    answer[i] += '#';
                }else{
                    answer[i] += ' ';
                }
            }
            
        }
        return answer;
    }
    
    
    public static void main (String [] args){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SecretMap solution = new SecretMap();


        int n = 5;
        int [] arr = {9, 20, 28, 18, 11};
        int [] arr2 = {30, 1, 21, 17, 28};

        String [] answer = solution.solution( n, arr, arr2);

        for(String str : answer){
            System.out.println(str);
        }
    }
}

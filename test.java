


class Test{
    public int solution(int n, int k){
        int answer = 0;
        // 1. n을 k 진수로 바꿀 것
        // 2. 소수를 판별할 것 (n을 k진수로 바꾸기)
        // 3. 정규식으로 해보자

        // 1
        StringBuilder sb = new StringBuilder();
        int number = n;
        while( number > 0){
            sb.append(number % k);
            number = number / k;
        }
        System.out.println(sb + " " + number);
        String kNumber = sb.reverse().toString();

        // 2
        String [] numSection = kNumber.split("0");

        for(String num : numSection){
            System.out.print(num + " ");
            if( num == "1") continue;
            for ( int i =2; i<num.length(); i++){
                if(Long.parseLong(num) % i == 0){
                    break;
                }
                // Prime이라면
                answer++;
            }
        }


        return answer;
    }

    public static void main(String [] args){
        Test T =  new Test();
        
        int n = 437674;
        int k = 3;

        System.out.print(T.solution(n, k));

    }
}
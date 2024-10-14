class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int vM = Integer.parseInt(video_len.substring(0, 2));
        int vS = Integer.parseInt(video_len.substring(3, 5));
        int vTime = vM*60 + vS;
        
        int m = Integer.parseInt(pos.substring(0, 2));
        int s = Integer.parseInt(pos.substring(3, 5));
        int time = m*60 + s;
        
        int sM = Integer.parseInt(op_start.substring(0,2));
        int sS = Integer.parseInt(op_start.substring(3, 5));
        int sTime = sM*60 + sS;
        
        int eM = Integer.parseInt(op_end.substring(0, 2));
        int eS = Integer.parseInt(op_end.substring(3, 5));
        int eTime = eM*60 + eS;
        
        for(String command : commands){
            if ( sTime <= time && time <= eTime){
                time = eTime;    
            }
                
            if (command.equals("next")){
                
                time += 10;
                if ( vTime - time < 10){
                    time = vTime;
                }
                
            }else if (command.equals("prev")){
                
                time -=10;
                if(time < 10 ){
                    time = 0;
                }
            }
            if ( sTime <= time && time <= eTime){
                time = eTime;    
            }

        }
        

        String an = String.valueOf(time/60);
        if ( an.length() == 1){
            an = "0" + String.valueOf(time/60);
        }
        String as = String.valueOf(time%60);
        if ( as.length() == 1){
            as = "0" + String.valueOf(time%60);
        }
        
        
        String answer = an + ":" + as;
        return answer;
    }
}
import java.time.LocalDate;


class Testt{

    private static LocalDate[] date = new LocalDate[2];


    public static void main(String [] args){
        
        date[0] = LocalDate.of(1900, 01, 03);
        date[1] = LocalDate.of(2010, 03, 10);
        //String StartTime = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String log = "사용자 입력값: " + date[0];
        System.out.println(log);
    }
}
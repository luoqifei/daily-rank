package dayscode;

import java.time.LocalDate;

/**
 * 获取某个日期的周几
 */
public class DayOfWeek {
    public static String getDay(String day, String month, String year) {
        LocalDate localDate = LocalDate.of(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
        return  localDate.getDayOfWeek().toString();
    }
    public static void main(String[] args) {
        String year = "2018";
        String month = "08";
        String day = "12";
        System.out.println(getDay(day,month,year));
    }
}

package cc.openhome;

import static java.lang.System.*;
import java.time.chrono.MinguoDate;
import static java.time.format.DateTimeFormatter.ofPattern;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Exercise2 {
    public static void main(String[] args) {
        // 今天
        MinguoDate minguoDate = MinguoDate.now();
        showTitle(minguoDate);
        showDate(minguoDate);
    }

    private static void showTitle(MinguoDate minguoDate) {
        out.printf("%n%s%n%n", 
                minguoDate.format(ofPattern("民國 yyy 年 MM 月 dd 日 EE")));
        String[] weekDays = {"日", "一", "二", "三", "四", "五", "六"};
        for(String weekDay : weekDays) {
            out.printf("%s ", weekDay);
        }
        out.println();
    }
    
    private static void showDate(MinguoDate minguoDate) {
        // 今天是本月第幾天
        int dayOfMonth = minguoDate.get(ChronoField.DAY_OF_MONTH);
        // 取得本月第一天，計算出星期幾
        int dayOfWeek = minguoDate.plus(-dayOfMonth + 1, ChronoUnit.DAYS).get(ChronoField.DAY_OF_WEEK);
        // dayOfWeek 是用來排版用的
        dayOfWeek++;
        out.printf("%" + (2 * (dayOfWeek + 1)) + "s", "");
        for(int i = 1; i <= minguoDate.lengthOfMonth(); i++, dayOfWeek++) {
            out.printf("%2d ", i);
            if((dayOfWeek % 7) == 0) {
                out.println();
            }
        }
    }
}

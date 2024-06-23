package hei.school.pointingsystem;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class JanitorCalendar {
    private Calendar calendar;

    public JanitorCalendar(LocalDate startMonth, LocalDate endMonth, List<LocalDate> publicHolidays) {
        this.calendar = Calendar.getInstance();

        calendar.setTime(Date.from(startMonth.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        if (calendar.get(Calendar.DAY_OF_WEEK)!= Calendar.MONDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, Calendar.MONDAY - calendar.get(Calendar.DAY_OF_WEEK));
        }

        Date endDate = Date.from(endMonth.atTime(23, 59, 59).atZone(ZoneId.systemDefault()).toInstant());
        calendar.setTime(endDate);

        for (LocalDate holiday : publicHolidays) {
            calendar.add(Calendar.DATE, (int) ((holiday.getDayOfMonth() + 7) % 7)); 
            calendar.set(Calendar.MONTH, holiday.getMonthValue() - 1); 
            calendar.set(Calendar.DAY_OF_MONTH, holiday.getDayOfMonth()); 
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
        }
    }
}

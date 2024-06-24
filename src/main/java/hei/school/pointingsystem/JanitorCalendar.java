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

        for (LocalDate holiday : publicHolidays) {
            Date holidayDate = Date.from(holiday.atStartOfDay(ZoneId.systemDefault()).toInstant());
            calendar.add(Calendar.DAY_OF_YEAR, holidayDate.getDate() - calendar.get(Calendar.DAY_OF_YEAR));
            calendar.add(Calendar.MONTH, holidayDate.getMonth() - calendar.get(Calendar.MONTH));
            calendar.add(Calendar.YEAR, holidayDate.getYear() - calendar.get(Calendar.YEAR));
            calendar.set(Calendar.DAY_OF_MONTH, holiday.getDayOfMonth());
        }
    }
}

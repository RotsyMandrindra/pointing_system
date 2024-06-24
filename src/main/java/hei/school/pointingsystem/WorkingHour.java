package hei.school.pointingsystem;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data

public class WorkingHour {

    private int normalHour;
    private int overtimeHour;
    private int additionalHour;
    private LocalTime startTime;
    private LocalTime endTime;

    public boolean isNightShift() {
        LocalTime startOfNight = LocalTime.of(7, 0);
        LocalTime endOfNight = LocalTime.of(17, 0);

        return !(startTime.isAfter(startOfNight) && endTime.isBefore(endOfNight))
                && !(startTime.isBefore(startOfNight) && endTime.isAfter(endOfNight));
    }
}

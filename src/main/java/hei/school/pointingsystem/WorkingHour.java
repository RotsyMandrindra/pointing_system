package hei.school.pointingsystem;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class WorkingHour {

    private int normalHour;
    private int overtimeHour;
    private int additionalHour;
    private LocalTime startTime;
    private LocalTime endTime;

    public WorkingHour(int normalHour, int overtimeHour, int additionalHour) {
        this.normalHour = normalHour;
        this.overtimeHour = overtimeHour;
        this.additionalHour = additionalHour;
    }

    public boolean isNightShift() {
        LocalTime startOfNight = LocalTime.of(17, 0);
        LocalTime endOfNight = LocalTime.of(7, 0);

        return !(startTime.isAfter(startOfNight) && endTime.isBefore(endOfNight))
                && !(startTime.isBefore(startOfNight) && endTime.isAfter(endOfNight));
    }
}

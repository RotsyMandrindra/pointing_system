package hei.school.pointingsystem;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class WorkingHour {

    private int normalHour;
    private int overtimeHour;
    private int additionalHour;
    private int weekbetween;
}

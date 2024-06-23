package hei.school.pointingsystem;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class WorkingHour {
    private int normalHour;
    private int overtimeHour;
    private int additionalHour;
}

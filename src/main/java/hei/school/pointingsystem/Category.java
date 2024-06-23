package hei.school.pointingsystem;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class Category {
    private String name;
    private int normalHoursPerWeek;
    private double weeklySalary;

    public double getHourRate(){
        return weeklySalary / normalHoursPerWeek;
    }
}

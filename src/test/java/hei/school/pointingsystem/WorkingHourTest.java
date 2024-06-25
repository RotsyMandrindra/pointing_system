package hei.school.pointingsystem;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkingHourTest {
    @Test
    void testWorkingHourRakoto() {
        WorkingHour workingHourRakoto = new WorkingHour(10, 0, 7, 0);
        LocalDate startDate = LocalDate.of(2024, 05, 26);
        LocalDate endDate = LocalDate.of(2024, 07, 07);

        long totalWorkingHour = workingHourRakoto.calculateTotalWorkingHour(startDate, endDate);
        assertEquals(420, totalWorkingHour);
    }

    @Test
    void testWorkingHourRabe() {
        WorkingHour workingHourRabe = new WorkingHour(0, 0, 7, 14);
        LocalDate startDate = LocalDate.of(2024, 05, 26);
        LocalDate endDate = LocalDate.of(2024, 07, 07);

        long totalWorkingHour = workingHourRabe.calculateTotalWorkingHour(startDate, endDate);
        assertEquals(588, totalWorkingHour);
    }

    @Test
    void calculateRakotoSalaryEarnedPerHour(){
        WorkingHour workingHourRakoto = new WorkingHour(10, 0, 7, 0);
        double workingHourRakotoPerDay = workingHourRakoto.calculateSalaryEarnedPerHourInDay(100000);
        assertEquals(1429, workingHourRakotoPerDay);
    }

    @Test
    void calculateRabeSalaryEarnedPerHour(){
        WorkingHour workingHourRabe = new WorkingHour(0, 0, 7, 14);
        double workingHourRakotoPerDay = workingHourRabe.calculateSalaryEarnedPerHourInNight(100000, 130);
        assertEquals(1327, workingHourRakotoPerDay);
    }
}

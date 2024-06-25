package hei.school.pointingsystem;

public class Salary {

    private double netSalary;
    private final WorkingHour workingHour;
    private final Category category;

    public Salary(double grossSalary, WorkingHour workingHour, Category category) {
        this.workingHour = workingHour;
        this.category = category;
        this.netSalary = calculateNetSalary(grossSalary);
    }

    public double calculateNetSalary(double grossSalary) {
        netSalary = grossSalary - (grossSalary * 20 / 100);
        return netSalary;
    }

    /*public double calculateAdditionalHourSalary() {
        double normalHourRate = category.getHourRate();
        int additionalHour = workingHour.getAdditionalHour();
        double additionalHourSalary = 0.0;

        if (additionalHour > 0) {
            boolean isNightShift = workingHour.isNightShift();

            int additionalHourFull = Math.min(10, additionalHour);
            int additionalHourPartial = Math.max(0, additionalHour - 8);
            double nightShiftMultiplier = isNightShift ? 1.3 : 1.0;

            additionalHourSalary += additionalHourFull * normalHourRate * nightShiftMultiplier;
            additionalHourSalary += additionalHourPartial * normalHourRate * nightShiftMultiplier;
        }
        return additionalHourSalary;
    }

    public double calculateOvertimeSalary() {
        double normalHourlyRate = category.getHourRate();
        int overtimeHours = workingHour.getOvertimeHour();
        double overtimeSalary = 0.0;

        if (overtimeHours > 0) {
            boolean isNightShift = workingHour.isNightShift();

            int overtimeHour30 = Math.min(8, overtimeHours);
            int overtimeHour50 = Math.min(12, Math.max(0, overtimeHours - 8));

            double nightShiftMultiplier = isNightShift ? 1.3 : 1.0;

            overtimeSalary += overtimeHour30 * normalHourlyRate * nightShiftMultiplier;
            overtimeSalary += overtimeHour50 * normalHourlyRate * nightShiftMultiplier;
        }

        return overtimeSalary;
    }

    public double calculateTotalSalary() {
        double basicSalaryPerWeek = category.getWeeklySalary();
        double overtimeSalary = calculateOvertimeSalary();
        double additionalHourSalary = calculateAdditionalHourSalary();
        return basicSalaryPerWeek + overtimeSalary + additionalHourSalary;
    }*/
}

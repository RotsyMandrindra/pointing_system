package hei.school.pointingsystem;

public class Salary {
    private double netSalary;
    private WorkingHour workingHour;
    private Category category;
    
    public Salary(double grossSalary, WorkingHour workingHour, Category category){
        this.workingHour = workingHour;
        this.category = category;
        this.netSalary = calculateNetSalary(grossSalary);
    }

    public double calculateNetSalary(double grossSalary){
        netSalary = grossSalary - (grossSalary * 20 / 100);
        return netSalary;
    }

    public double calculateAdditionalHourSalary(){
        double normalHourRate = category.getHourRate();
        int additionalHour = workingHour.getAdditionalHour();
        double additionalHourSalary = 0.0;

        if(additionalHour > 0){
            int additionalHour30 = Math.min(8, additionalHour);
            int additionalHour40 =  Math.min(8, Math.min(0, additionalHour - 8 ));
            int additionalHour50 = Math.min(0, additionalHour - 16);

            additionalHourSalary += additionalHour30 * normalHourRate * 1.3;
            additionalHourSalary += additionalHour40 * normalHourRate * 1.4;
            additionalHourSalary += additionalHour50 * normalHourRate * 1.5;
        }
        return  additionalHourSalary;
    }

    public double calculateOvertimeSalary(){
        double normalHourlyRate = category.getHourRate();
        int overtimeHours = workingHour.getOvertimeHour();
        double overtimeSalary = 0.0;

        if (overtimeHours > 0) {
            int overtimeHour30 = Math.min(8, overtimeHours);
            int overtimeHour50 = Math.min(12, Math.max(0, overtimeHours - 8));

            overtimeSalary += overtimeHour30 * normalHourlyRate * 1.3;
            overtimeSalary += overtimeHour50 * normalHourlyRate * 1.5;
        }

        return overtimeSalary;
    }

    public double calculateTotalSalary(){
        double basicSalaryPerWeek = category.getWeeklySalary();
        double overtimeSalary = calculateOvertimeSalary();
        double additionalHourSalary = calculateAdditionalHourSalary();
        return basicSalaryPerWeek + overtimeSalary + additionalHourSalary;
    }
}

package task1.dao;

import java.util.ArrayList;

public class HourEmployee extends Employee {
    private int hourLimit = 40;
    // TODO @pre.condition weeklyHours.size() <= 4
    private ArrayList<Integer> weeklyHours;
    private double bonusRate = 1.5;

    public HourEmployee(String name, String empNum, double salary, ArrayList<Integer> weeklyHours) {
        super(name, empNum, salary);
        this.setType("Hour");
        this.weeklyHours = weeklyHours;
    }

    public void accept(IVisitor visitor) {
        visitor.calculateSalary(this);
    }

    public double getBonusRate() {
        return bonusRate;
    }

    public ArrayList<Integer> getWeeklyHours() {
        return weeklyHours;
    }

    public int getHourLimit() {
        return hourLimit;
    }

    public void setHourLimit(int hourLimit) {
        this.hourLimit = hourLimit;
    }

    public void setBonusRate(double bonusRate) {
        this.bonusRate = bonusRate;
    }

    public void setWeeklyHours(ArrayList<Integer> weeklyHours) {
        this.weeklyHours = weeklyHours;
    }
}

package task1.dao;

import java.util.ArrayList;

public class SalaryCalculator implements IVisitor {
    public void calculateSalary(SalEmployee se) {
        // Final salary equals to base salary
        se.setFinalSalary(se.getBaseSalary());
    }

    public void calculateSalary(HourEmployee he) {
        // For hourly employee the base salary should be hourly salary
        double finalSalary = 0.0;
        // TODO @pre.condition weeklyHours.size() <= 4
        ArrayList<Integer> weeklyHours = he.getWeeklyHours();
        int times = weeklyHours.size() > 4 ? 4 : weeklyHours.size();
        for (int i = 0; i < times; i++){
            int diffhours = weeklyHours.get(i) - he.getHourLimit();
            finalSalary += diffhours > 0 ? (he.getHourLimit() * he.getBaseSalary()) + (diffhours * he.getBonusRate() * he.getBaseSalary() ) : weeklyHours.get(i) * he.getBaseSalary();
        }
        he.setFinalSalary(finalSalary);
    }

    public void calculateSalary(ComEmployee ce) {
        // For commission employee
        double finalSalary = ce.getBaseSalary() + ce.getSales() * ce.getBonusRate();
        ce.setFinalSalary(finalSalary);
    }
}

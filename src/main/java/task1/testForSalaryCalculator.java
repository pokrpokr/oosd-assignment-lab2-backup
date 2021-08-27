package task1;

import task1.dao.ComEmployee;
import task1.dao.Employee;
import task1.dao.HourEmployee;
import task1.dao.SalEmployee;
import task1.services.EmployeeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class testForSalaryCalculator {
    public static void main(String[] args) {
        SalEmployee salEmp = new SalEmployee("SalEmp", "Sal123", 2000.0);
        ArrayList<Integer> weeklyHours = new ArrayList<Integer>();
        weeklyHours.add(38);
        weeklyHours.add(45);
        weeklyHours.add(20);
        weeklyHours.add(5);
        // TODO this one week should not be calcilated, calculate rules in SalaryCalculator class
        weeklyHours.add(50);
        HourEmployee hourEmp = new HourEmployee("HourEmp", "Hour123", 19, weeklyHours);
        ComEmployee comEmp = new ComEmployee("ComEmp", "Com123",1500, 3000);
        // TODO call EmployeeService
        EmployeeService es = new EmployeeService();
        HashMap<Employee, Double> result = new HashMap<Employee, Double>();
        // TODO testing print salary for single employee
        result = es.PrintSalary(salEmp);
        System.out.println(salEmp.getName() + "'s salary is " + result.get(salEmp) + "$");
        System.out.println("***********");
        // TODO testing print salary for multiple employees
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(salEmp);
        employees.add(hourEmp);
        employees.add(comEmp);
        result = es.PrintSalary(employees);
        for (Map.Entry<Employee, Double> e : result.entrySet()){
            System.out.println(e.getKey().getName() + "'s salary is " + e.getValue() + "$");
        }

    }
}

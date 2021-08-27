package task1.services;

import task1.dao.*;

import java.util.ArrayList;
import java.util.HashMap;

public class EmployeeService {
    // TODO mockup session
    public static Admin CurrentUser;
    private EmployeeDao employeeDao;

    public ArrayList<Employee> ListAllEmployees(){
        return employeeDao.findAll();
    }
    public Employee EmployeeDetails(long id){
        return employeeDao.findById(id).get(0);
    }
    public ArrayList<Employee> SearchEmployee(String name){
        return  employeeDao.findByName(name);
    }
    public boolean CreateEmployee(String[] args) {
        // TODO employee paramaters from GUI layer, asume args[0] is type
        // TODO here just are some dummy codes, just shows the workflow
        Employee newEmployee = null;
        if (args[0].equals("Sal")){
            newEmployee = new SalEmployee(args[1], args[2], Double.parseDouble(args[3]));
        } else if(args[0].equals("Hour")){
            // TODO follow the same logic and workflow from above, create new HourEmployee
        } else if(args[0].equals("Com")){
            // TODO follow the same logic and workflow from above, create new ComEmployee
        }
        if(newEmployee == null) { return false; }
        return employeeDao.insert(newEmployee);
    }
    public boolean UpdateEmployeeDetails(Employee emp){
        // TODO same workflow from above
        return employeeDao.update(emp);
    }
    public boolean DeleteEmployee(Employee emp){
        // TODO same workflow from above
        return employeeDao.delete(emp);
    }
    // Calculate and print salary for one employee
    public HashMap<Employee, Double> PrintSalary(Employee emp){
        HashMap<Employee, Double> finalSalayDetails = new HashMap<Employee, Double>();
        emp.accept(new SalaryCalculator());
        finalSalayDetails.put(emp, emp.getFinalSalary());
        return finalSalayDetails;
    }
    // Calculate and print salary for multiple employees
    public HashMap<Employee, Double> PrintSalary(ArrayList<Employee> emps){
        HashMap<Employee, Double> finalSalayDetails = new HashMap<Employee, Double>();
        for (Employee emp:emps) {
            emp.accept(new SalaryCalculator());
            finalSalayDetails.put(emp, emp.getFinalSalary());
        }
        return finalSalayDetails;
    }
}

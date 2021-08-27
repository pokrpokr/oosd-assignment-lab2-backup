package task1.dao;

import task1.database.DBFacade;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class EmployeeDaoImp implements EmployeeDao {
    public ArrayList<Employee> findAll() {
        // TODO Search all employees
        String sql = "SELECT * FROM employees";
        // Facade pattern
        DBFacade db = new DBFacade();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        HashMap<String, Object> result = db.read(sql);
        if(result.get("message").equals("success")){
            try
            {
                while (((ResultSet) result.get("data")).next()){
                    Employee employee = null;
                    if(((ResultSet) result).getString("type").equals("Sal")){
                         employee = new SalEmployee(((ResultSet) result).getString("name"),
                                ((ResultSet) result).getString("empNum"), ((ResultSet) result).getDouble("salary"));
                    } else if (((ResultSet) result).getString("type").equals("Hour")){
                        // TODO create HourEmployee like above from database
                    } else if (((ResultSet) result).getString("type").equals("Com")){
                        // TODO create ComEmployee like above from database
                    }
                    employees.add(employee);
                }
            } catch (Exception e) {
            }
        }
        return employees;
    }

    public ArrayList<Employee> findById(long id) {
        // TODO Find employee like above by searching id
        ArrayList<Employee> employees = new ArrayList<Employee>();
        return employees;
    }

    public ArrayList<Employee> findByName(String name) {
        // TODO Find employee like above by searching name
        ArrayList<Employee> employees = new ArrayList<Employee>();
        return employees;
    }

    public boolean insert(Employee em) {
        // TODO insert employee by DBFacade, example see above and AdminDaoImp class
        // TODO @pre.condition weeklyHours.size() <= 4 for HourEmployee
        return false;
    }

    public boolean update(Employee em) {
        // TODO update employee by DBFacade, example see above and AdminDaoImp class
        // TODO @pre.condition weeklyHours.size() <= 4 for HourEmployee
        return false;
    }

    public boolean delete(Employee em) {
        // TODO delete employee by DBFacade, example see above and AdminDaoImp class
        return false;
    }
}

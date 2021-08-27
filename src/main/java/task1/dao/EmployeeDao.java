package task1.dao;

import java.util.ArrayList;

public interface EmployeeDao {
    ArrayList<Employee> findAll();
    ArrayList<Employee> findById(long id);
    ArrayList<Employee> findByName(String name);
    boolean insert(Employee em);
    boolean update(Employee em);
    boolean delete(Employee em);
}

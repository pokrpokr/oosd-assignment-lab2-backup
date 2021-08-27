package task1.dao;

public class SalEmployee extends Employee {

    public SalEmployee(String name, String empNum, double salary) {
        super(name, empNum, salary);
        this.setType("Sal");
    }

    public void accept(IVisitor visitor) {
        visitor.calculateSalary(this);
    }
}

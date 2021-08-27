package task1.dao;

public abstract class Employee {
    private long id;
    private String name;
    private String empNum;
    private String type;
    // Base salary
    private double salary;
    // Calculated salary
    private double finalSalary = 0.0;

    public Employee(String name, String empNum, double salary){
        this.salary = salary;
        this.name = name;
        this.empNum = empNum;
    }

    public abstract void accept(IVisitor visitor);

    public String getType() {
        return type;
    }

    public double getFinalSalary() {
        return finalSalary;
    }

    public double getBaseSalary() {
        return salary;
    }

    public long getId() {
        return id;
    }

    public String getEmpNum() {
        return empNum;
    }

    public String getName() {
        return name;
    }

    public void setFinalSalary(double finalSalary) {
        this.finalSalary = finalSalary;
    }

    public void setBaseSalary(double salary) {
        this.salary = salary;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmpNum(String empNum) {
        this.empNum = empNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}

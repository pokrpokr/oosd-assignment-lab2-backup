package task1.dao;

public class ComEmployee extends Employee {
    private double sales;
    private double bonusRate = 0.15;

    public ComEmployee(String name, String empNum, double salary, double sales) {
        super(name, empNum, salary);
        this.setType("Com");
        this.sales = sales;
    }

    public void accept(IVisitor visitor) {
        visitor.calculateSalary(this);
    }

    public double getSales() {
        return sales;
    }

    public double getBonusRate() {
        return bonusRate;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public void setBonusRate(double bonusRate) {
        this.bonusRate = bonusRate;
    }
}

package task1.dao;

public interface IVisitor {
    void calculateSalary(SalEmployee se);
    void calculateSalary(HourEmployee he);
    void calculateSalary(ComEmployee ce);
}

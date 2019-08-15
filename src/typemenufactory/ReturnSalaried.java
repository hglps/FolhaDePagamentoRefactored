package typemenufactory;

import companypackage.Employee;
import companypackage.Salaried;
import strategy.UnionContract;

import java.util.ArrayList;

public class ReturnSalaried implements TypeOperation {
    @Override
    public Salaried returnNewEmployee(ArrayList<Employee> employees, int index) {
        Employee currEmployee = employees.get(index);
        String name = currEmployee.getName();
        String address = currEmployee.getAddress();
        String wayPayment = currEmployee.getWayPayment();
        UnionContract union = currEmployee.getUnion();
        return new Salaried(name, address, "s", wayPayment, union);
    }
}

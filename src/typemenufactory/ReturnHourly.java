package typemenufactory;

import companypackage.Employee;
import companypackage.Hourly;
import strategy.UnionContract;

import java.util.ArrayList;

public class ReturnHourly implements TypeOperation {
    @Override
    public Hourly returnNewEmployee(ArrayList<Employee> employees, int index) {
        Employee currEmployee = employees.get(index);
        String name = currEmployee.getName();
        String address = currEmployee.getAddress();
        String wayPayment = currEmployee.getWayPayment();
        UnionContract union = currEmployee.getUnion();
        return new Hourly(name, address, "h", wayPayment, union);
    }
}

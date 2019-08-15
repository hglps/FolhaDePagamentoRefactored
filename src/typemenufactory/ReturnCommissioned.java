package typemenufactory;

import companypackage.Commissioned;
import companypackage.Employee;
import strategy.UnionContract;

import java.util.ArrayList;

public class ReturnCommissioned implements TypeOperation {
    @Override
    public Commissioned returnNewEmployee(ArrayList<Employee> employees, int index) {
        Employee currEmployee = employees.get(index);
        String name = currEmployee.getName();
        String address = currEmployee.getAddress();
        String wayPayment = currEmployee.getWayPayment();
        UnionContract union = currEmployee.getUnion();
        return new Commissioned(name, address, "c", wayPayment, union);
    }
}

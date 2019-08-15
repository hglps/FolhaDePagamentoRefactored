package typemenufactory;

import companypackage.Commissioned;
import companypackage.Employee;

import java.util.ArrayList;

public class AddCommissioned implements TypeOperation{
    @Override
    public Employee returnNewEmployee(ArrayList<Employee> employees, int index) {
        return new Commissioned("c");
    }
}

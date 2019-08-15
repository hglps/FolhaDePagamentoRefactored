package typemenufactory;

import companypackage.Employee;

import java.util.ArrayList;

public class InvalidType implements TypeOperation {
    @Override
    public Employee returnNewEmployee(ArrayList<Employee> employees, int index) {
        System.out.println("Invalid type of employee!");
        return null;
    }
}

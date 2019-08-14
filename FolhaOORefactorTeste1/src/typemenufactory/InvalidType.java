package typemenufactory;

import companypackage.Employee;

public class InvalidType implements TypeOperation {
    @Override
    public Employee returnNewEmployee() {
        System.out.println("Invalid type of employee!");
        return null;
    }
}

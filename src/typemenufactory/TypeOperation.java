package typemenufactory;

import companypackage.Employee;

import java.util.ArrayList;

public interface TypeOperation {
    Employee returnNewEmployee(ArrayList<Employee> employees, int index);
}

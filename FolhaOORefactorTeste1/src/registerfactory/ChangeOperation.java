package registerfactory;

import companypackage.Employee;

import java.util.ArrayList;

public interface ChangeOperation {
    void execute(ArrayList<Employee> employees, int index);
}

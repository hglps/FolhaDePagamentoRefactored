package registerfactory;

import companypackage.Employee;
import states.States;

import java.util.ArrayList;

public interface ChangeOperation {
    void execute(ArrayList<Employee> employees, int index, States states);
}

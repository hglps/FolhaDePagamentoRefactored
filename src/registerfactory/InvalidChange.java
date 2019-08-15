package registerfactory;

import companypackage.Employee;
import states.States;

import java.util.ArrayList;

public class InvalidChange implements ChangeOperation {
    @Override
    public void execute(ArrayList<Employee> employees, int index, States states) {
        System.out.println("Not a valid change option! Try again!");
    }
}

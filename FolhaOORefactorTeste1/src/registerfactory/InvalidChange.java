package registerfactory;

import companypackage.Employee;

import java.util.ArrayList;

public class InvalidChange implements ChangeOperation {
    @Override
    public void execute(ArrayList<Employee> employees, int index) {
        System.out.println("Not a valid change option! Try again!");
    }
}

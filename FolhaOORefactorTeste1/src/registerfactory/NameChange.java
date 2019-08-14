package registerfactory;

import companypackage.Employee;
import exceptions.ExceptionHandling;

import java.util.ArrayList;

public class NameChange implements ChangeOperation {
    private ExceptionHandling exception = new ExceptionHandling();
    @Override
    public void execute(ArrayList<Employee> employees, int index) {
        changeName(employees, index);
    }

    private void changeName(ArrayList<Employee> employees, int index) {
        exception.read.nextLine();
        System.out.println("\nInsert new name (text entry):");
        String name = exception.read.nextLine();
        employees.get(index).setName(name);
        System.out.println("Name changed successfully to :" + employees.get(index).getName());
        //saveState();
    }
}

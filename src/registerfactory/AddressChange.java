package registerfactory;

import companypackage.Employee;
import exceptions.ExceptionHandling;
import states.States;

import java.util.ArrayList;

public class AddressChange implements ChangeOperation{
    private ExceptionHandling exception = new ExceptionHandling();
    @Override
    public void execute(ArrayList<Employee> employees, int index, States states) {
        changeAddress(employees, index, states);
    }

    private void changeAddress(ArrayList<Employee> employees, int index,States states) {
        exception.read.nextLine();
        System.out.println("\nInsert new address (text entry):");
        String address = exception.read.nextLine();
        employees.get(index).setAddress(address);
        System.out.println("Address changed successfully to : " + employees.get(index).getAddress());

        states.saveState(employees);

    }
}

package registerfactory;

import companypackage.Employee;
import exceptions.ExceptionHandling;

import java.util.ArrayList;

public class AddressChange implements ChangeOperation{
    private ExceptionHandling exception = new ExceptionHandling();
    @Override
    public void execute(ArrayList<Employee> employees, int index) {
        changeAddress(employees, index);
    }

    private void changeAddress(ArrayList<Employee> employees, int index) {
        exception.read.nextLine();
        System.out.println("\nInsert new address (text entry):");
        String address = exception.read.nextLine();
        employees.get(index).setAddress(address);
        System.out.println("Address changed successfully to : " + employees.get(index).getAddress());

        //saveState();

    }
}

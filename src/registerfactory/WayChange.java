package registerfactory;

import companypackage.Employee;
import exceptions.ExceptionHandling;
import states.States;

import java.util.ArrayList;

public class WayChange implements ChangeOperation {
    private ExceptionHandling exception = new ExceptionHandling();

    @Override
    public void execute(ArrayList<Employee> employees, int index, States states) {
        changeWayPayment(employees, index,states);
    }

    private void changeWayPayment(ArrayList<Employee> employees, int index,States states) {
        exception.read.nextLine();
        System.out.println("\nInsert new method of payment:\n" +
                "Entry format:\n'check via mail' - check via mail  /  'check in hands' - check via hands  /  'deposit' - pay via deposit");
        String wayPayment = exception.returnValidWayPayment();
        employees.get(index).setWayPayment(wayPayment.toLowerCase());
        System.out.println("Way of payment changed successfully to : " + employees.get(index).getWayPayment());

        states.saveState(employees);
    }
}

package registerfactory;

import companypackage.Employee;
import exceptions.ExceptionHandling;
import states.States;
import typemenufactory.TypeEmployeeFactory;

import java.util.ArrayList;

public class TypeChange implements ChangeOperation{
    private ExceptionHandling exceptionHandling = new ExceptionHandling();
    @Override
    public void execute(ArrayList<Employee> employees, int index, States states) {
        changeType(employees, index,states);
    }

    private void changeType(ArrayList<Employee> employees, int index, States states) {
        System.out.println("\nInsert new type of payment:\n" +
                "h - hourly / s - salaried / c - commissioned");
        String newType = exceptionHandling.returnValidTypePayment().toUpperCase();
        String currType = employees.get(index).getTypePayment();
        if(!currType.equalsIgnoreCase(newType)){
            TypeEmployeeFactory typeFactory = new TypeEmployeeFactory();
            Employee newEmployee = typeFactory.getEmployee(newType).returnNewEmployee(employees, index); //TODO solve isso ae
            saveChangeStatus(employees,index, newEmployee,states);
        }
        else
            System.out.println("Same type of current type of payment! Change not done!");





    }

    private void saveChangeStatus(ArrayList<Employee> employees, int index, Employee newEmployee, States states) {
        Employee currEmployee = employees.get(index);
        String savedId = currEmployee.getId();
        newEmployee.setId(savedId);
        employees.set(index, newEmployee);
        states.saveState(employees);
    }

}

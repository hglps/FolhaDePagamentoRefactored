package registerfactory;

import companypackage.Commissioned;
import companypackage.Employee;
import companypackage.Hourly;
import companypackage.Salaried;
import exceptions.ExceptionHandling;
import strategy.UnionContract;
import typemenufactory.TypeEmployeeFactory;

import java.util.ArrayList;

public class TypeChange implements ChangeOperation{
    private ExceptionHandling exceptionHandling = new ExceptionHandling();
    @Override
    public void execute(ArrayList<Employee> employees, int index) {
        changeType(employees, index);
    }

    private void changeType(ArrayList<Employee> employees, int index) {
        System.out.println("\nInsert new type of payment:\n" +
                "h - hourly / s - salaried / c - commissioned");
        String newType = exceptionHandling.returnValidTypePayment();
        Employee currEmployee = employees.get(index);
        TypeEmployeeFactory typeFactory = new TypeEmployeeFactory();
        Employee newEmployee = typeFactory.getEmployee(newType).returnNewEmployee(); //TODO solve isso ae
        saveChangeStatus(employees,index, newEmployee);



    }

    private void saveChangeStatus(ArrayList<Employee> employees, int index, Employee newEmployee) {
        Employee currEmployee = employees.get(index);
        UnionContract savedUnion = currEmployee.getUnion();
        String savedId = currEmployee.getId();
        int savedDaysWorked = currEmployee.getDaysWorked();
        int savedWeeksWorked = currEmployee.getWeeksWorked();

        newEmployee.setUnion(savedUnion);
        newEmployee.setId(savedId);
        newEmployee.setDaysWorked(savedDaysWorked);
        newEmployee.setWeeksWorked(savedWeeksWorked);

    }

    private Employee returnEmployee(String newType) {
        switch (newType){
            case "h":
                return new Hourly(1);
            case "c":
                return new Commissioned(1);
            case "s":
                return new Salaried(1);
        }
        return null;
    }
}

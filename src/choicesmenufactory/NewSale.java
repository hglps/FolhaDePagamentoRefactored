package choicesmenufactory;

import calendar.MyCalendar;
import companypackage.Commissioned;
import companypackage.Employee;
import exceptions.ExceptionHandling;
import interpreter.NewSaleSpec;
import interpreter.Specification;
import states.States;

import java.util.ArrayList;
import java.util.Scanner;

public class NewSale implements ChoiceOperation{
    private Scanner read = new Scanner(System.in);
    private ExceptionHandling exception = new ExceptionHandling();
    @Override
    public void execute(ArrayList<Employee> employees, MyCalendar date, States states) {
        checkNewSale(employees, states);
    }

    private void checkNewSale(ArrayList<Employee> employees, States states){
        while(true){
            System.out.println("Insert ID: (insert 'quit' to go back to main menu)");
            String id = read.nextLine();
            int index = getIndex(id, employees);
            if(id.equalsIgnoreCase("quit")) {
                System.out.println("Back to main screen!");
                break;
            }
            else if(index == -1)
                System.out.println("Employee with ID : " + id + " not found! Press enter to insert again!");
            else{
                Employee currEmployee = employees.get(index);
                Specification condition = new NewSaleSpec();
                if(condition.isSatisfiedBy(currEmployee)){
                    newSale(employees, index, states);
                }
                else
                    System.out.println("NOT a commissioned employee! ");
            }

        }
    }

    private void newSale(ArrayList<Employee> employees, int index, States states) {
        Employee currEmployee = employees.get(index);
        System.out.print("Insert value of sale: (Number format : 9999,99)\nR$ ");
        double value = exception.returnValidDouble();

        double commissionRate = ((Commissioned) currEmployee).getCommissionRate();
        ((Commissioned) currEmployee).addCommission(value * commissionRate);
        System.out.println("Sale registered successfully to employee " + currEmployee.getName());

        states.saveState(employees);
    }

    private int getIndex(String id, ArrayList<Employee> employees){
        for(int i=0; i < employees.size() ; i++){
            if (employees.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}

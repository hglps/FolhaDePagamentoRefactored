package choicesmenufactory;

import calendar.MyCalendar;
import companypackage.Employee;
import exceptions.ExceptionHandling;
import interpreter.NewServiceFeeSpec;
import interpreter.Specification;
import states.States;
import strategy.UnionMember;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiceFee implements ChoiceOperation {
    private Scanner read = new Scanner(System.in);
    private ExceptionHandling exception = new ExceptionHandling();

    @Override
    public void execute(ArrayList<Employee> employees, MyCalendar date, States states) {
        checkIfUnionMember(employees, states);
    }

    private void checkIfUnionMember(ArrayList<Employee> employees, States states) {
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
                if(currEmployee.getUnion().checkUnion()){
                    newServiceFee(employees, index, states);
                }
                else
                    System.out.println("NOT a union member!");
            }

        }
    }

    private void newServiceFee(ArrayList<Employee> employees, int index, States states) {
        double serviceFee;
        Employee currEmployee = employees.get(index);
        System.out.print("Insert service fee: (Number format: 9999,99)\nR$");
        serviceFee = exception.returnValidDouble();
        read.nextLine();

        ((UnionMember) currEmployee.getUnion()).addServiceFee(serviceFee);
        System.out.println("R$ " + serviceFee + " of service fee successfully registered on " + employees.get(index).getName() + "'s union account!");

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

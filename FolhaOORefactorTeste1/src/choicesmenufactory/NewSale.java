package choicesmenufactory;

import calendar.MyCalendar;
import companypackage.Commissioned;
import companypackage.Employee;
import exceptions.ExceptionHandling;
import interpreter.NewSaleSpec;
import interpreter.Specification;

import java.util.ArrayList;
import java.util.Scanner;

public class NewSale implements ChoiceOperation{
    private Scanner read = new Scanner(System.in);
    private ExceptionHandling exception = new ExceptionHandling();
    @Override
    public void execute(ArrayList<Employee> arrayList, MyCalendar date) {
        checkNewSale(arrayList);
    }

    private void checkNewSale(ArrayList<Employee> employees){
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
                    newSale(employees, index);
                }
                else
                    System.out.println("NOT a commissioned employee! ");
            }

        }
    }

    private void newSale(ArrayList<Employee> employees, int index) {
        Employee currEmployee = employees.get(index);
        System.out.print("Insert value of sale: (Number format : 9999,99)\nR$ ");
        double value = exception.returnValidDouble();

        double commissionRate = ((Commissioned) currEmployee).getCommissionRate();
        ((Commissioned) currEmployee).addCommission(value * commissionRate);
        System.out.println("Sale registered successfully to employee " + currEmployee.getName());

        //saveState();
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

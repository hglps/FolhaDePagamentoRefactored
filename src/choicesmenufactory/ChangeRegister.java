package choicesmenufactory;

import calendar.MyCalendar;
import companypackage.Employee;
import exceptions.ExceptionHandling;
import registerfactory.ChangeRegisterFactory;
import states.States;

import java.util.ArrayList;
import java.util.Scanner;

public class ChangeRegister implements ChoiceOperation {
    private Scanner read = new Scanner(System.in);
    private ExceptionHandling exception = new ExceptionHandling();
    @Override
    public void execute(ArrayList<Employee> employees, MyCalendar date, States states) {
        changeRegister(employees, states);
    }

    private void changeRegister(ArrayList<Employee> employees, States states) {
        System.out.println("Enter ID:");
        String id = read.nextLine();
        int index = getIndex(employees,id);

        if(index != -1){
            ChangeRegisterFactory registerFactory = new ChangeRegisterFactory();
            int option;
            while(true){
                screenChangeRegister();
                option = exception.returnValidChangeRegisterChoice();
                if(option == 0)
                    break;
                registerFactory.getOperation(option).execute(employees, index, states);

            }
        }
        else
            System.out.println("Employee with ID : "+ id +" not found!");
    }

    private void screenChangeRegister () {
        System.out.println("Select the required change:\n" +
                "1 - Name\n" +
                "2 - Address\n" +
                "3 - Type of payment\n" +
                "4 - Method of payment\n" +
                "5 - Part of union\n" +
                "6 - Union fee\n" +
                "0 - Back to main screen");
    }
    private int getIndex(ArrayList<Employee> employees, String id){
        for(int i=0; i < employees.size() ; i++){
            if (employees.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }



}

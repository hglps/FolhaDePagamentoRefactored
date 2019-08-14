package main;

import calendar.MyCalendar;
import choicesmenufactory.ChoiceFactory;
import companypackage.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class HeadMaster {

    public Scanner read = new Scanner(System.in);
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private String password = "admin";
    private MyCalendar date = new MyCalendar();

    public void startSystem(){
        System.out.println("Started system!");
        date.setLastWorkDay();
        enterSystem();
    }

    private void screenEnterPassword(){
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||Insert password to access payroll system or insert 'quit' to quit the system:||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.print("Password: ");
    }
    private void enterSystem() {
            String reading;

            while(true){
                screenEnterPassword();
                reading = read.nextLine();
                if(reading.equals(password)){
                    payrollSystem();
                }
                else if(reading.equalsIgnoreCase("quit")){
                    screenSystemFinished();
                    break;
                }
                else if(!reading.equalsIgnoreCase("quit"))
                    System.out.println("Invalid input! Try again!");
            }
    }

    private void payrollSystem(){
//        startUndoRedo();
        visualizeOptions();
        ChoiceFactory choiceFactory = new ChoiceFactory();
        while(true){
            String choice;
            choice =read.nextLine();
            if(choice.equalsIgnoreCase("quit")){
                System.out.println("\n\nPayroll system finished!\n");
                break;
            }
            else {
                choiceFactory.getOperation(choice).execute(employees, date);
                System.out.println("terminou de sair do execute() da main do choice!!!\n");
            }

            visualizeOptions();
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    private void visualizeOptions() {
        //date.getDate();
        System.out.println("\n------------------------------------------------------------\n" +
                "Insert 'add' to ADD a new employee;");
        System.out.println("Insert 'delete' to REMOVE an employee;");
        System.out.println("Insert 'card' to UPDATE POINT CARD of an employee;");
        System.out.println("Insert 'new sale' to UPDATE THE RESULT OF SALES of an employee;");
        System.out.println("Insert 'service fee' to UPDATE SERVICE FEE of an employee;");
        System.out.println("Insert 'change register' to CHANGE REGISTER of an employee;");
        System.out.println("Insert 'undo' to UNDO!");
        System.out.println("Insert 'redo' to REDO!");
        System.out.println("Insert 'payroll' to RUN TODAY'S PAYROLL;");
        System.out.println("Insert 'set payday' to SET PAYMENT SCHEDULE of an employee;");
        System.out.println("Insert 'create schedule' to CREATE NEW PAYMENT SCHEDULES;");
        System.out.println("Insert 'info' to LIST EMPLOYEE(S) INFO;");
        System.out.println("Insert 'new password' to change password of system;");
        System.out.println("Insert 'quit' to end;");
        System.out.print("Option:  ");

    }
    private void screenSystemFinished(){
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||System completely finished!|||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    }

}

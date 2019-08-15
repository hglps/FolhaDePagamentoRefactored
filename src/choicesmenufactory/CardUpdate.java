package choicesmenufactory;

import calendar.MyCalendar;
import companypackage.Employee;
import companypackage.Hourly;
import exceptions.ExceptionHandling;
import states.States;

import java.util.ArrayList;
import java.util.Scanner;

public class CardUpdate implements ChoiceOperation{
    private Scanner read = new Scanner(System.in);
    private ExceptionHandling exception = new ExceptionHandling();
    @Override
    public void execute(ArrayList<Employee> arrayList, MyCalendar date, States states) {
        cardUpdate(arrayList, states);
    }

    private void cardUpdate(ArrayList<Employee> arrayList, States states) {
        String id;
        int index;
        while(true){
            System.out.println("Insert ID: (insert 'quit' to go back to main menu)");
            id = read.nextLine();
            index = getIndex(id, arrayList);
            if(id.equalsIgnoreCase("quit")) {
                System.out.println("Back to main screen!");
                break;
            }
            else if(index == -1)
                System.out.println("Employee with ID : " + id + " not found! Press enter to insert again!");
            else
                update(arrayList, id, index, states);
        }

    }

    private void update(ArrayList<Employee> employees, String id, int index, States states) {
        Employee currEmployee = employees.get(index);
        int choice = 0;
        boolean error = true;
        System.out.println("Do you want to check-in or check-out?" +
                "\nInsert 1 to check-in" +
                "\nInsert 2 to check-out");
        choice = exception.returnValidShowInfo();

        if(choice == 1){
            int hourIn, minuteIn;

            System.out.println("Insert hour of entrance: (Number format : 0 to 23)");
            hourIn = exception.returnValidHour();
            System.out.println("Insert minute of entrance: (Number format: 0 to 59");
            minuteIn = exception.returnValidMinute();

            currEmployee.setHourIn(hourIn);
            currEmployee.setMinuteIn(minuteIn);
            System.out.println(currEmployee.getHourIn() +":"+ currEmployee.getMinuteIn() +" entry registered successfully to employee "+ currEmployee.getName());

            states.saveState(employees);
        }
        else if(choice == 2){
            int hourOut, minuteOut;
            System.out.println("Insert hour of exit: (Number format : 0 to 23)");
            hourOut = exception.returnValidHour();
            System.out.println("Insert minute of exit: (Number format: 0 to 59");
            minuteOut = exception.returnValidMinute();

            currEmployee.setHourOut(hourOut);
            currEmployee.addHours( currEmployee.setMinuteOut(minuteOut) );
            currEmployee.addDayWorked();

            if(currEmployee instanceof Hourly)
                ((Hourly)currEmployee).calculateHours();
            else
                currEmployee.calculateHours();

            System.out.println("hours = "+currEmployee.getHours());
            System.out.println(currEmployee.getHourOut() +":"+ currEmployee.getMinuteOut() +" exit registered successfully to employee "+ currEmployee.getName());

            currEmployee.setHourIn(0); currEmployee.setHourOut(0); currEmployee.setMinuteIn(0); currEmployee.setMinuteOut(0);

            states.saveState(employees);
        }
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

package choicesmenufactory;

import calendar.MyCalendar;
import companypackage.Employee;
import states.States;

import java.util.ArrayList;

public class ShowInfo implements ChoiceOperation {
    @Override
    public void execute(ArrayList<Employee> employees, MyCalendar index, States states) {
        showInfo(employees);
    }

    private void showInfo(ArrayList<Employee> employees){
        System.out.println("SHOWING ALL EMPLOYEES INFO:");
        for(int i=0; i< employees.size(); i++){
            System.out.println("----------------------------------------------");
            System.out.println(employees.get(i));
            System.out.println("----------------------------------------------");
        }
    }
}

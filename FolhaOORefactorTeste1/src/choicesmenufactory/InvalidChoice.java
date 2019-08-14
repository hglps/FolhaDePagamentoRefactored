package choicesmenufactory;

import calendar.MyCalendar;
import choicesmenufactory.ChoiceOperation;
import companypackage.Employee;

import java.util.ArrayList;

public class InvalidChoice implements ChoiceOperation {
    @Override
    public void execute(ArrayList<Employee> arrayList, MyCalendar date) {
        System.out.println("Invalid Choice! Insert a valid choice!");
    }

}

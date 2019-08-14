package choicesmenufactory;

import calendar.MyCalendar;
import companypackage.Employee;

import java.util.ArrayList;

public class Undo implements ChoiceOperation {
    @Override
    public void execute(ArrayList<Employee> employees, MyCalendar date) {
        undo(employees, date);
    }

    private void undo(ArrayList<Employee> employees, MyCalendar date) {

    }

}

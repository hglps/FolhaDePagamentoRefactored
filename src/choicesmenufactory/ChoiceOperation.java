package choicesmenufactory;

import calendar.MyCalendar;
import companypackage.Employee;
import states.States;

import java.util.ArrayList;

public interface ChoiceOperation {
    void execute(ArrayList<Employee> arrayList, MyCalendar date, States state);
}

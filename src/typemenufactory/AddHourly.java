package typemenufactory;

import companypackage.Employee;
import companypackage.Hourly;

import java.util.ArrayList;

public class AddHourly implements TypeOperation {
    @Override
    public Hourly returnNewEmployee(ArrayList<Employee> employees, int index) {
        return new Hourly("h");
    }
}

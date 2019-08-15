package typemenufactory;

import companypackage.Employee;
import companypackage.Salaried;

import java.util.ArrayList;

public class AddSalaried implements TypeOperation {
    @Override
    public Salaried returnNewEmployee(ArrayList<Employee> employees, int index) {
        return new Salaried("s");
    }
}

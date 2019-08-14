package typemenufactory;

import companypackage.Commissioned;
import companypackage.Employee;

public class AddCommissioned implements TypeOperation{
    @Override
    public Employee returnNewEmployee() {
        return new Commissioned();
    }
}

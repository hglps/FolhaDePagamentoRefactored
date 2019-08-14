package interpreter;

import companypackage.Commissioned;
import companypackage.Employee;

public class NewSaleSpec implements Specification {
    @Override
    public boolean isSatisfiedBy(Employee employee) {
        return (employee instanceof Commissioned);
    }
}

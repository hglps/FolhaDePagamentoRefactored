package interpreter;

import companypackage.Employee;

public interface Specification {
    boolean isSatisfiedBy(Employee employee);
}

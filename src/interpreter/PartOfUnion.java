package interpreter;

import companypackage.Employee;
import strategy.UnionMember;

public class PartOfUnion implements Specification {
    @Override
    public boolean isSatisfiedBy(Employee employee) {
        return (employee.getUnion() instanceof UnionMember);
    }
}

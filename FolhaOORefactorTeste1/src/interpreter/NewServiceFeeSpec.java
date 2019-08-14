package interpreter;

import companypackage.Employee;
import strategy.UnionMember;

public class NewServiceFeeSpec implements Specification {
    @Override
    public boolean isSatisfiedBy(Employee employee) {
        return (employee.getUnion() instanceof UnionMember);
    }
}

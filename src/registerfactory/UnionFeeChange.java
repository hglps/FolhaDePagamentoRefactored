package registerfactory;

import companypackage.Employee;
import exceptions.ExceptionHandling;
import interpreter.PartOfUnion;
import interpreter.Specification;
import states.States;
import strategy.UnionMember;

import java.util.ArrayList;

public class UnionFeeChange implements ChangeOperation {
    private ExceptionHandling exceptionHandling = new ExceptionHandling();
    @Override
    public void execute(ArrayList<Employee> employees, int index, States states) {
        unionCheck(employees, index,states);

    }

    private void unionCheck(ArrayList<Employee> employees, int index, States states) {
        Employee currEmployee = employees.get(index);
        Specification condition = new PartOfUnion();
        if(condition.isSatisfiedBy(currEmployee)){
            changeUnionFee(employees, index,states);
        }
        else
            System.out.println("Not part of union! Changes not made!");
    }

    private void changeUnionFee(ArrayList<Employee> employees, int index, States states) {
        Employee currEmployee = employees.get(index);
        double unionFee = exceptionHandling.returnValidDouble();
        ((UnionMember)currEmployee.getUnion()).setUnionFee(unionFee);
        System.out.println("Union fee changed successfully to : " + ((UnionMember)currEmployee.getUnion()).getUnionFee());
        states.saveState(employees);
    }
}

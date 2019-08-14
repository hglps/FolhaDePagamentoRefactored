package registerfactory;

import companypackage.Employee;
import exceptions.ExceptionHandling;
import interpreter.PartOfUnion;
import interpreter.Specification;
import strategy.UnionMember;

import java.util.ArrayList;

public class UnionFeeChange implements ChangeOperation {
    private ExceptionHandling exceptionHandling = new ExceptionHandling();
    @Override
    public void execute(ArrayList<Employee> employees, int index) {
        unionCheck(employees, index);

    }

    private void unionCheck(ArrayList<Employee> employees, int index) {
        Employee currEmployee = employees.get(index);
        Specification condition = new PartOfUnion();
        if(condition.isSatisfiedBy(currEmployee)){
            changeUnionFee(employees, index);
        }
        else
            System.out.println("Not part of union! Changes not made!");
    }

    private void changeUnionFee(ArrayList<Employee> employees, int index) {
        Employee currEmployee = employees.get(index);
        double unionFee = exceptionHandling.returnValidDouble();
        ((UnionMember)currEmployee.getUnion()).setUnionFee(unionFee);
        System.out.println("Union fee changed successfully to : " + ((UnionMember)currEmployee.getUnion()).getUnionFee());
//        saveState();
    }
}

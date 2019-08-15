package registerfactory;

import companypackage.Employee;
import exceptions.ExceptionHandling;
import states.States;
import strategy.NotUnionMember;
import strategy.UnionMember;

import java.util.ArrayList;

public class UnionChange implements ChangeOperation{
    private ExceptionHandling exception = new ExceptionHandling();
    @Override
    public void execute(ArrayList<Employee> employees, int index, States states) {
        unionCheck(employees, index,states);
    }

    private void unionCheck(ArrayList<Employee> employees, int index,States states) {
        exception.read.nextLine();
        System.out.println("\nAre you part of any union?\n" +
                "Entry format: 'yes'  or  'no'");
        boolean partUnion = exception.returnValidPartOfUnion();
        Employee currEmployee = employees.get(index);

        if(currEmployee.getUnion().checkUnion() != partUnion){
            unionChange(employees, index, partUnion, states);

        }
        else
            System.out.println("Same status of current union status! Changes not made!");


    }

    private void unionChange(ArrayList<Employee> employees, int index, boolean partUnion, States states) {
        Employee currEmployee = employees.get(index);
        if(partUnion){
            System.out.print("\nInsert new union fee:\nNumber format: 9999,99\nUnion fee: ");
            double unionFee = exception.returnValidDouble();
            currEmployee.setUnion(new UnionMember(unionFee, false, currEmployee.getName()));
            System.out.println(employees.get(index).getName() + "is a union member now!");
                states.saveState(employees);
        }
        else{
            currEmployee.setUnion(new NotUnionMember());
            System.out.println(employees.get(index).getName() + "is not a union member anymore!");
                states.saveState(employees);
        }
    }
}

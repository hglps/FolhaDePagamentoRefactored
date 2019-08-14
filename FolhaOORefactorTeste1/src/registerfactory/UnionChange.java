package registerfactory;

import companypackage.Employee;
import exceptions.ExceptionHandling;
import strategy.NotUnionMember;
import strategy.UnionMember;

import java.util.ArrayList;

public class UnionChange implements ChangeOperation{
    private ExceptionHandling exception = new ExceptionHandling();
    @Override
    public void execute(ArrayList<Employee> employees, int index) {
        unionCheck(employees, index);
    }

    private void unionCheck(ArrayList<Employee> employees, int index) {
        exception.read.nextLine();
        System.out.println("\nAre you part of any union?\n" +
                "Entry format: 'yes'  or  'no'");
        boolean partUnion = exception.returnValidPartOfUnion();
        Employee currEmployee = employees.get(index);

        if(currEmployee.getUnion().checkUnion() != partUnion){
            unionChange(employees, index, partUnion);

        }
        else
            System.out.println("Same status of current union status! Changes not made!");


    }

    private void unionChange(ArrayList<Employee> employees, int index, boolean partUnion) {
        Employee currEmployee = employees.get(index);
        if(partUnion){
            System.out.print("\nInsert new union fee:\nNumber format: 9999,99\nUnion fee: ");
            double unionFee = exception.returnValidDouble();
            currEmployee.setUnion(new UnionMember(unionFee, false));
            System.out.println(employees.get(index).getName() + "is a union member now!");
//                saveState();
        }
        else{
            currEmployee.setUnion(new NotUnionMember());
            System.out.println(employees.get(index).getName() + "is not a union member anymore!");
//                saveState();
        }
    }
}

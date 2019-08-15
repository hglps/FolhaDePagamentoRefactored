package states;

import companypackage.Commissioned;
import companypackage.Employee;
import companypackage.Hourly;
import companypackage.Salaried;

import java.util.ArrayList;
import java.util.Stack;

public class Redo {

    private Stack<ArrayList<Employee>> redoStack = new Stack<ArrayList<Employee>>();

    public ArrayList<Employee> redo(ArrayList<Employee> employees, Undo undo){
        ArrayList<Employee> newEmployees = new ArrayList<Employee>();
        newEmployees = copyEmployee(redoStack.peek());
        undo.getUndoStack().push(newEmployees);

        ArrayList<Employee> redoFinal = new ArrayList<Employee>();
        redoFinal = copyEmployee(redoStack.pop());
        employees = redoFinal;

        System.out.println("REDO made successfully!\n");
        return employees;
    }

    public boolean cantRedo(){
        return redoStack.isEmpty();
    }


    public Stack<ArrayList<Employee>> getRedoStack() {
        return redoStack;
    }
    private ArrayList<Employee> copyEmployee(ArrayList<Employee> employees){

        ArrayList<Employee>  newEmployees = new ArrayList<Employee>();

        for(int i=0; i< employees.size(); i++){
            Employee copy = employees.get(i);
            if(copy instanceof Hourly){
                newEmployees.add(i, new Hourly(copy.getName(), copy.getAddress(), copy.getTypePayment(), copy.getWayPayment(), copy.getUnion(), ((Hourly)copy).getHourlyRate(), ((Hourly)copy).getExtraHours()));
            }
            else if(copy instanceof Commissioned){
                newEmployees.add(i, new Commissioned(copy.getName(), copy.getAddress(), copy.getTypePayment(), copy.getWayPayment(), copy.getUnion(), ((Commissioned)copy).getBaseSalary(), ((Commissioned)copy).getCommission(), ((Commissioned)copy).getCommissionRate()));
            }
            else if(copy instanceof Salaried){
                newEmployees.add(i, new Salaried(copy.getName(), copy.getAddress(), copy.getTypePayment(), copy.getWayPayment(), copy.getUnion(), ((Salaried)copy).getBaseSalary()));
            }

            newEmployees.get(i).setHours(copy.getHours());
            newEmployees.get(i).setId(copy.getId());
            newEmployees.get(i).setPayday(copy.getPayday());
            newEmployees.get(i).setDaysWorked(copy.getDaysWorked());
            newEmployees.get(i).setSalary(copy.getSalary());
            newEmployees.get(i).setWeeksWorked(copy.getWeeksWorked());
            newEmployees.get(i).setHourIn(copy.getHourIn());
            newEmployees.get(i).setMinuteIn(copy.getMinuteIn());

        }
        return newEmployees;

    }

}

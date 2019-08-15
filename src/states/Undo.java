package states;

import companypackage.Commissioned;
import companypackage.Employee;
import companypackage.Hourly;
import companypackage.Salaried;

import java.util.ArrayList;
import java.util.Stack;

public class Undo {
    Stack<ArrayList<Employee>> undoStack = new Stack<ArrayList<Employee>>();


    public ArrayList<Employee> undo(ArrayList<Employee> employees, Redo redo){
        if(undoStack.peek().equals(undoStack.get(0))){
            ArrayList<Employee> newEmployees = new ArrayList<Employee>();
            employees = newEmployees;
            return newEmployees;
        }
        else{
            redo.getRedoStack().push(undoStack.pop());
            ArrayList<Employee> newEmployees = new ArrayList<Employee>();
            newEmployees = copyEmployee(undoStack.peek());
            employees = newEmployees;

            System.out.println("UNDO made successfully!\n");
            return newEmployees;

        }
    }

    public void startStates(){
        ArrayList<Employee> startArrayList = new ArrayList<Employee>();
        undoStack.push(startArrayList);
    }

    public void saveState(ArrayList<Employee> employees){
        ArrayList<Employee> newEmployees = new ArrayList<Employee>();
        newEmployees = copyEmployee(employees);
        undoStack.push(newEmployees);
    }

    private ArrayList<Employee> copyEmployee(ArrayList<Employee> employees){

        ArrayList<Employee>  newEmployees = new ArrayList<Employee>();

        for(int i=0; i< employees.size(); i++){
            Employee copy = employees.get(i);
            if(copy instanceof Hourly){
                newEmployees.add(i, new Hourly(copy.getName(), copy.getAddress(), "h", copy.getWayPayment(), copy.getUnion(), ((Hourly)copy).getHourlyRate(), ((Hourly)copy).getExtraHours()));
            }
            else if(copy instanceof Commissioned){
                newEmployees.add(i, new Commissioned(copy.getName(), copy.getAddress(), "c", copy.getWayPayment(), copy.getUnion(), ((Commissioned)copy).getBaseSalary(), ((Commissioned)copy).getCommission(), ((Commissioned)copy).getCommissionRate()));
            }
            else if(copy instanceof Salaried){
                newEmployees.add(i, new Salaried(copy.getName(), copy.getAddress(), "s", copy.getWayPayment(), copy.getUnion(), ((Salaried)copy).getBaseSalary()));
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

    public Stack<ArrayList<Employee>> getUndoStack() {
        return undoStack;
    }



}

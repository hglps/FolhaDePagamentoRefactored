package states;

import companypackage.Employee;

import java.util.ArrayList;

public class States {
    private Undo undoState = new Undo();
    private Redo redoState = new Redo();


    public ArrayList<Employee> undo(ArrayList<Employee> employees){
        return undoState.undo(employees, redoState);
    }

    public ArrayList<Employee> redo(ArrayList<Employee> employees){
        if(redoState.cantRedo()){
            System.out.println("CANNOT REDO! Empty redo stack!\n");
            return employees;
        }
        else
            return redoState.redo(employees, undoState);
    }

    public void saveState(ArrayList<Employee> employees){
        undoState.saveState(employees);
    }

    public void startStates(ArrayList<Employee> employees){
        undoState.startStates();
    }

}

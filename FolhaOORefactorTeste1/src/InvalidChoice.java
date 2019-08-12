import java.util.ArrayList;

public class InvalidChoice implements ChoiceOperation {
    @Override
    public void execute(ArrayList<Employee> arrayList) {
        System.out.println("Invalid Choice! Insert a valid choice!");
    }

}

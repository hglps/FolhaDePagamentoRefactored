package choicesmenu;

public class FailedOperation implements Operation  {
    @Override
    public void execute() {
        System.out.println("Invalid option!\nPlease, insert a valid option:\n");
    }
}

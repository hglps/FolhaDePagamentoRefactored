package choicesmenu;

import java.util.HashMap;

public class ChoiceFactory {

    private HashMap<String, Operation> operationHashMap = new HashMap<>();

    {
        operationHashMap.put("add", new AddEmployee());
        operationHashMap.put("delete", new DeleteEmployee());
        operationHashMap.put("card", new SetTimeCheck());
        operationHashMap.put("new sale", new ResultSales());
        operationHashMap.put("service fee", new ServiceFee());
        operationHashMap.put("change register", new ChangeRegister());
        operationHashMap.put("undo", new Undo());
        operationHashMap.put("redo", new Redo());
        operationHashMap.put("payroll", new Payroll());
        operationHashMap.put("set payday", new SetNewPayday());
        operationHashMap.put("create schedule", new CreateSchedules());
        operationHashMap.put("info", new ShowInfo());
        operationHashMap.put("new password", new ChangeSystemPassword());
    }

    public Operation getOperation(String operator){
        return operationHashMap.getOrDefault(operator, new FailedOperation());
    }
}

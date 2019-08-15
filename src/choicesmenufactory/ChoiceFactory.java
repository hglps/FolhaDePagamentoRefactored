package choicesmenufactory;

import java.util.HashMap;

public class ChoiceFactory {
    private HashMap<String, ChoiceOperation> choiceMap = new HashMap<>();
    private void buildMap(){
        choiceMap.put("add", new NewEmployee());
        choiceMap.put("delete", new DeleteEmployee());
        choiceMap.put("card", new CardUpdate());
        choiceMap.put("new sale", new NewSale());
        choiceMap.put("service fee", new ServiceFee());
        choiceMap.put("change register", new ChangeRegister());
        choiceMap.put("payroll", new Payroll());
        choiceMap.put("info", new ShowInfo());
    }

    public ChoiceOperation getOperation(String operator){
        buildMap();
        return choiceMap.getOrDefault(operator, new InvalidChoice());
    }
}

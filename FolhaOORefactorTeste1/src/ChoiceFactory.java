import java.util.HashMap;

public class ChoiceFactory {
    private HashMap<String, ChoiceOperation> choiceMap = new HashMap<>();
    private void buildMap(){
        choiceMap.put("add", new AddEmployee());
        choiceMap.put("show info", new ShowInfo());
        //choiceMap.put("default", new InvalidChoice());
    }

    public ChoiceOperation getOperation(String operator){
        buildMap();
        System.out.println("entrou na getOperation");
        //return choiceMap.getOrDefault(operator, new InvalidChoice()); //lidar com caso de erro
        return choiceMap.get(operator);
    }
}

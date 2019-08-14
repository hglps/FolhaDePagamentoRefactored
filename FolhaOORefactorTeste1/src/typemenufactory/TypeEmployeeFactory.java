package typemenufactory;

import java.util.HashMap;

public class TypeEmployeeFactory {
    private HashMap<String, TypeOperation> typeEmployeeMap = new HashMap<>();

    private void buildMap(){
        typeEmployeeMap.put("h", new AddHourly());
        typeEmployeeMap.put("s", new AddSalaried());
        typeEmployeeMap.put("c", new AddCommissioned());
    }

    public TypeOperation getEmployee(String typeEmployee){
        buildMap();
        System.out.println("entrou no getEmployee do typeFactory");
//        return typeEmployeeMap.getOrDefault(typeEmployee, new choicesmenufactory.InvalidChoice()); // lidar com erros
        return typeEmployeeMap.getOrDefault(typeEmployee, new InvalidType());
//        if(typeEmployeeMap.containsKey(typeEmployee))
//            return typeEmployeeMap.get(typeEmployee);
//        else
//            return typeEmployeeMap.get("default");
    }
}

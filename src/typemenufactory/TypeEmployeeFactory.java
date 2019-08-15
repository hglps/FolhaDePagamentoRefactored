package typemenufactory;

import java.util.HashMap;

public class TypeEmployeeFactory {
    private HashMap<String, TypeOperation> typeEmployeeMap = new HashMap<>();

    private void buildMap(){
        typeEmployeeMap.put("h", new AddHourly());
        typeEmployeeMap.put("s", new AddSalaried());
        typeEmployeeMap.put("c", new AddCommissioned());
        typeEmployeeMap.put("H", new ReturnHourly());
        typeEmployeeMap.put("S", new ReturnSalaried());
        typeEmployeeMap.put("C", new ReturnCommissioned());

    }

    public TypeOperation getEmployee(String typeEmployee){
        buildMap();
        return typeEmployeeMap.getOrDefault(typeEmployee, new InvalidType());
    }
}

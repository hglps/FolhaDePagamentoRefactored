import java.util.HashMap;

public class TypeEmployeeFactory {
    private HashMap<String, TypeOperation> typeEmployeeMap = new HashMap<>();

    private void buildMap(){
        typeEmployeeMap.put("s", new AddSalaried());
        typeEmployeeMap.put("h", new AddHourly());
        //typeEmployeeMap.put("default", new InvalidChoice());
    }

    public TypeOperation getEmployee(String typeEmployee){
        buildMap();
        System.out.println("entrou no getEmployee do typeFactory");
//        return typeEmployeeMap.getOrDefault(typeEmployee, new InvalidChoice()); // lidar com erros
        return typeEmployeeMap.get(typeEmployee);
//        if(typeEmployeeMap.containsKey(typeEmployee))
//            return typeEmployeeMap.get(typeEmployee);
//        else
//            return typeEmployeeMap.get("default");
    }
}

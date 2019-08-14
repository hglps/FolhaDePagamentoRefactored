package registerfactory;

import choicesmenufactory.ChoiceOperation;
import choicesmenufactory.InvalidChoice;

import java.util.HashMap;

public class ChangeRegisterFactory {
    private HashMap<Integer, ChangeOperation> registerMap = new HashMap<Integer, ChangeOperation>();
    private void buildMap(){
        registerMap.put(1, new NameChange());
        registerMap.put(2, new AddressChange());
        registerMap.put(3, new TypeChange());
        registerMap.put(4, new WayChange());
        registerMap.put(5, new UnionChange());
        registerMap.put(6, new UnionFeeChange());
    }

    public ChangeOperation getOperation(int operator){
        buildMap();
        return registerMap.getOrDefault(operator, new InvalidChange());
    }
}

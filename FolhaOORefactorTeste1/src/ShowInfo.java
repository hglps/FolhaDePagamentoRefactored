import java.util.ArrayList;

public class ShowInfo implements ChoiceOperation {
    @Override
    public void execute(ArrayList<Employee> arrayList) {
        showInfo(arrayList);
    }

    private void showInfo(ArrayList<Employee> arrayList){
        System.out.println("SHOWING ALL EMPLOYEES INFO:");
        System.out.println("size of arrayList = "+arrayList.size());
        for(int i=0; i < arrayList.size(); i++){
            System.out.println("tem q mostrar alguem aaaaaaaaaaaaaaaaaaaaa");
//            System.out.println(user);
            //getEmployees().get(i); //**********
            System.out.println(arrayList.get(i));
        }
    }
}

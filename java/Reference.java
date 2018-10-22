import java.util.*;

public class Reference {

    public static void main(String[] args){
        TClass claz = new TClass();
        List<TClass> list = new ArrayList<>();
        list.add(claz);
        claz = new TClass();
        System.out.println(claz);
        System.out.println(list.get(0));
    }
}

class TClass {

}
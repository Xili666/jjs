public class Clone {

    public static void main(String[] args) {
        AClass obja = new AClass("A", 1);
        System.out.println(obja);
        AClass copy = null;
        try {
            copy = obja.getCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(copy);
    }
}

class AClass implements Cloneable {
    private String name;
    private Integer age;
    private BClass objB;

    AClass(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.objB = new BClass();
    }

    AClass getCopy() throws CloneNotSupportedException {
        AClass copy = (AClass) super.clone();
        copy.objB = new BClass();
        return copy;
    }

    public String toString() {
        return "name = " + this.name + ", age = " + this.age + " b = " + this.objB;
    }
}

class BClass {

}
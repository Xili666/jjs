public class StringLearn {
    public static void main(String[] args){
        String a = "a";
        String b = "a";
        String c = "b";
        String d = "ab";
        String e = new String("a");
        String f = new String("ab");
        String h = new String("ab");
        String g = "a" + "b";
        String j = a + "b";
        System.out.println(a == b); // true
        System.out.println(a.equals(b)); // true
        System.out.println(f == h); // false
        System.out.println(f == g); // false
        System.out.println(d == g); // true
        System.out.println(j == g); // false
        System.out.println(a.intern() == e); // false
        System.out.println(e.intern() == a); // true
        System.out.println(j.intern() == g); // true
    }

}
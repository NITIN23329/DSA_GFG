package String;
// String class are immutable
//StringBuilder or StringBuffer class are mutable
public class StringIntro {
    public static void main(String[] args) {
        // string builder;
        StringBuilder str = new StringBuilder("foobar");
        System.out.println(str);
        str.append(123);
        System.out.println(str);
        str.reverse();
        System.out.println(str);
        str.insert(3,"nitin");
        System.out.println(str);
        str.delete(3,8);
        System.out.println(str);
        //string builder
        StringBuffer str2 = new StringBuffer("data structures");
        str2.replace(5,14,"algoritm");
        System.out.println(str2);

    }
}

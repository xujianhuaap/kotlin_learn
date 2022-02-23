package hybrid;

public class JavaFamily {
    public void printTag(){
        System.out.println(KotlinFamily.TAG);
        System.out.println(KotlinFamily.VERSION);
        Garden<? super Plant> li = KotlinFamilyKt.box(new Living("tulip"));

    }

}

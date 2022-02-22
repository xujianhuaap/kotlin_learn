package others;

/***
 * java8 新增的交集类型
 */
public class IntersectionType {

    public static void main(String[] args) {
        Flower f = (Flower & SPlant) (s)-> s+"";
    }
}


interface SPlant {

}

interface Flower {
    public String test(int s);
}


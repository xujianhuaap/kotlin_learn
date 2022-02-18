/***
 * java8 新增的交集类型
 */
public class IntersectionType {

    public static void main(String[] args) {
        Flower f = (Flower & Plant) (s)-> s+"";
    }
}


interface Plant {

}

interface Flower {
    public String test(int s);
}


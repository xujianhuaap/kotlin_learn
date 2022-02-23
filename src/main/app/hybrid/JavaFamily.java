package hybrid;

import java.io.IOException;

public class JavaFamily {
    public void printTag(){
        System.out.println(KotlinFamily.TAG);
        System.out.println(KotlinFamily.VERSION);
        Garden<? super Plant> li = KotlinFamilyKt.box(new Living("tulip"));

        FlowerManager flowerManager = new FlowerManager();
        PlantManager<? extends Living,? super Plant> plantManager = flowerManager;
        plantManager.savePlant(new Flower("","",""));
        plantManager.savePlant(new Plant("plant","red"));
        Living living = plantManager.getLivingImpl(0);
        try {
            Flower flower = flowerManager.getLivingImpl(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Flower flower1 = new Flower("flower");
    }

}

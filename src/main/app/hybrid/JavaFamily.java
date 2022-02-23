package hybrid;

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
        Flower flower = flowerManager.getLivingImpl(0);

        Flower flower1 = new Flower("flower");
    }

}

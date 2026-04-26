import java.util.List;

public class Zookeeper {
    private String name;

    Zookeeper(String name){
        this.name = name;
    }

    public void preformDailyCare(List<Animal> animals) {

        System.out.println("--- Daily care routine ---");

        for (Animal a : animals) {
//            general care
            System.out.println("Checking health of " + a.getName());
            a.displayDetails();

//            Flyable interface
            if (a instanceof Flyable) {
                System.out.println("Performing wing health check...");
                ((Flyable) a).performWingCheck();
            }

//            Swimable interface
            if (a instanceof Swimable) {
                System.out.println("Checking water conditions...");
                ((Swimable) a).checkWaterConditions();
            }

//            Slitherable interface
            if (a instanceof Slitherable) {
                System.out.println("Checking skin conditions...");
                ((Slitherable) a).checkSkinConditions();
            }

            System.out.println((a.getName() + " is in good health"));
            System.out.println("---------");


        }

    }

    public void setName(){

    }

    public String getName() {
        return name;
    }



}//class

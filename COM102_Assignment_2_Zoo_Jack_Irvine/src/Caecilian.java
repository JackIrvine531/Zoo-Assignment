import java.util.Random;

public class Caecilian extends Animal implements Slitherable {
//    instance variable
    private int burrowDepth;

//    constructor
    Caecilian(String name, String colour, int age, double weight, int burrowDepth) {
        super(name, colour, age, weight);
        this.burrowDepth = burrowDepth;
    }


//    getters
    @Override
    public String makeSound() {
        return "click, click, I am " + name + " a " + age + " year old " + this.getClass().getSimpleName();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getColour() {
        return colour;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public double getWeight() {
        return weight;
    }


    public void getBurrowDepth() {
        System.out.println(burrowDepth + "cm");
    }

    public void displayDetails() {

        String details = "Name: " + name + "\n" +
                "Animal type: " + this.getClass().getSimpleName() + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "g\n" +
                "Burrow Depth: " + burrowDepth + "\n";

        System.out.println(details);
    }

    @Override
    public String getRandomFacts() {
        String[] facts = {
                "Caecilians shed their skin so their young can eat it",
                "Caecilians have very tiny eyes and don't see well",
                "While they look similar to worms or snakes, Caecilians are limbless amphibians",
                "Caecilians have a retractable sensory tentacles between their eyes and nostrils that can extend and retract"
        };
        return facts[new Random().nextInt(facts.length)];
    }

//    setters

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setBurrowDepth(int burrowDepth) {
        this.burrowDepth = burrowDepth;
    }

//    slitherable interface

    @Override
    public void slither() {
        System.out.println(name + " is slithering about");
    }

    @Override
    public void shedSkin() {
        System.out.println(name + " is shedding its skin");
    }

    @Override
    public void bask() {
        System.out.println(name + " is basking in the sun");
    }

    @Override
    public void hiss() {
        System.out.println(name + " is hissing");
    }

    @Override
    public void ambush() {
        System.out.println(name + " is setting an ambush for prey");
    }

    @Override
    public void checkSkinConditions() {
        System.out.println(name + "'s skin is in good condition");
    }

}//class

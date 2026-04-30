import java.util.Random;

public class Hippo extends Animal implements Swimable {
//    instance variable
    private boolean hungryHippo;

//    constructor
    Hippo(String name, String colour, int age, double weight, boolean hungryHippo){
        super(name, colour, age, weight);
        this.hungryHippo = hungryHippo;
    }

//    getters

    @Override
    public String makeSound() {
        return "honk,honk,honk,honk,honk, I am " + name + " a " + age + " year old " + this.getClass().getSimpleName();
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


    public boolean getHungryHippo() {
        return hungryHippo;
    }

    public void displayDetails() {

        String details = "Name: " + name + "\n" +
                "Animal type: " + this.getClass().getSimpleName() + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "kg\n" +
                "Is it a Hungry Hungry Hippo: " + hungryHippo + "\n";

        System.out.println(details);
    }

    @Override
    public String getRandomFacts() {
        String[] facts = {
                "Hippos can't really swim, instead they walk or bounce along the riverbed",
                "Hippos can run at around 30km/19MPH on land",
                "Hippos are more closely related to whales and dolphins than to other land mammals",
                "Hippos can sleep underwater, rising automatically to breathe without waking"
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

    @Override
    public boolean isValid() {
        return name != null && !name.trim().isEmpty()
                && colour != null && !colour.trim().isEmpty()
                && age> 0
                && weight > 0;
    }

    public void setHungryHippo (boolean hungryHippo) {
        this.hungryHippo = hungryHippo;
    }

//    Swimable interface

    @Override
    public void swim() {
        System.out.println(name + " swims about for a bit");
    }

    @Override
    public void dive() {
        System.out.println(name + " has dived a bit deeper under the water");
    }

    @Override
    public void rise() {
        System.out.println(name + " has risen in the water a bit");
    }

    @Override
    public void hide() {
        System.out.println(name + " has hidden from view");
    }

    @Override
    public void unhide() {
        System.out.println(name + " has returned into view after hiding a bit");
    }

    @Override
    public void checkWaterConditions() {
        System.out.println("The water in " + name + "'s habitat is in good condition");
    }
}//class

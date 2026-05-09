import java.util.Random;

public class Crocodile extends Animal implements Slitherable, Swimable{
//    instance variable
    private double biteForce;

//    constructor
    Crocodile(String name, String colour, int age, double weight, double biteForce) {
        super(name, colour, age, weight);
        this.biteForce = biteForce;
    }

//    getters

    @Override
    public String makeSound() {
        return "Hsssss, I am " + name + " a " + age + " year old " + this.getClass().getSimpleName();
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

    public double getBiteForce() {
        return biteForce;
    }

    public void displayDetails() {

        String details =
                "Animal type: " + this.getClass().getSimpleName() + "\n" +
                "Name: " + name + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "kg\n" +
                "Bite Force: " + biteForce + "\n";

        System.out.println(details);
    }

    @Override
    public String getRandomFacts() {
        String[] facts = {
                "Crocodiles can go through thousands of teeth in its lifetime",
                "The saltwater Crocodile has the one of the strongest recorded bite of any animal at over 3700 PSI",
                "Crocodiles can't sweat, instead they regulate heat by opening their mouths",
                "Crocodiles have a reflective layer in their eyes (like cats) that allow them to see very well in the dark",
                "Crocodiles can hold their breath for 15 minutes normally or if they are staying still and conserving energy up to an hour"
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

    public void setBiteForce(double biteForce) {
        this.biteForce = biteForce;
    }

//    slitherable interface

    @Override
    public void slither() {
        System.out.println(name + " slithered about");
    }

    @Override
    public void shedSkin() {
        System.out.println(name + " started to shed its skin");
    }

    @Override
    public void bask() {
        System.out.println(name + " is basking in the sun");
    }

    @Override
    public void checkSkinConditions() {
        System.out.println(name + "'s skin is in good condition");
    }

//    swimable interface

    @Override
    public void swim() {
        System.out.println(name + " is swimming around");
    }

    @Override
    public void dive() {
        System.out.println(name + " has went deeper underwater");
    }

    @Override
    public void rise() {
        System.out.println(name + " has rose up in the water a bit");
    }

    @Override
    public void hiss() {
        System.out.println(name + " has started to hiss");
    }

    @Override
    public void ambush() {
        System.out.println(name + " is laying in ambush");
    }

    @Override
    public void hide() {
            System.out.println(name + " is hidden from sight");
    }

    @Override
    public void unhide() {
        System.out.println(name + " has returned into view after hiding for a bit");
    }

    @Override
    public void checkWaterConditions() {
        System.out.println("The water in " + name + "'s habitat is in good condition");
    }

}//class

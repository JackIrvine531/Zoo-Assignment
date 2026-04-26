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


    public void getHungryHippo() {
        System.out.println(hungryHippo);
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
        System.out.println(name + " has dived under the water");
    }

    @Override
    public void checkWaterConditions() {
        System.out.println("The water in " + name + "'s habitat is in good condition");
    }
}//class

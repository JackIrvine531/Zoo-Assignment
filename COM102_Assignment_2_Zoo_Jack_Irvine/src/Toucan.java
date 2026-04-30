public class Toucan extends Animal implements Flyable {
//    instance variable
    private double beakLength;

//    constructor
    Toucan(String name, String colour, int age, double weight, double beakLength){
        super(name, colour, age, weight);
        this.beakLength = beakLength;
    }

// make sound
    @Override
    public String makeSound() {

        return "kreekk, kreekk, I am " + name +
                " a " + age + " year old " + this.getClass().getSimpleName();
    }

//    getters
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

    public void getBeakLength() {
        System.out.println(beakLength + "cm");
    }

    public void displayDetails() {

        String details = "Name: " + name + "\n" +
                "Animal type: " + this.getClass().getSimpleName() + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "g\n" +
                "Beak Length: " + beakLength + "\n";

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

    public void setBeakLength(double beakLength) {
        this.beakLength = beakLength;
    }

//    flyable interface

    @Override
    public void fly() {
        System.out.println(name + " has took off flying");
    }

    @Override
    public void land() {
        System.out.println(name + " has landed");
    }

    @Override
    public void chirp() {
        System.out.println(name + " is croaking");
    }

    @Override
    public void roost() {
        System.out.println(name + " is roosting");
    }

    @Override
    public void cleanSelf() {
        System.out.println(name + " is cleaning itself");
    }

    @Override
    public void performWingCheck() {
        System.out.println(name + "'s wings are in good condition");
    }
}//class

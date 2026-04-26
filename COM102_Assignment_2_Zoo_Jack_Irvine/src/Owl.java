public class Owl extends Animal implements Flyable {

//    instance variable
    private int hearingRange;

//    constructor
    Owl(String name, String colour, int age, double weight, int hearingRange){
        super(name, colour, age, weight);
        this.hearingRange = hearingRange;
    }

//  getters
    @Override
    public String makeSound() {
        return "Hoo, Hoo, I am " + name + " a " + age + " year old " + this.getClass().getSimpleName();
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


    public void getHearingRange() {
        System.out.println(hearingRange + " Meters");
    }

    public void displayDetails() {

        String details = "Name: " + name + "\n" +
                "Animal type: " + this.getClass().getSimpleName() + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "kg\n" +
                "Hearing Range: " + hearingRange + "\n";
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

    public void setHearingRange(int hearingRange) {
        this.hearingRange = hearingRange;
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
    public void performWingCheck() {
        System.out.println(name + "'s wings are in good condition");
    }

}//class

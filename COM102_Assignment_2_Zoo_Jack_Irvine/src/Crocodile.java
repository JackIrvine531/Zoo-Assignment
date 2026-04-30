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

    public void getBiteForce() {
        System.out.println(biteForce + " PSI");
    }

    public void displayDetails() {

        String details = "Name: " + name + "\n" +
                "Animal type: " + this.getClass().getSimpleName() + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "kg\n" +
                "Bite Force: " + biteForce + "\n";

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

    public void setBiteForce(Double biteForce) {
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

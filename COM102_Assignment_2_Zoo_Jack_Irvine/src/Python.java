import java.util.Random;

public class Python extends Animal implements Slitherable {
//    instance variable
    private int tongueFlicksPerMin;

//    constructor
    Python(String name, String colour, int age, double weight, int tongueFlicksPerMin){
        super(name, colour, age, weight);
        this.tongueFlicksPerMin =  tongueFlicksPerMin;
    }

//    getters

    @Override
    public String makeSound() {
        return "sssssss, I am " + name + " a " + age + " year old " + this.getClass().getSimpleName();
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

    public int getTongueFlicksPerMin() {
        return tongueFlicksPerMin;
    }

    public void displayDetails() {

        String details = "Name: " + name + "\n" +
                "Animal type: " + this.getClass().getSimpleName() + "\n" +
                "Colour: " + colour + "\n" +
                "Age: " + age + "\n" +
                "Weight: " + weight + "kg\n" +
                "Tongue Flicks Per Minute: " + tongueFlicksPerMin + "\n";

        System.out.println(details);
    }

    @Override
    public String getRandomFacts() {
        String[] facts = {
                "Pythons can swallow prey whole, even animals as large as deer, and then go weeks or months without eating",
                "The Reticulated python can grow over 6-7 meters (20+ feet), making it the longest snake in the world",
                "Many species like the Burmese python have special pits along their jaws that detect heat, helping them hunt in complete darkness",
                "Pythons still have tiny vestigial 'Legs' called spurs near their tails, remnants from their evolutionary ancestors"
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

    public void setTongueFlicksPerMin(int tongueFlicksPerMin) {
        this.tongueFlicksPerMin = tongueFlicksPerMin;
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
        System.out.println(name + " is laying in ambush for prey");
    }

    @Override
    public void checkSkinConditions() {
        System.out.println(name + "'s skin is in good condition");
    }

}//class

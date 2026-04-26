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

    public void getTongueFlicksPerMin() {
        System.out.println(tongueFlicksPerMin + " per minute");
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
    public void checkSkinConditions() {
        System.out.println(name + "'s skin is in good condition");
    }

}//class

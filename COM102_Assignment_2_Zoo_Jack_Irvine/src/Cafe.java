public class Cafe extends Store{

    public Cafe() {
        super("Cafe");

        items.add(new Item("Coffee", 4.5));

    }

    @Override
    public void displayItems() {
        System.out.println("--- " + name + " ---");
        for (int i =0; i< items.size(); i++) {
            Item item = items.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - £" + item.getPrice());

        }
    }

    @Override
    public void buyItem(int index, Visitor visitor) {

        //out of bounds
        if (index <0 || index >= items.size()) {
            System.out.println("Invalid Selection");
            return;
        }

        Item item = items.get(index);

        if (visitor.withdraw(item.getPrice())) {
            System.out.println("You bought: " + item.getName());
        } else {
            System.out.println("Not enough balance, Transaction Canceled");
        }
    }
}//class

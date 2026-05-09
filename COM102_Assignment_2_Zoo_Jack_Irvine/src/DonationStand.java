public class DonationStand extends Store {

    //constructor
    public DonationStand() {
        super("Donation Stand");

        //items that will be displayed and can be bought
        items.add(new Item("£5 Donation", 5));
        items.add(new Item("£10 Donation", 10));
        items.add(new Item("£20 Donation", 20));
        items.add(new Item("£50 Donation", 50));
        items.add(new Item("£100 Donation", 100));
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

    @Override
    public int getItemCount() {
        return items.size();
    }

}//class

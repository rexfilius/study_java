package designPatterns.behavioural.templateMethod;

abstract class OrderProcessTemplate {
    public boolean isGift;

    public abstract void doSelect();

    public abstract void doPayment();

    public final void giftWrap() {
        System.out.println("Gift wrap successful");
    }

    public abstract void doDelivery();

    public final void processOrder(boolean isGift) {
        doSelect();
        doPayment();
        if (isGift) giftWrap();
        doDelivery();
    }
}

class NetOrder extends OrderProcessTemplate {

    @Override
    public void doSelect() {
        System.out.println("Item added to online shopping cart");
        System.out.println("Get gift wrap preference");
        System.out.println("Get delivery address.");
    }

    @Override
    public void doPayment() {
        System.out.println("Online Payment through Netbanking, card or Pay pal");
    }

    @Override
    public void doDelivery() {
        System.out.println("Ship the item through post office to delivery address");
    }
}

class StoreOrder extends OrderProcessTemplate {

    @Override
    public void doSelect() {
        System.out.println("Customer chooses the item from shelf.");
    }

    @Override
    public void doPayment() {
        System.out.println("Pays at counter through cash/POS");
    }

    @Override
    public void doDelivery() {
        System.out.println("Item delivered to in delivery counter.");
    }
}

public class TemplateMethodPattern2 {
    public static void main(String[] args) {
        OrderProcessTemplate netOrder = new NetOrder();
        netOrder.processOrder(true);

        System.out.println("------ We changed the template to a store order");

        OrderProcessTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder(true);
    }
}

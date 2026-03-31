package order_management_system;

public class OrderManagement {
    public static void main(String[] args) {

        Products p1 = new Products(1,"Ball Pen",10,10);
        Products p2 = new Products(2,"Gel Pen",10,5);
        Products p3 = new Products(3,"Book",5,100);
        Products p4 = new Products(4,"Notebook",5,50);

        Products store = new Products(0,"",0,0);
        store.addPro(p1);
        store.addPro(p2);
        store.addPro(p3);
        store.addPro(p4);

        Customer c1 = new Customer("Rahul","9876543210");

        store.displayProduct();
        c1.addToCart(p1,2);
        c1.addToCart(p4,1);

        c1.placeOrder();
        c1.cancelOrder();
        c1.placeOrder();
    }
}

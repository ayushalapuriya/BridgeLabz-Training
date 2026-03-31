import java.util.*;
public class TheCoffeeCounterChronicles {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Coffee Type			Price Chart");
		System.out.println("Americano			₹130");
		System.out.println("Cappuccino			₹200");
		System.out.println("Latte				₹270");
		System.out.println("Cold Brew			₹160");
		
		System.out.print("Which Coffee Type do you want: ");
		String coffeeType=sc.next();
		
		System.out.print("How many "+coffeeType+" do you want: ");
		int quantity=sc.nextInt();
		int price=0;
		
		switch(coffeeType) {
		case "Americano":
			price=130;
			break;
		case "Cappuccino":
			price=200;
			break;
		case "Latte":
			price=270;
			break;
		case "Cold Brew":
			price=160;
			break;
		}
		int bill=price*quantity;
		int gst=5;
		bill+=(bill*gst)/100;
		System.out.println("Your bill of "+quantity+" "+coffeeType+" is: "+bill);
		sc.close();
	}
}

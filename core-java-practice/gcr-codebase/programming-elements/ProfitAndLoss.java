
public class ProfitAndLoss {
	public static void main(String[] args) {
		int costPrice=129;
		int sellPrice=191;
		int profit=sellPrice-costPrice;
		double profitPercentage=(profit*100)/costPrice;
		System.out.println("The Cost Price is INR: "+costPrice+" and Selling Price is INR: "+sellPrice);
		System.out.println("The Profit is INR: "+profit+" and the Profit Percentage is: "+profitPercentage);
	}
}

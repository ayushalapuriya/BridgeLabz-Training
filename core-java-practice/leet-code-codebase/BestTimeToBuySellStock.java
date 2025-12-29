import java.util.Scanner;
public class BestTimeToBuySellStock {
    public static int bestTimeToBuySellStock(int[] prices) {
        int buy=prices[0];
        int max=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<buy) buy=prices[i];
            if((prices[i]-buy)>max) max=prices[i]-buy;
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]prices=new int[n];
        for(int i=0;i<n;i++) prices[i]=sc.nextInt();
        int maxProfit=bestTimeToBuySellStock(prices);
        System.out.println(maxProfit);
        sc.close();
    }
}
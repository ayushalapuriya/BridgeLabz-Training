package reviews.code;
import java.util.*;
public class secondLargest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n]; // 1 3 4 5 3
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();

        int max=arr[0];
        int secondMax=0;
        for(int i=1;i<n;i++){
            if(arr[i]>max){
                secondMax=max;
                max=arr[i];
            }
            else{
                if(arr[i]>secondMax) secondMax=arr[i];
            }
        }

        System.out.print("largest is: "+max+" secondLargest is: "+secondMax);
    }
}

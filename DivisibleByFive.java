import java.util.Scanner;
//This was around first year
public class DivisibleByFive{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] num = new int[10];
        //int[] num = {1,8,4,9,5,8,10,14,15,20};
        boolean hasDivisibles = false;
        String js = "";
        for(int i = 0; i < num.length; i++){
            System.out.print("Enter element "+(1+i)+": ");
            num[i] = in.nextInt();
        }
        for(int j = 0; j < num.length; j++){
            int mod = num[j] % 5;
            if(mod == 0){
                //System.out.println("Element divisible by 5:"+num[j]+":found at index:"+j+":");
                js += num[j]+"";
                if(j != num.length - 1){
                    js += ", ";
                }
                hasDivisibles = true;
            }
        }
        if(!js.equalsIgnoreCase("")){
            System.out.println("Divisibles: " + js);
        }
        if(!hasDivisibles){
            System.out.println("No elements divisible by 5 is found.");
        }
    }
}

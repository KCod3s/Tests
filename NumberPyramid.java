public class NumberPyramid{
    public static void main(String[] args) {
        
        int length = 6;
        
        for (int i = length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                System.out.print("  "); 
            }
            for (int k = length; k >= i; k--){
                System.out.print(" "+i);
            }
            
            System.out.println(); 
        }
    }
}

import java.util.Scanner;
import java.util.Random;

public class BlackJack{
    
    Scanner sc = new Scanner(System.in);
    Random rn = new Random();
    
    int money = 2000;
    int bet = 300;
    
    int dealer;
    int dealerSec;
    int player;
    
    void clearScreen(){
        System.out.print("\033[H\033[2J");
    }
    
    void prinMoneyBet(){
        System.out.println("Money: " + money);
        System.out.println("Bet: " + bet);
    }
    
    int random(){
        return rn.nextInt(9) + 1;
    }
    
    void prinDealerPlayer(String msg){
        System.out.println("\nDealer: " + dealer);
        System.out.println("Player: " + player);
        System.out.println(msg);
    }
    
    boolean playerWins() {
        
        if(player == 21){
            this.prinDealerPlayer("BLACKJACK! You win!");
            return true;
        }else if(player > 21){
            this.prinDealerPlayer("You bust! Dealer wins!");
            return false;
        }
        
        dealer += dealerSec;
        
        while(dealer < 17){
            dealer += this.random();
        }
        
        if(dealer == 21){
            this.prinDealerPlayer("BLACKJACK! Dealer wins!");
            return false;
        }else if(dealer > 21){
            this.prinDealerPlayer("Dealer bust! You win!");
            return true;
        }
        
        if(player > dealer){
            this.prinDealerPlayer("You win");
            return true;
        }else if(dealer > player){
            this.prinDealerPlayer("Dealer wins!");
            return false;
        }else if(player == dealer){
            this.prinDealerPlayer("Tie!");
        }
        
        return true;
    }
    
    void priBetScreen(){
        int inpBet = 0;
        
        while(inpBet != 5){
            
            this.clearScreen();
            
            this.prinMoneyBet();
                
            System.out.println("\n1 - 100\n2 - 200\n3 - 300\n4 - custom\n5 - Play");
            
            if(bet > money){
                System.out.println("You do not have enough money!");
            }
            
            System.out.print("Input: ");
            inpBet = sc.nextInt();
                
            switch(inpBet){
                case 1:
                bet = 100;
                break;
                    
                case 2:
                bet = 200;
                break;
                    
                case 3:
                bet = 300;
                break;
                    
                case 4:
                System.out.print("Place bet: ");
                bet = sc.nextInt();
                break;
                    
                case 5:
                break;
                    
                default:
                System.out.println("Invalid input");
                break;
            }
        }   
    }
    
    void play(){
        
        if(bet > money){
            this.clearScreen();
            this.prinMoneyBet();
            System.out.println("You do not have enough money!");
            return;
        }
        
        dealer = this.random();
        player = this.random();
        dealerSec = this.random();
        
        int inpPlay = 0;
        
        do{
            
            this.clearScreen();
            this.prinMoneyBet();
            
            this.prinDealerPlayer(" ");
            
            System.out.println("1-Double  2-Stand  3-Hit");
            System.out.print("Input: ");
            inpPlay = sc.nextInt();
            
            switch(inpPlay){
                case 1:
                bet *= 2;
                if(bet > money){
                    System.out.println("You don't have enough money to do that!");
                    break;
                }
                player += this.random();
                break;
                
                case 2:
                break;
                
                case 3:
                player += this.random();
                break;
                
                default:
                System.out.println("Invalid input");
                break;
            }
            
            if(inpPlay == 1 && bet > money){
                bet /= 2;
                System.out.print("Input: ");
                inpPlay = sc.nextInt();
                
                if(inpPlay == 3){
                    player += this.random();
                }
            }
            
            
        }while(inpPlay == 3 && player < 21);
        
        this.clearScreen();
        this.prinMoneyBet();
        
        if(this.playerWins()){
            if(dealer == player){
                return;
            }
            money += bet;
        }else{
            money -= bet;
        }
    }
    
    public static void main(String[] args){
        BlackJack b = new BlackJack();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to BlackJack!");
        System.out.println("\n1 - Start\n2 - Leave");
        
        System.out.print("Input: ");
        int input = sc.nextInt();
        
        int cont = 0;
        
        if(input == 1){
            do{
                b.priBetScreen();
                b.play();
                
                if(b.money <= 0){
                    System.out.println("You have no more money!.");
                    break;
                }
                System.out.println("\n1 - Continue\n2 - Leave and check money");
                System.out.print("Input: ");
                cont = sc.nextInt();
            }while(cont != 2 && b.money > 0);
            
            if(cont == 2){
                b.clearScreen();
                System.out.println("Money: " + b.money);
            }
            
        }else{
            System.out.println("Goodbye!");
        }
        
    }
}

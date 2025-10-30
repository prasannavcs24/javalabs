import java.util.Scanner;
class Account{
    String customerName;
    int accountNumber;
    String accountType;
    double balance;
    
    Account(String name, int accNo, String type, double bal){
        customerName= name;
        accountNumber=accNo;
        accountType=type;
        balance=bal;
    }
    void deposit(double amount){
        if(amount>0){
            balance +=amount;
            System.out.println("Deposited: "+amount);
        }else{
            System.out.println("Invalid deposit amount");
        }
    }
    void displayBalance(){
        System.out.println("Account Holder: "+customerName);
        System.out.println("Account number: "+accountNumber);
        System.out.println("Account type: "+accountType);
        System.out.println("Current Balance: "+balance);
    }
    void withdraw(double amount){
        if(amount>balance){
            System.out.println("Insufficient Balance...");
        }else if(amount<=0){
            System.out.println("Invalid witdrawal amount...");
        }else{
            balance-= amount;
            System.out.println("Withdrawn: "+amount);
        }
    }
}

class SavAcct extends Account{
    final double interestRate=0.05;

    SavAcct(String name,int accNo,double bal){
        super(name,accNo,"Savings",bal);
    }
    void computeAndDepositInterest(int years){
        double interest=balance*Math.pow((1+interestRate),years)-balance;
        balance+=interest;
        System.out.println("Interest of "+String.format("%.2f",interest)+" added for "+years+ "year(s)");
    }
}

class CurAcct extends Account{
    final double minBalance=1000.0;
    final double serviceCharge=100.0;

    CurAcct(String name, int accNo, double bal){
        super(name, accNo,"Current", bal);
    }
    void withdraw(double amount){
      if(amount>balance){
        System.out.println("Insufficient balance...");
        return;
      }
      balance-=amount;
      System.out.println("Withdrawn: "+amount);
      
      if(balance<minBalance){
        balance-=serviceCharge;
        System.out.println("Balance below Minimum...Service charge of "+serviceCharge+" imposed.");
      }
    }
}
public class bank {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        SavAcct sav = new SavAcct("Ramesh", 1001, 5000);
        CurAcct cur= new CurAcct("Suresh", 2001, 2000);
        int choice;
        do{
            System.out.println("__---Bank Menu---__");
            System.out.println("1. Deposit (Savings)");
            System.out.println("2. Withdraw (Savings)");
            System.out.println("3. Compute Interest (Savings)");
            System.out.println("4. Display Balance (Savings)");
            System.out.println("5. Deposit (Current)");
            System.out.println("6. Withdraw (Current)");
            System.out.println("7. Display Balance (Current)");
            System.out.println("8. Exit");
            System.out.print("Enter choice : ");
            choice=sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    sav.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter amount to Withdraw: ");
                    sav.withdraw(sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter number of years: ");
                    sav.computeAndDepositInterest(sc.nextInt());
                    break;
                case 4:
                    sav.displayBalance();
                    break;
                case 5:
                    System.out.print("Enter amount to Deposit: ");
                    cur.deposit(sc.nextDouble());
                    break;
                case 6:
                    System.out.print("Enter amount to withdraw: ");
                    cur.withdraw(sc.nextDouble());
                    break;
                case 7:
                    cur.displayBalance();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice...");
            }
        }while(choice!=8);
        sc.close();
    }
}

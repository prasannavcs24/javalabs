/*
Your app supports multiple payment options: , , and .
Each payment method must implement:
interface Payment {
boolean process(double amount);
}
Implement classes for each payment type.
For CreditCard, reject payments above ₹50,000.
For UPI, accept only if amount ≤ ₹1,00,000.
Test all payment methods in main().
*/
interface Payment{
    boolean process(double amount);
}
class UPI implements Payment
{
     public boolean process(double amount)
    {
        if(amount>100000)
        {
            System.out.println("Value exceeds limit, process failed...");
            return false;
        }
        else
        {
            System.out.println("Payment successful...");
            return true;
        }
    }
}
class CreditCard implements Payment
{
    public boolean process(double amount)
    {
        if(amount>50000)
        {
            System.out.println("Value exceeds limit, Payment failed...");
            return false;
        }
        else
        {
            System.out.println("Payment successful...");
            return true;
        }
    }
}
class netbanking implements Payment
{
    public boolean process(double amount)
    {
        System.out.println("Payment Successful");
        return true;
    }
}

public class PaymentTest{
    public static void main(String args[]){
        Payment P1 = new CreditCard();
        Payment P2=new UPI();
        Payment P3=new netbanking();

        System.out.println("------ Testing Credit Card ------");
        P1.process(1000000);
        P1.process(1000);

        System.out.println("------ Testing UPI ------");
        P2.process(111111);
        P2.process(1111);

        System.out.println("------ Testing Net Banking ------");
        P3.process(123456);
    }
} 
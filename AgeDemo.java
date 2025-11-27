/*7th Program*/
class WrongAge extends Exception{
    public WrongAge(String message){
        super(message);
    }
}

class Father{
    int fatherAge;
    Father(int age) throws WrongAge{
        if(age<0){
            throw new WrongAge("Fathers age cannot be negative!");
        }
        this.fatherAge = age;
    }
}

class Son extends Father{
    int sonAge;
    Son(int fatherAge,int sonAge) throws WrongAge{
        super(fatherAge);
        if(sonAge<0){
            throw new WrongAge("Sons age cannot be negative!");
        }
        if(sonAge>=fatherAge){
            throw new WrongAge("Son's age must be less than Father's age!!!");
        }
        this.sonAge= sonAge;
    }
}

public class AgeDemo{
    public static void main(String[] args){
        try{
            Son s= new Son(40,20);
            System.out.println("Father age :"+s.fatherAge);
            System.out.println("Son age :"+s.sonAge);
        }
        catch (WrongAge e){
            System.out.println("Exception:"+e.getMessage());
        }
        System.out.println("");
        try{
            Son s2 = new Son(30, 35);
        }
        catch(WrongAge e){
            System.out.println("Exception :"+ e.getMessage());
        }
    }

}

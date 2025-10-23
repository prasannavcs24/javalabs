
class addc2{
    public static void main(String args[]){
        complex c1= new complex();
        complex c2=new complex();
        complex c3;
        c1.read(2,3);
        c2.read(5,6);
        c3=c1.add(c2);
        c3.display();
    }
}
class complex{
    int r, i;
public void read(int x, int y){
    r=x;
    i=y;
}
public void display(){
    System.out.print("r= "+r+"i= "+i);
}
public complex add(complex a){
    complex sum=new complex();
    sum.r=r+a.r;
    sum.i=i+a.i;
    return (sum);
}
}
class thispointer{
    int x , y;
    public void function(int x, int y){
        System.out.println("values of local variables x and y are: "+x+" and "+y );
        this.x=x;
        this.y=y;
        System.out.println("Values of Global variables x and y are: "+x+" and "+y);
    }
    public static void main(String args[]){
        thispointer obj=new thispointer();
        obj.function(10,20);
    }
}
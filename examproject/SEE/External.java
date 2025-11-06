package SEE;
import CIE.*;
public class External extends Personal{
    public int[] seeMarks= new int[];

    public External(String usn, String name, int sem, int [] seeMarks){
        super(usn,name,sem);
        for(int i=0;i<5;i++)
        this.seeMarks[i] = seeMarks[i];
    }

    public void displaySEE(){
        System.out.print("SEE marks : ");
        for(int mark : seeMarks)
            System.out.print(mark + " ");
        System.out.println();
    }
}

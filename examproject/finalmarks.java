import CIE.*;
import SEE.*;
import java.util.*;
public class finalmarks {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int n=sc.nextInt();

        External[] students= new External[n]; 
        Internals[] internals= new Internals[n];

        for(int i=0;i<n; i++){
            System.out.println("Enter details for student "+(i+1));
            
            System.out.print("USN: ");
            String usn=sc.next();
            
            System.out.print("Name: ");
            String name=sc.next();
            
            System.out.print("Semester: ");
            int sem=sc.nextInt();

            System.out.println("Enter 5 Internal marks(Out of 50): ");
            int[] internalMarks = new int[5];
            for(int j =0; j<5;j++)
                internalMarks[j]=sc.nextInt();
            
            System.out.println("Enter 5 SEE Marks(Out of 100):");
            int[] seeMarks= new int[5];
            for(int j=0;j<5;j++)
            seeMarks[j]= sc.nextInt();

            internals[i]= new Internals(internalMarks);
            students[i]= new External(usn, name, sem, seeMarks);
        }
        System.out.println("\n----- Final Marks of Students ----");
        for(int i=0;i<n;i++){
            students[i].display();
            internals[i].displayInternals();
            students[i].displaySEE();

            System.out.print("Final Marks: ");
            for(int j=0;j<5;j++){
                double finalMark = internals[i].internalMarks[j]+(students[i].seeMarks[j]/2.0);
                System.out.print(finalMark+" ");
            }
            System.out.println("\n-------------------------------");
        }
        sc.close();
    }
}

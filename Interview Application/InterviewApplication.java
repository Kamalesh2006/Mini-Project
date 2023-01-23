import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class InterviewApplication{

    static Queue<Applicant> applicantQueue = new LinkedList<Applicant>();


    public static void main(String[] args) throws InterruptedException {

        
        System.out.println("\n--------Welcome to Interview Application bot----------");
        

        while(true){

            Scanner sh = new Scanner(System.in);
            System.out.print("\n-x-x-x-Enter your Details to register for the interview-x-x-x-");

            System.out.print("\n\n\tEnter your name: ");
            String name = sh.nextLine();

            System.out.print("\n\n\tEnter your email Id: ");
            String email = sh.nextLine();

            System.out.print("\n\n\tEnter your age: ");
            int age = sh.nextInt();


            System.out.print("\n\n\tEnter your phone number: ");
            long number = sh.nextLong();
            
            //factory method to create applicant object...
            Applicant applicant = Applicant.addApplicant(name, age, email, number);

            //if the applicant has entered one detail that is incorrect or email that is already registered then it will return null
            if(applicant==null){
                System.out.println("\n\t\t-x-x-x-Try again-x-x-x-\n");
            }

            //else it will return applicant object
            else{
                System.out.println("\nApplicant "+name+" is successfully added in the database");
                applicantQueue.add(applicant);
                System.out.print("\n\nDo you want to add another applicant (Yes/No): ");
                String yesNo = sh.next().toLowerCase();
                if(yesNo.equals("yes")){
                    continue;
                }
                else{
                    
                    System.out.println("\n\t----Thank you for using the application----\n\n");
                    while(!applicantQueue.isEmpty()){
                        Thread.sleep(4000);
                        printRegistered();

                    }
                    System.out.println("\n\t---Interviews completed----");
                    break;
                }
            }

        }

        
    }

    /**
     * print the first two of applicants who are there in interview queue. 
     */
    public static void printRegistered(){

        System.out.println("\n-----Interviews are conducted for the following applicants-----");
        int count =1;
        int sno=1;
        System.out.println("---------------------------------------------------------------\n");
        System.out.println("S.NO\tName\tage\tEmail\t\tPhone Number");
        while(count>0 && applicantQueue.size()!=0){
            System.out.println("\n"+sno+") "+ applicantQueue.peek());
            sno++;
            count--;
            applicantQueue.remove();
            if(applicantQueue.size()!=-0){
                System.out.println("\n"+sno+") "+ applicantQueue.peek());
            }
        }
        System.out.println("---------------------------------------------------------------\n");

    }
    
    
}

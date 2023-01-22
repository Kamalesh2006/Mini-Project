import java.util.regex.*;
import java.util.LinkedList;
public class Applicant {

        private String name;
        private int age;
        private String email;
        private long number;
        private static LinkedList<String> emailIds=new LinkedList<>();

    private Applicant(String name, int age, String email, long number){

        this.name = name;
        this.age = age;
        this.email=email;
        this.number = number;
        
    }

    private boolean validateEmail(String email){
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9]*@[a-zA-Z0-9]+[.][com]");
        Matcher m = p.matcher(email);
        if(m.find()){
            return true;
        }else{
            System.out.println("\n---Please input the correct email id---");
            return false;
        }
    }
    private  boolean validatePhone(long num){
        Pattern p = Pattern.compile("[7-9][0-9]{9}");
        String number = Long.toString(num);
        Matcher m = p.matcher(number);
        if(number.length()==10 && m.find()){
            return true;
        }else{
            System.out.println("\n---Please input the correct phone number---");
            emailIds.remove(email);
            return false;
        }

    }
    //factory method
    public static Applicant addApplicant(String name, int age, String email, long number){
        
        Applicant applicant= new Applicant(name, age, email, number);

        if(age<18){
            System.out.println("\n-x-x-User is too young to apply for the interview-x-x-");
            return null;
        }else if(age>60){
            System.out.println("\n-x-x-Applicant is too old to apply for the interview-x-x-");
            return  null;
        }

        if(applicant.validateEmail(email)){
            if(emailIds.contains(email)){
                System.out.println("\n\n\t-----------------------------------");
                System.out.println("\n\t-x-x-User already registered-x-x-x-");
                System.out.println("\n\t-----------------------------------");
                return null;
            }
            emailIds.add(email);
            
            applicant.email = email;
        }

        else{
            return null;
        }
        
        if(applicant.validatePhone(number)){
            applicant.number=number;
        }else{
            return null;
        }
        return applicant;
    }
    public String toString(){
        return "\t"+name+" "+age+" "+email+" "+number;
    }
    
}


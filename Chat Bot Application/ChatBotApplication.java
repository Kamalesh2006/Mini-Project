import java.util.Stack;

public class ChatBotApplication {

    public static void main(String[] args) {

        Stack<ChatBotOptions> stackOfObject = new Stack<>();
        
        System.out.println("\n\n---- Welcome to chat-bot application ----\n\n");
        int count =3;

        while(true){

            System.out.println("Select your Preferred Language to proceed\n");

            String[] lang ={"Tamil","English","Hindi"};

            System.out.printf("\tPress 1 for %s\n\n\tPress 2 for %s\n\n\tPress 3 for %s\n\n",lang[0],lang[1],lang[2]);

            
            int langIndex= new GetInput().getInput()-1;

            if(langIndex>2 || langIndex <0){

                
                count--;
                if(count==0){
                    System.out.println("\n\tYou have reached the limit. Please Try Again after sometime.");
                    break;
                }
                else{
                    System.out.println("\nx-x-x-PLEASE ENTER THE CORRECT NUMBER-x-x-x\n");
                }
                continue;

            }
            

            System.out.printf("\nYou have chosen %s language\n\n",lang[langIndex]);

            ChatBotOptions menu  = new MainMenu();
            
            //to wait for the user to enter into main menu setting
            try{
                Thread.sleep(1500);
                stackOfObject.push(menu);
                menu.options(stackOfObject);
            }
            catch(InterruptedException ie){
                System.out.println("Unexpected Error\n Restart again to continue");
            }
            break;

        }

        

    }
}

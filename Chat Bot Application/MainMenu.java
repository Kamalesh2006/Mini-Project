import java.util.Stack;
public class MainMenu implements ChatBotOptions{
    /**
     * this function shows the main menu 
     * @param Stack<ListDown> this stack contains all the menu options 
     * @throws InterruptedException because it uses sleep method in Thread class
     */


    public void options(Stack<ChatBotOptions> stack)  throws InterruptedException{

        System.out.println("------You are currently in Main Menu-------\n");


        System.out.println("\tPress 1 for Recharge options\n");
        Thread.sleep(750);

        System.out.println("\tPress 2 for caller tune options\n");
        Thread.sleep(750);

        System.out.println("\tPress 3 for internet related queries\n");
        Thread.sleep(750);

        System.out.println("\tPress 4 to talk with our customer service people\n");
        Thread.sleep(750);

        System.out.println("\tPress 5 to exit\n");
        Thread.sleep(750);

        int option = new GetInput().getInput();

        switch(option){

            case 1:
                ChatBotOptions recharge = new RechargeOptions();
                stack.push(recharge);
                recharge.options(stack);;
                break;
                
            case 2:
                ChatBotOptions callertune = new CallerTune();
                stack.push(callertune);
                callertune.options(stack);
                break;

            case 3:
                ChatBotOptions internet= new InternetOptions();
                stack.push(internet);
                internet.options(stack);
                break;

            case 4:
                System.out.println("\n---Thanks for calling the customer care. Your call may be recorded for quality purposes---");
                Thread.sleep(5000);

            case 5:
                System.out.println("\n--------Thank you for using our service---------\n\n");
                stack.pop();
                break;

                
            default:
                System.out.println("\n\n-x-x-x-Wrong input Please input the correct number-x-x-x-\n\n");
                stack.peek().options(stack);
                break;
        }
    }
}

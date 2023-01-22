import java.util.Timer;
import java.util.Scanner;
import java.util.TimerTask;

public class GetInput
{
    private int s=0;

    TimerTask task = new TimerTask()
    {
        public void run()
        {
            if( s==0 )
            {
                System.out.println( "\tYou have entered nothing...\n\n\tThanks for using our application" );
                System.exit( 0 );
            }
        }    
    };
    
    /**
     * This function uses Scanner class along with Timer class to get the input from the user within specified time
     * @return int type input received from the user
     */
    public int getInput()
    {
        Timer timer = new Timer();
        timer.schedule( task, 20*1000 );
        
        
        System.out.println( "\n\n----Input a number within 20 seconds: ----\n\n" );
        
        Scanner sh = new Scanner(System.in);
        int s = sh.nextInt();

        timer.cancel();
        return s;
    }
}


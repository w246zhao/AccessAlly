import java.io.*;

public class P1_Finding_Fave_Times {

    // NOTE: Problem takes input from command line
    public static void main(String[] args) throws IOException {
        final int DAILY_ARITHMETIC_TIMES = 31;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int currentTime = 1200;
        int counter = 0;
        int minutes = Integer.parseInt(br.readLine());

        if (minutes >= 720) {
            counter += DAILY_ARITHMETIC_TIMES * (minutes/720);
            minutes %= 720;
        }

        // go through all the minutes to check
        for (int i = 0; i < minutes; i++) {
            if (currentTime == 1259) {
                currentTime = 100;
            } else if (currentTime %100 == 59) {
                currentTime += 41;
            } else {
                currentTime++;
            }

            if (currentTime >= 1000) {
                if ( (currentTime/1000 - (currentTime/100)%10) == ((currentTime/10)%10 - currentTime%10)
                        && ((currentTime/10)%10 - currentTime%10) == ((currentTime/100)%10 - (currentTime/10)%10)) {
                    counter++;
                }
            } else {
                if ( (currentTime/100 - (currentTime/10 )%10 ) == ( (currentTime/10 )%10 - currentTime%10) ) {
                    counter++;
                }
            }

        }

        System.out.println(counter);

    }
}

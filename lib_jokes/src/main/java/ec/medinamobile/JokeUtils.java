package ec.medinamobile;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * Created by Erick on 27/7/17.
 */

public class JokeUtils {

    public static final String path = "file:///";
    public static final String jokeFileName = "jokes.txt";
    public static final URI jokeFileUri = URI.create(path+jokeFileName);
    public static  final String JOKE_SEPARATOR = ";";

    public static final String JOKE_01 = "Can a kangaroo jump higher than a house? - Of course, a house doesn’t jump at all.";
    public static final String JOKE_02 = "Doctor: \"I'm sorry but you suffer from a terminal illness and have only 10 to live.\" Patient: \"What do you mean, 10? 10 what? Months? Weeks?!\" Doctor: \"Nine.\"";
    public static final String JOKE_03 = "Anton, do you think I’m a bad mother? My name is Paul.";
    public static final String JOKE_04 = "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.";
    public static final String JOKE_05 = "What is the difference between a snowman and a snowwoman? - Snowballs.";
    public static final String JOKE_06 = "Mother: \"How was school today, Patrick?\" Patrick: \"It was really great mum! Today we made explosives!\" Mother: \"Ooh, they do very fancy stuff with you these days. And what will you do at school tomorrow?\" Patrick: \"What school?\"";
    public static final String JOKE_07 = "\"Mom, where do tampons go?\" \"Where the babies come from, darling.\" \"In the stork?\"";
    private static final String JOKE_08 = "Man to his priest: \"Yesterday I sinned with an 18 year old girl.\" The priest: \"Squeeze 18 lemons and drink the juice all at once.\" Man: \"And that frees me from my sin?\" Priest: \"No, but it frees your face from that dirty grin.\"";
    private static final String JOKE_09 = "Doctor: \"I’ve found a great new drug that can help you with your sleeping problem.\" Patient: \"Great, how often do I have to take it?\" Doctor: \"Every two hours.\"";
    private static final String JOKE_10 = "Sleep with an open window tonight! 1400 mosquitos like that. 420 mosquitos commented on it. 210 mosquitos shared this.One mosquito invited for the event. 2800 mosquitos will be attending the event.";

    public static String[] readJokesFromFile(){
        BufferedReader reader = null;
        try {
            File file = new File(jokeFileName);
            if (file!=null && file.exists()){

                reader = new BufferedReader(new FileReader(jokeFileName));
                String line = null;
                StringBuilder stringBuilder = new StringBuilder();

                while ((line=reader.readLine())!=null){
                    stringBuilder.append(line);
                }

                String jokes = stringBuilder.toString();

                return jokes.split(JOKE_SEPARATOR);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader!=null)
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String[] readJokes(){
        String[] mJokes = new String[]{JOKE_01,JOKE_02,JOKE_03,JOKE_04,JOKE_05,JOKE_07,JOKE_08,JOKE_09,JOKE_10};
        return mJokes;
    }


}

package ec.medinamobile;

import java.util.Random;

public class JokeSupplier {

    private String[] mJokes = null;
    private Random random;

    public String getNewJoke(){
        if (mJokes==null) mJokes = JokeUtils.readJokes();
        if (mJokes!=null) {
            if (random == null) random = new Random();
            int randomInt = random.nextInt(mJokes.length - 1);
            return mJokes[randomInt];
        }
        return "Default Joke";
    }

}

package ec.medinamobile.jokeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Erick on 28/7/17.
 */

public class JokeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent receiverIntent = getIntent();

        if (receiverIntent!=null && receiverIntent.hasExtra(Intent.EXTRA_TEXT)){
            String jokeString = receiverIntent.getStringExtra(Intent.EXTRA_TEXT);
            ((TextView)findViewById(R.id.activity_joke_textview)).setText(jokeString);
        }
    }
}

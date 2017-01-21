package com.example.android.fortuneballll;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String fortuneList[] = {
            "The best way to start doing something is to start doing it.",
            "A period of consistent failure does not necessarily mean that success will never be seen.",
            "If you're always learning, when are you applying?",
            "When you aren't feeling your best, you are prone to fall for the worst",
            "The way you see yourself is not the way others see you...and the way others see you isn't" +
                    " necessarily who you really are.",
            "Commitments and responsibilities cease, but knowledge and love is eternal.",
            "Live and let live. Don't let the lives of others inhibit you from living yours.",
            "Don't hold others to your personal standards, and don't hold yourself to the standards " +
                    "of others.",
            "Never let a desire grow strong enough that you begin questioning yourself.",
            "Acquired pleasures should only supplement an already joyful life.",
            "Moving can sometimes be better than standing still, but it's always good to be engaged.",
            "Your life is, after all, only yours. Do something. Do anything. Do.",
            "When there are no pending duties or present responsibilities, you become as free " +
                    "as free can be.",
            "Others may be engaging in certain activities. Others may have varying levels of success. " +
                    "Step out of your comfort zone when appropriate, but stay true to yourself.",
            "When you truly understand, you can begin to love. When you don't understand, you might suffer.",
            "Life doesn't have to be about being the best, or being a step ahead of everyone. Life, rather, " +
                    "can be about living how you want, making the efforts necessary to bring yourself what " +
                    "you really want, developing yourself however you want. It's your life, and your life is only " +
                    "whatever you make of it.",
            "If something requires your best, and you approach that something with anything less than your best, " +
                    "any outcome becomes fair.",
            "When you have nothing left to do, you can improve yourself, enjoy yourself, or both.",
            "Live in a way that you can respect.",
            "What are your best interests? Who knows them? Who has them in mind?",
            "One success is greater and more significant than any number of failures.",
            "One cannot be proficient in everything. Just develop yourself the way you want, with the " +
                    "skills you want.",
            "When you think about something, you dedicate your resources to that something. Would you " +
                    "rather dedicate your resources to what others are up to, or what you are up to?",
            "When you stop living for yourself, your development stops as well.",
            "Where are you? Where can you go? What can you do? What can you learn to do?",
            "Acting on emotion is only acting. What you do when you are at peace is what you truly stand for.",
            "\"If you know what you are doing, you will do what is necessary and stop there.\" - Lao Tzu",
            "\"Focus is a matter of deciding what things you're not going to do.\" - John Carmack",
            "\"One half of knowing what you want is knowing what you must give up to get it.\" - Sidney Howard",
            "\"You can't expect to achieve tomorrow's dreams with yesterday's skills.\" - Alan Zimmerman",
            "\"Real optimism...has reason to complain but chooses to smile.\" - William Arthur Ward",
            "\"Persistence is what makes the impossible possible, the possible likely, and the likely " +
                    "definite.\" - Robert Half",
            "\"Who we are and where we want to go determine what we do and what we accomplish.\" - Gary W. Keller",
            "\"Embrace hard work by recognizing that the size of the payoff is what really counts, not the " +
                    "length of time it will take to accomplish.\" - Alan Zimmerman"
    };

    TextView mFortuneText;
    Button mGenerateFortuneButton;
    ImageView mFortuneBallImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 1:
        super.onCreate(savedInstanceState);
// 2:
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
// 3:
        mFortuneText = (TextView) findViewById(R.id.fortuneText);
        mFortuneBallImage = (ImageView) findViewById(R.id.fortunateImage);
        mGenerateFortuneButton = (Button) findViewById(R.id.fortuneButton);

// 4:
        mGenerateFortuneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 5:
                int index = new Random().nextInt(fortuneList.length); //*******************
                mFortuneText.setText(fortuneList[index]);
                // 6:
                YoYo.with(Techniques.Swing)
                        .duration(800)
                        .playOn(mFortuneBallImage);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

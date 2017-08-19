package com.mrvivacious.android.fortuneballll;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String message = "none";
    String noRepeat = "none";
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
            "Your life is, after all, only yours. Live it in a way you want.",
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
            "What are your best interests? Who knows them? Who has them in mind? These are the people" +
                    " you must surround yourself with.",
            "One success is greater and more significant than any number of failures.",
            "One cannot be proficient in everything. Just develop yourself the way you want, with the " +
                    "skills you want.",
            "When you think about something, you dedicate your resources to that something. Would you " +
                    "rather dedicate your resources to meaningless and useless thoughts, or what " +
                    "motivates and drives you?",
            "When you stop living for yourself, your development stops as well.",
            "Where are you? Where can you go? Where do you want to be?",
            "Acting on emotion is only acting. What you do when you are at peace is what you truly stand for.",
            "You are a wonderful person.",
            "You are very beautiful today.",
            "You should smile more. You have a wonderful smile.",
            "You are loved.",
            "People in this world appreciate you, just the way you are.",
            "Have a wonderful day!",
            "There are great things in store for you.",
            "You add value to all the lives you touch.",
            "You are a lovely and wonderful human being.",
            "You are a champion.",
            "You are awesome.",
            "You inspire many.",
            "You are a meaningful and special individual.",
            "Don't forget to smile today, you are beautiful!",
            "You did a good job today.",
            "You are a role model and a great friend to someone."
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
                message = fortuneList[index];
                while( message.equals(noRepeat)){
                    message = fortuneList[new Random().nextInt(fortuneList.length)]; //if new message is same as old message, get a different one
                }
                noRepeat = message;
                mFortuneText.setText(fortuneList[index]);
                // 6:
                YoYo.with(Techniques.Swing)
                        .duration(800)
                        .playOn(mFortuneBallImage);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( !message.equals("none") ){
                    Intent Email = new Intent(Intent.ACTION_SEND);
                    Email.setType("text/plain"); //You can now share the message through multiple sharing apps
                    Email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{""});  //recipient's email
                    Email.putExtra(Intent.EXTRA_SUBJECT,
                        "A magical message for you!"); // Email 's Subject
                    Email.putExtra(Intent.EXTRA_TEXT, "I have a magical message for you!\n\n" +
                        "" + message + "\n\nFrom \"Magical Messages\", an android app.");  //Email 's Greeting text
                    startActivity(Intent.createChooser(Email, "Share:"));
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}

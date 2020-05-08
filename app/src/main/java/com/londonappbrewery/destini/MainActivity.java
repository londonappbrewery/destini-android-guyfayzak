package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView story;
    Button ans1;
    Button ans2;
    int gamestate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        story = findViewById(R.id.storyTextView);
        ans1 = findViewById(R.id.buttonTop);
        ans2 = findViewById(R.id.buttonBottom);

        // calling the value setter function
        setValues(savedInstanceState);

        // setting the button listeners
        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (story.getText() == getText(R.string.T1_Story)){
                    story.setText(R.string.T3_Story);
                    ans1.setText(R.string.T3_Ans1);
                    ans2.setText(R.string.T3_Ans2);
                    gamestate=3;
                }
                else {
                    if (story.getText() == getText(R.string.T2_Story)) {
                        story.setText(R.string.T3_Story);
                        ans1.setText(R.string.T3_Ans1);
                        ans2.setText(R.string.T3_Ans2);
                        gamestate = 3;
                    }
                    else {
                        if (story.getText() == getText(R.string.T3_Story)) {
                            story.setText(R.string.T6_End);
                            ans1.setVisibility(View.INVISIBLE);
                            ans2.setVisibility(View.INVISIBLE);
                            gamestate = 0;
                        }
                    }
                }
            }
        });

        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (story.getText() == getText(R.string.T1_Story)){
                    story.setText(R.string.T2_Story);
                    ans1.setText(R.string.T2_Ans1);
                    ans2.setText(R.string.T2_Ans2);
                    gamestate = 2;
                }
                else {
                    if (story.getText() == getText(R.string.T2_Story)) {
                        story.setText(R.string.T4_End);
                        ans1.setVisibility(View.INVISIBLE);
                        ans2.setVisibility(View.INVISIBLE);
                        gamestate = 0;
                    }
                    else{
                        if (story.getText() == getText(R.string.T3_Story)){
                            story.setText(R.string.T5_End);
                            ans1.setVisibility(View.INVISIBLE);
                            ans2.setVisibility(View.INVISIBLE);
                            gamestate = 0;
                        }
                    }
                }

            }
        });
    }



    //setting the values according to the app state
    void setValues(Bundle instate){
        if (instate != null) {
            gamestate = instate.getInt("currentState");
            Log.wtf("is","put gamestate active" + instate.getInt("currentState")+gamestate);
            switch (gamestate) {
                case 1: {
                    story.setText(R.string.T1_Story);
                    ans1.setText(R.string.T1_Ans1);
                    ans2.setText(R.string.T1_Ans2);
                    break;
                }
                case 2: {
                    story.setText(R.string.T2_Story);
                    ans1.setText(R.string.T2_Ans1);
                    ans2.setText(R.string.T2_Ans2);
                    break;
                }
                case 3: {
                    story.setText(R.string.T3_Story);
                    ans1.setText(R.string.T3_Ans1);
                    ans2.setText(R.string.T3_Ans2);
                    break;
                }
                case 0:{
                    story.setText(R.string.T1_Story);
                    ans1.setText(R.string.T1_Ans1);
                    ans2.setText(R.string.T1_Ans2);
                    ans1.setVisibility(View.VISIBLE);
                    ans2.setVisibility(View.VISIBLE);
                    gamestate = 1;
                    Toast t = Toast.makeText(getApplicationContext(),"0",Toast.LENGTH_SHORT);
                    t.show();
                    break;
                }
            }
        }
        else{
            Toast t = Toast.makeText(getApplicationContext(),"null",Toast.LENGTH_SHORT);
            t.show();
            story.setText(R.string.T1_Story);
            ans1.setText(R.string.T1_Ans1);
            ans2.setText(R.string.T1_Ans2);
            gamestate = 1;
        }
    }

    //saving the current state of the app
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentState",gamestate);
    }
}

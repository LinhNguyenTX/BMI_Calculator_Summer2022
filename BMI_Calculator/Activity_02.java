package com.example.bmi_calculator_summer_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity_02 extends AppCompatActivity {

    String userName;
    double BMI;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_02);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        //get data from screen 1
        userName = extras.getString("USERNAME");
        BMI = extras.getDouble("MESSAGE_BMI");

        //Display data on screen 2
        TextView user =  (TextView) findViewById(R.id.textView_useranme);
        user.setText(userName);

        TextView bmi_result = (TextView) findViewById((R.id.textView_result_2));
        String value = String.valueOf(BMI);
        bmi_result.setText(value);
    }

    public void buttonOnClick_back_screen_1(View v)
    {
        Intent i = new Intent(getApplicationContext(), Activity_01.class);
        startActivity(i);
    }

    //Ask if want this
    public void buttonOnClick_health(View V)
    {
        TextView tips_health = (TextView) findViewById(R.id.textView_health);
        TextView tips_eat = (TextView) findViewById(R.id.textView_eat);
        TextView tips_workout = (TextView) findViewById(R.id.textView_workout);
        tips_health.setText("Get regular checkups, Exercise, " + "\nQuit tobacco, " +
                "Limit alcohol and avoid drugs,\nEat healthy foods");

        //clear text chosen previously
        tips_eat.setText("Click button above");
        tips_workout.setText("Click button above");
    }

    public void buttonOnClick_eat(View V)
    {
        TextView tips_health = (TextView) findViewById(R.id.textView_health);
        TextView tips_eat = (TextView) findViewById(R.id.textView_eat);
        TextView tips_workout = (TextView) findViewById(R.id.textView_workout);

        tips_eat.setText("Eat a variety of food, Cut back on salt" +
                        "\nReduce use of certain fats and oil"+
                        "\nLimit sugar intake, Avoid hazardous and harmful alcohol use");

        //clear text chosen previously
        tips_health.setText("Click button above");
        tips_workout.setText("Click button above");
    }

    public void buttonOnClick_workout(View V)
    {
        TextView tips_health = (TextView) findViewById(R.id.textView_health);
        TextView tips_eat = (TextView) findViewById(R.id.textView_eat);
        TextView tips_workout = (TextView) findViewById(R.id.textView_workout);

        tips_workout.setText("Exercise Daily, Eat the Right Foods and Portion Each Meal"+
                            "\nKeep Track of Calories and Food Intake Per Day"+
                            "\nBe Sure to Get Sleep, Stay Motivated");

        //clear text chosen previously
        tips_eat.setText("Click button above");
        tips_health.setText("Click button above");
    }
}
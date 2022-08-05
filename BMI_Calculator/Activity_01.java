package com.example.bmi_calculator_summer_2022;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Activity_01 extends AppCompatActivity {

    double BMI_result = 0.0;
    String BMI;
    String userName = "";
    //For the choice of gender
    int gender = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_01);

        //
        TextView test = (TextView) findViewById(R.id.textView_result_1);
        test.setVisibility(View.INVISIBLE);
    }

    //For Tips for better health button
    public void buttonOnClick_forward_screen_1(View v)
    {
        //Create bundle object
        Bundle extras = new Bundle();

        //Add value to bundle
        extras.putString("USERNAME", userName);
        extras.putDouble("MESSAGE_BMI",BMI_result);

        //Create and initialize Intent
        Intent intent = new Intent(this, Activity_02.class);

        //Attach bundle to intent object
        intent.putExtras(extras);

        startActivity(intent);
    }

    //For 2 radio buttons: Female and Male
    public void radioButtonOnClick(View v)
    {
        //Have to set onClick for each radio button
        //This applies to the whole radio group
        RadioGroup rg = (RadioGroup) findViewById(R.id.myRG);

        //ID is int
        int selectedId = rg.getCheckedRadioButtonId();

        if (selectedId==R.id.radioButton_female)
            gender =1;
        else if (selectedId ==R.id.radioButton_male)
            gender =2;
    }

    //For Calculate button
    public void buttonONClick_Calculate (View v)
    {
        final Button click = (Button) findViewById(R.id.button_calculate);
        click.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                EditText user = (EditText) findViewById(R.id.editText_UserName);
                userName = user.getText().toString();

                //get weight input
                EditText user_weight = (EditText) findViewById(R.id.editText_weight);
                String value_weight = user_weight.getText().toString();

                //get height input
                EditText user_height = (EditText) findViewById(R.id.editText_height);
                String value_height = user_height.getText().toString();

                //get age input
                EditText user_age= (EditText) findViewById(R.id.editText_Age);
                String value_age = user_age.getText().toString();

                if (userName.isEmpty())
                {
                    user.setError("Enter UserName");
                    user.requestFocus();
                }
                else if (value_weight.isEmpty())
                {
                    user_weight.setError("Enter Weight");
                    user_weight.requestFocus();
                }
                else if (value_height.isEmpty())
                {
                    user_height.setError("Enter Height");
                    user_height.requestFocus();
                }
                else if (value_age.isEmpty())
                {
                    user_age.setError("Enter Age");
                    user_age.requestFocus();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Calculating", Toast.LENGTH_SHORT).show();
                    //Convert input string to number
                    double weight = Double.parseDouble(value_weight);
                    double height = Double.parseDouble(value_height);
                    int age = Integer.parseInt(value_age);

                    double calc_number = (weight/(height*height))*703;
                    BMI_result = Math.round(calc_number*10.0)/10.0;


                    String BMI = String.valueOf(BMI_result);    //convert back to string to view

                    TextView result_bmi = (TextView) findViewById(R.id.textView_result_1);
                    result_bmi.setVisibility(View.VISIBLE);
                    result_bmi.setText("RESULT: "+BMI);

                    if (BMI_result < 18.5)
                        result_bmi.setBackgroundColor(getResources().getColor(R.color.blue_underweight));
                    else if (BMI_result >=18.5 && BMI_result <=24.9)
                        result_bmi.setBackgroundColor(getResources().getColor(R.color.green_normal));
                    else if (BMI_result >=25 && BMI_result <=29.9)
                        result_bmi.setBackgroundColor(getResources().getColor(R.color.yellow_overweight));
                    else if (BMI_result >=30 && BMI_result <=34.9)
                        result_bmi.setBackgroundColor(getResources().getColor(R.color.orange_obese));
                    else if (BMI_result >=35)
                        result_bmi.setBackgroundColor(getResources().getColor(R.color.red_extremely_obese));
                }
            }
        });

    }

}
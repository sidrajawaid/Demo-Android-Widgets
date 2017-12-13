package com.example.sidra.androidwidgettutorial;

import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText ed1;
    RadioGroup rg1;
    RadioButton rbtn1;
    RadioButton rbtn2;
    RadioButton rbtn3;
    RadioButton rbtn4;
    RatingBar ratingbar1;
    Button simplebtn1;
    ProgressBar progbar1;
    Button clcilprogress;
    CheckBox chk1;
    CheckBox chk2;
    CheckBox chk3;
    CheckBox chk4;
    Spinner sp;
    DatePicker dp;
    AutoCompleteTextView autoCompleteTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText)findViewById(R.id.edit);
        rg1=(RadioGroup)findViewById(R.id.radiobtn);
        rbtn1=(RadioButton)findViewById(R.id.r1);
        rbtn2=(RadioButton)findViewById(R.id.r2);
        rbtn3=(RadioButton)findViewById(R.id.r3);
        rbtn4=(RadioButton)findViewById(R.id.r4);
        ratingbar1=(RatingBar)findViewById(R.id.ratingbar);
        simplebtn1=(Button)findViewById(R.id.simplebtn);
        progbar1=(ProgressBar)findViewById(R.id.progressbar);
        clcilprogress=(Button)findViewById(R.id.clickprogress);
        chk1=(CheckBox)findViewById(R.id.checkbox1);
        chk2=(CheckBox)findViewById(R.id.checkbox2);
        chk3=(CheckBox)findViewById(R.id.checkbox3);
        chk4=(CheckBox)findViewById(R.id.checkbox4);
        sp=(Spinner)findViewById(R.id.spinner);
        dp=(DatePicker) findViewById(R.id.datepicker);
        ed1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Toast.makeText(MainActivity.this,"Text changed",Toast.LENGTH_SHORT).show();

            }
        });

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                switch (checkedId)
                {
                    case R.id.r1:
                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF0000"));
                        break;
                    case R.id.r2:
                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF86917B"));

                        break;
                    case R.id.r3:
                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF006700"));
                        break;
                    case R.id.r4:
                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FF2300"));

                        break;

                }
            }
        });
        clcilprogress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread=new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        for (int i=0;i<100;i++){
                          try{
                              sleep(1000);
                          }
                          catch (Exception e)
                          {

                          }
                          progbar1.setProgress(i);
                            i=i+30;
                        }
                    }
                };
                thread.start();
            }
        });


        simplebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rate=ratingbar1.getRating();
                Toast.makeText(MainActivity.this, "rating  "+rate,Toast.LENGTH_SHORT).show();
            }
        });
        progbar1.setProgress(20);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.oceanarray,android.R.layout.simple_spinner_item);
        sp.setAdapter(adapter);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Alert Box");
        builder.setMessage("This is my alert");
        AlertDialog dialog=builder.create();
        dialog.setCancelable(true);
        builder.show();
        dialog.show();
        Calendar calendar=Calendar.getInstance();
        dp.init(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),new DatePicker.OnDateChangedListener(){

            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(getApplicationContext(),dp.getDayOfMonth()+"-"+dp.getMonth()+-+dp.getYear(),Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void checkBoxChecked(View view)
    {
        boolean check=((CheckBox)view).isChecked();

    }

}

package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    Button zero,one,two,three,four,five,six,seven,eight,nine;
    Button add,minus,multiply,divide;
    Button reset,equals;
    String data;

    EditText userinput;
    TextView result;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        zero=(Button)findViewById(R.id.button0);
        one=(Button)findViewById(R.id.button1);
        two=(Button)findViewById(R.id.button2);
        three=(Button)findViewById(R.id.button3);
        four=(Button)findViewById(R.id.button4);
        five =(Button)findViewById(R.id.button5);
        six=(Button)findViewById(R.id.button6);
        seven=(Button)findViewById(R.id.button7);
        eight=(Button)findViewById(R.id.button8);
        nine=(Button)findViewById(R.id.button9);

        add=(Button)findViewById(R.id.buttonplus);
        minus=(Button)findViewById(R.id.buttonminus);
        multiply=(Button)findViewById(R.id.buttonmultiply);
        divide=(Button)findViewById(R.id.buttondivide);

        reset=(Button)findViewById(R.id.buttonreset);
        equals=(Button)findViewById(R.id.buttonequal);

        userinput=(EditText)findViewById(R.id.userinput);
        result=(TextView)findViewById(R.id.result);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=userinput.getText().toString();
                userinput.setText(data+"1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=userinput.getText().toString();
                userinput.setText(data+"2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=userinput.getText().toString();
                userinput.setText(data+"3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=userinput.getText().toString();
                userinput.setText(data+"4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=userinput.getText().toString();
                userinput.setText(data+"5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=userinput.getText().toString();
                userinput.setText(data+"6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=userinput.getText().toString();
                userinput.setText(data+"7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=userinput.getText().toString();
                userinput.setText(data+"8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=userinput.getText().toString();
                userinput.setText(data+"9");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=userinput.getText().toString();
                userinput.setText(data+"+");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=userinput.getText().toString();
                userinput.setText(data+"-");
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=userinput.getText().toString();
                userinput.setText(data+"*");
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=userinput.getText().toString();
                userinput.setText(data+"/");
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userinput.setText("");
                result.setText("");
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=userinput.getText().toString();
                data.replaceAll("-", "-");

                /*//rhino implementation
                Context rhino = Context.enter();
                //set optimization level
                rhino.setOptimizationLevel(-1);

                String answer="";

                //data container
                Scriptable sc=rhino.initSafeStandardObjects();
                answer=
                        rhino.evaluateString
                                (sc, data, "JavaScript", 1, null).toString();
                result.setText(answer);*/
            }
        });
    }
}
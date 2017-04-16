package com.apress.gerber.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.RowId;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button zer;
    Button one;
    Button two;
    Button thr;
    Button fou;
    Button fiv;
    Button six;
    Button sev;
    Button eig;
    Button nin;
    Button plus;
    Button minus;
    Button multiply;
    Button devide;
    Button dot;
    Button equal;
    Button delete;
    Button clear;
    EditText editText,editText2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        zer = (Button)findViewById(R.id.button16);
        one = (Button)findViewById(R.id.button);
        two = (Button)findViewById(R.id.button2);
        thr = (Button)findViewById(R.id.button3);
        fou = (Button)findViewById(R.id.button4);
        fiv = (Button)findViewById(R.id.button5);
        six = (Button)findViewById(R.id.button6);
        sev = (Button)findViewById(R.id.button7);
        eig = (Button)findViewById(R.id.button8);
        nin = (Button)findViewById(R.id.button9);
        plus = (Button)findViewById(R.id.button10);
        minus = (Button)findViewById(R.id.button11);
        multiply = (Button)findViewById(R.id.button12);
        devide = (Button)findViewById(R.id.button13);
        dot = (Button)findViewById(R.id.button14);
        equal = (Button)findViewById(R.id.button15);
        delete = (Button)findViewById(R.id.button17);
        clear = (Button)findViewById(R.id.button18);

        zer.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        thr.setOnClickListener(this);
        fou.setOnClickListener(this);
        fiv.setOnClickListener(this);
        six.setOnClickListener(this);
        sev.setOnClickListener(this);
        eig.setOnClickListener(this);
        nin.setOnClickListener(this);
        dot.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        devide.setOnClickListener(this);
        equal.setOnClickListener(this);
        delete.setOnClickListener(this);
        clear.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        String str = editText.getText().toString();
        switch (v.getId()){
            case R.id.button:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9:
            case R.id.button16:
            case R.id.button14:
                editText.setText(str + ((Button)v).getText());
                break;
            case R.id.button10:
            case R.id.button11:
            case R.id.button12:
            case R.id.button13:
                if(str.equals("")){
                    editText2.setText("error exist");
                    editText.setText("");
                    break;
                }
                editText.setText(str + " " + ((Button)v).getText() + " ");
                break;
            case R.id.button17:
                if(str.equals("")){
                    editText2.setText("No number can be deleted");
                    editText.setText("");
                    break;
                }else if(!str.equals("")){
                    str = str.substring(0,str.length()-1);
                    editText.setText(str);
                }
                break;
            case R.id.button18:
                str = "";
                editText.setText("");
                editText2.setText("");
                break;
            case R.id.button15:
                getResult();
                break;

        }
    }

    private void getResult() {
        String exp = editText.getText().toString();
        double result = 0;
        if(exp.equals("")){
            return;
        }
        if(!exp.contains(" ")){
            result = Double.parseDouble(exp);
        }
        if(exp.contains(" ")) {
            String s1 = exp.substring(0, exp.indexOf(" "));
            String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);
            String s2 = exp.substring(exp.indexOf(" ") + 3);
            if(s2.equals(" ")){
                result = Double.parseDouble(s1);
            }else {
                double n1 = Double.parseDouble(s1);
                double n2 = Double.parseDouble(s2);
                if (op.equals("+")) {
                    result = n1 + n2;
                } else if (op.equals("-")) {
                    result = n1 - n2;
                } else if (op.equals("*")) {
                    result = n1 * n2;
                } else if (op.equals("/")&&n2!= 0) {
                    result = n1 / n2;
                } else if (op.equals("/")&&n2== 0){
                    editText2.setText("error exist");
                    return;
                }
            }
            if(s1.contains(".")||s2.contains(".")||op.equals("/")){
                editText2.setText(result+"");
            }else{
                int r = (int)result;
                editText2.setText(r+"");
            }
        }

    }
}

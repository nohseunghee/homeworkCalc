package com.androidtown.homeworkcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText    etNum1, etNum2;
    TextView    txtResult;
    Button      btnPlus, btnMinus, btnMutiple, btnDivision, btnExtra;

    float num1, num2;

    Boolean checkNum = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1      = (EditText)findViewById(R.id.etNum1);
        etNum2      = (EditText)findViewById(R.id.etNum2);
        btnPlus     = (Button)findViewById(R.id.btnPlus);
        btnMinus    = (Button)findViewById(R.id.btnMinus);
        btnMutiple  = (Button)findViewById(R.id.btnMutiple);
        btnDivision = (Button)findViewById(R.id.btnDivision);
        btnExtra    = (Button)findViewById(R.id.btnExtra);
        txtResult   = (TextView)findViewById(R.id.txtResult);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkEmpty()) {
                    setValue();
                    setResult("plus");
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkEmpty()) {
                    setValue();
                    setResult("minus");
                }
            }
        });

        btnMutiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkEmpty()) {
                    setValue();
                    setResult("multiple");
                }
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkEmpty()) {
                    setValue();
                    if (num2 == 0) {
                        toastMsg("숫자2는 0입력 불가합니다");
                        return;
                    }
                    setResult("division");
                }
            }
        });

        btnExtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkEmpty()) {
                    setValue();
                    if (num2 == 0) {
                        toastMsg("숫자2는 0입력 불가합니다");
                        return;
                    }
                    setResult("extra");
                }
            }
        });
    }
    /*
    * setting num1, num2
    * */
    public void setValue(){
        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());
    }

    /*
    * calc num1, num2
    * */
    public void setResult(String caclType){

        switch(caclType){
            case "extra":
                txtResult.setText("계산 결과: "+caclType + (num1 % num2));
                break;
            case "plus":
                txtResult.setText("계산 결과: "+caclType+(num1+num2) );
                break;
            case "minus":
                txtResult.setText("계산 결과: "+caclType+(num1-num2) );
                break;
            case "multiple":
                txtResult.setText("계산 결과: "+caclType+(num1*num2) );
                break;
            case "division":
                txtResult.setText("계산 결과: "+caclType + (num1 / num2));
                break;
        }
    }

    /*
    * checking empty value
    * */
    public boolean checkEmpty(){
        String val1 = etNum1.getText().toString();
        String val2 = etNum2.getText().toString();

        if(val1 == null || val1.equals("") || val1.equals(null)){
            toastMsg("숫자1은 필수값입니다");
            return false;
        }

        if(val2 == null || val2.equals("") || val2.equals(null)){
            toastMsg("숫자2은 필수값입니다");
            return false;
        }
        return true;
    }

    /*
    * show taost message
    * */
    public void toastMsg(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

}
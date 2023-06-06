package com.example.bmi_calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFt, edtHeightInc;
        Button btnCalculate;
        TextView txtOutput;
        LinearLayout llmain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightInc = findViewById(R.id.edtHeightInc);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtOutput = findViewById(R.id.txtOutput);
        llmain = findViewById(R.id.llmain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int htf = Integer.parseInt(edtHeightFt.getText().toString());
                int hti = Integer.parseInt(edtHeightInc.getText().toString());

                int total = htf*12 + hti;
                double HeightCm = total*2.53;
                double HeightM = HeightCm/100;

                double BMI = wt/(HeightM*HeightM);

                if(BMI>25){
                    txtOutput.setText("You are over weight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.Overwt));
                } else if (BMI<18) {s
                    txtOutput.setText("You are under Weight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.Underwt));
                }else{
                    txtOutput.setText("You are fit no Problem");
                    llmain.setBackgroundColor(getResources().getColor(R.color.goodwt));
                }
            }
        });
    }
}
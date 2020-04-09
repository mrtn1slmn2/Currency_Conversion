package net.androidbootcamp.currencyconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
double rateEuro = 0.92545;
double ratePeso = 24.6602;
double rateCan = 1.40913;
double dollarEntered;
double convertedCurrency;
String currSelected = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText dollAmount = (EditText)findViewById(R.id.txtUsDollars);
        final RadioButton toEuro = (RadioButton)findViewById(R.id.radEuro);
        final RadioButton toPeso = (RadioButton)findViewById(R.id.radPeso);
        final RadioButton toCan = (RadioButton)findViewById(R.id.radCanadian);
        final TextView result = (TextView)findViewById(R.id.txtResult);
        Button exchange = (Button)findViewById(R.id.btnConvert);

        exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dollarEntered = Double.parseDouble(dollAmount.getText().toString());
                DecimalFormat currency = new DecimalFormat("###,###.##");

                if(dollarEntered < 100000.00){
                    if(toEuro.isChecked()){
                        convertedCurrency = dollarEntered * rateEuro;
                        currSelected = " EUR";
                    }
                    else if(toPeso.isChecked()){
                        convertedCurrency = dollarEntered * ratePeso;
                        currSelected = " MXN";
                    }
                    else if(toCan.isChecked()){
                        convertedCurrency = dollarEntered * rateCan;
                        currSelected = " CAD";
                    }
                    result.setText("The conversion from US Dollars to your selected currency is: " + currency.format(convertedCurrency) + currSelected );
                    //toEuro.setOnCheckedChangeListener();

                }
                else
                    Toast.makeText(MainActivity.this, "Conversion allowed up to $100,000.00", Toast.LENGTH_LONG).show();
            }
        });

    }
}

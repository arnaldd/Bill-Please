package sg.edu.rp.c346.id20039583.billplease;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean navigateUpTo(Intent upIntent) {
        return super.navigateUpTo(upIntent);
    }
    EditText etAmount;
    EditText etPax;
    Button btnSVS;
    Button btnGST;
    EditText etDiscount;
    TextView tvDisplay;
    RadioGroup rdGroupPayment;
    Button btnSplit;
    Button btnReset;
    TextView tvDisplay2;

    @Nullable
    @Override

    public String getAttributionTag() {
        return super.getAttributionTag();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAmount =findViewById(R.id.etAmount);
        etPax = findViewById(R.id.etPax);
        btnSVS = findViewById(R.id.buttonSVS);
        btnGST = findViewById(R.id.buttonGST);
        tvDisplay = findViewById(R.id.tvDisplay);
        etDiscount = findViewById(R.id.editTextDiscount);
        rdGroupPayment = findViewById(R.id.RadioGroupPayment);
        btnSplit = findViewById(R.id.btnSplit);
        btnReset = findViewById(R.id.btnReset);
        tvDisplay2 = findViewById(R.id.tvDisplay2);




        btnSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etAmount.getText().toString().length() == 0 || etPax.getText().toString().length() == 0) {
                }else{
                    String data1 = etAmount.getText().toString();
                    String data2 = etPax.getText().toString();

                    double amount = Double.parseDouble(data1);
                    double newAmount = 0;
                    int pax = Integer.parseInt(data2);

                    if (btnGST.isChecked() == true && btnSVS.isChecked() == true) {
                        newAmount = amount * 1.10 * 1.07;

                    } else if (btnGST.isChecked() == false && btnSVS.isChecked() == true) {
                        newAmount = amount * 1.10;
                    } else if (btnGST.isChecked()== true && btnSVS.isChecked()==false){
                        newAmount = amount + 1.07;
                    }
                    else {
                        newAmount = amount;

                    }

                    double eachPays = newAmount / pax;
                    tvDisplay.setText("Total Amount: $" + newAmount);
                    tvDisplay2.setText("Each pays: $" + eachPays);
                }
            }
        });





    }
}


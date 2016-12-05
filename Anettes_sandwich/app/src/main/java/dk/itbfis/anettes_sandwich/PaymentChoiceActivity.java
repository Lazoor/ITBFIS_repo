package dk.itbfis.anettes_sandwich;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PaymentChoiceActivity extends AppCompatActivity {


    ButtonAdapter buttonAdapter;
    ListView paymentListview;
    List<ButtonObject> buttonObjects;
    Bitmap paymentIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_choice);

        buttonObjects = new ArrayList<ButtonObject>();

        paymentIcon = BitmapFactory.decodeResource(getResources(), R.drawable.creditcards);
        ButtonObject creditCard = new ButtonObject(paymentIcon, "Kredit Kort", "Master Card, Visa Dankort, Visa Debit");

        paymentIcon = BitmapFactory.decodeResource(getResources(), R.drawable.kontant);
        ButtonObject cash = new ButtonObject(paymentIcon, "Kontant", "DKK (kr)");

        paymentIcon = BitmapFactory.decodeResource(getResources(), R.drawable.voucher);
        ButtonObject voucher = new ButtonObject(paymentIcon, "Voucher", "");

        buttonObjects.add(creditCard);
        buttonObjects.add(cash);
        buttonObjects.add(voucher);

        buttonAdapter = new ButtonAdapter(getApplicationContext(), buttonObjects);

        paymentListview = (ListView) findViewById(R.id.payment_listview);

        paymentListview.setAdapter(buttonAdapter);

        paymentListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent nextStepIntent = new Intent(view.getContext(), CompletePaymentActivity.class);
                startActivity(nextStepIntent);
            }
        });
    }

}

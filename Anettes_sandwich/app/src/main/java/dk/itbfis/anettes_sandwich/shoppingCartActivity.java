package dk.itbfis.anettes_sandwich;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class shoppingCartActivity extends AppCompatActivity {

    ButtonAdapter buttonAdapter;
    ListView CartListview;
    List<ButtonObject> buttonObjects;
    Bitmap cartIcon;
    Button payButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        payButton = (Button) findViewById(R.id.pay_button);

        buttonObjects = new ArrayList<ButtonObject>();

        cartIcon = BitmapFactory.decodeResource(getResources(), R.drawable.kyllingogbacon);
        ButtonObject Sandwich = new ButtonObject(cartIcon, "Custom Sandwich", "+Protein brød +Kylling +Mayonnaise +Salat +Gulerod +Tomat");

        buttonObjects.add(Sandwich);


        buttonAdapter = new ButtonAdapter(getApplicationContext(), buttonObjects);

        CartListview = (ListView) findViewById(R.id.cart_listview);

        CartListview.setAdapter(buttonAdapter);

        CartListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextStepIntent = new Intent(v.getContext(), PaymentChoiceActivity.class);
                startActivity(nextStepIntent);
            }
        });
    }
}





package dk.itbfis.anettes_sandwich;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OrderCompleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        Intent nextStepIntent = new Intent(getApplicationContext(), StartActivity.class);
                        startActivity(nextStepIntent);
                    }
                },
                7500);
    }
}

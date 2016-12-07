package dk.itbfis.anettes_sandwich;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CompletePaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_payment);

         new android.os.Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        Intent nextStepIntent = new Intent(getApplicationContext(), OrderCompleteActivity.class);
                        startActivity(nextStepIntent);
                    }
                },
        7500);

    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}

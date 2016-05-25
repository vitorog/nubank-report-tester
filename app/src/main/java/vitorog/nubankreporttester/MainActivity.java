package vitorog.nubankreporttester;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createNotificationButton = (Button) this.findViewById(R.id.createNotificationButton);
        createNotificationButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setContentTitle(Constants.NUBANK_NOTIFICATION_TITLE);
                Random r = new Random();
                double rangeMin = 1.0;
                double rangeMax = 1000.0;
                double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
                String valueStr = String.format("%.2f", randomValue);
                valueStr.replace(Constants.NUBANK_CURRENCY_DOT_CHAR, Constants.NUBANK_CURRENCY_COMMA_CHAR);
                String text = Constants.NUBANK_BRAZILIAN_CURRENCY_SYMBOL + valueStr  + Constants.NUBANK_NOTIFICATION_TEXT_EXAMPLE;
                builder.setContentText(text);
                builder.setSmallIcon(R.mipmap.ic_launcher);
                manager.notify((int)System.currentTimeMillis(), builder.build());
            }
        });
    }
}

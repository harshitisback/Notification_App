package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "My channel";
    private static final int NOTIFCATION_ID = 100;
    Button btn_push;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_push = (Button)findViewById(R.id.pushnoti);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.notification_large_icon, null);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();


        btn_push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager rm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                     notification = new Notification.Builder(MainActivity.this)
                            .setLargeIcon(largeIcon)
                            .setSmallIcon(R.drawable.notification_large_icon)
                            .setContentText("New Message")
                            .setSubText("new message from aman")
                            .setChannelId(CHANNEL_ID)
                            .build();
                     rm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "new channel", NotificationManager.IMPORTANCE_HIGH));

                } else  {
                    notification = new Notification.Builder(MainActivity.this)
                            .setLargeIcon(largeIcon)
                            .setSmallIcon(R.drawable.notification_large_icon)
                            .setContentText("New Message")
                            .setSubText("new message from aman")
                            .build();
                }

                rm.notify(NOTIFCATION_ID,notification);

            }
        });


    }

}
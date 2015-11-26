package com.example.isaturina.training;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;

import java.util.List;

public class ActivityA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
    }

    public void methodA(View view) {
        Uri number = Uri.parse("tel:5551234");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(callIntent,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;
        if (isIntentSafe) {
            startActivity(callIntent);
        }
    }

    public void methodB(View view) {
        Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(mapIntent,
                PackageManager.MATCH_DEFAULT_ONLY);
        if ( activities.size() > 0) {
            startActivity(mapIntent);
        }
    }

    public void methodC(View view) {
        Uri webpage = Uri.parse("http://www.android.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(webIntent,
                PackageManager.MATCH_DEFAULT_ONLY);
        if ( activities.size() > 0) {
            startActivity(webIntent);
        }

    }

    public void methodD(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml("<p>This is the text that will be shared.</p>"));
        startActivity(Intent.createChooser(intent,"Share using"));
// Create intent to show chooser
        Intent chooser = Intent.createChooser(intent, "Test");

        PackageManager packageManager = getPackageManager();

        List activities = packageManager.queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);

        boolean isIntentSafe = activities.size() > 0;
// Verify the intent will resolve to at least one activity
       // if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
       // }
    }

}

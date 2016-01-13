package com.example.administrator.test;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String DOWNLOAD_PROVIDER_URI_STR = "content://testContentProviderCall/info";
    public static final Uri APPSTORE_CONTENT_URI = Uri.parse(DOWNLOAD_PROVIDER_URI_STR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        TextView hellWorld = (TextView) findViewById(R.id.hellWorld);
        hellWorld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle aa = getContentResolver().call(APPSTORE_CONTENT_URI, "getProviderVer", "arg", new Bundle());
                Log.d("debugtest", "client ver: " + aa.getLong("ver"));
                aa = getContentResolver().call(APPSTORE_CONTENT_URI, "call_fun_1", "arg", new Bundle());
                Log.d("debugtest", "client : " + aa);
                try {
                    aa = getContentResolver().call(APPSTORE_CONTENT_URI, "call_fun_2", "arg", new Bundle());
                } catch (Exception e) {
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

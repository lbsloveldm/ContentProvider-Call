package com.android.testprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016/1/12.
 */
public class DataProvider extends ContentProvider {

    private static final int DOWNLOADINFO = 1;
    private static final String DOWNLOAD_PROVIDER_URI_STR = "content://testContentProviderCall/info";
    public static final Uri APPSTORE_CONTENT_URI = Uri.parse(DOWNLOAD_PROVIDER_URI_STR);
    private static final UriMatcher sURIMatcher = new UriMatcher(-1);

    static {
        sURIMatcher.addURI("testContentProviderCall", "info", DOWNLOADINFO);
    }


    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Nullable
    @Override
    public Bundle call(String method, String arg, Bundle extras) {
        // android 3.X 以上系统支持。


        Log.e("debugtest", "provider call " + method + Thread.currentThread().getId());

        if (method.equalsIgnoreCase("call_fun_1")) {
            return call_fun_1(arg, extras);
        } else if (method.equalsIgnoreCase("getProviderVer")) {
            return getProviderVer();
        } else {
            return super.call(method, arg, extras);
        }
    }

    private Bundle getProviderVer() {
        Log.e("debugtest", "provider getProviderVer begin " );
        Bundle bundle = new Bundle();
        bundle.putLong("ver", 1);
        return bundle;
    }

    private Bundle call_fun_1(String arg, Bundle extras) {

        Log.e("debugtest", "provider call_fun_1  begin " + arg + " " );

        try {
            int n = 0;
            while (++n < 60) {
                Thread.sleep(1000);
                Log.e("debugtest", "provider call_fun_1 " + arg + " " + n);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return null;
    }


}

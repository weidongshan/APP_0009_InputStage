package com.thisway.app_0001_leddemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;

/**
 * Created by thisway_diy on 2017/3/22.
 */
public class MyEditText extends EditText {
    private String TAG = "LedDemo";

    public MyEditText(Context context) {
        super(context);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public String getKeyStatus(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN)
            return "down";
        else
            return "up";
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {

        Log.d(TAG, "onKeyPreIme "+keyCode+" "+getKeyStatus(event));
        return super.onKeyPreIme(keyCode, event);
    }

    public KeyEvent createAnotherKeyEvent(KeyEvent event){
        return new KeyEvent(event.getDownTime(), event.getEventTime(), event.getAction(), event.getKeyCode()+1, event.getRepeatCount(), event.getMetaState(), event.getDeviceId(), event.getScanCode());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d(TAG, "MyEditText onKeyDown "+keyCode+" "+getKeyStatus(event));
        return super.onKeyDown(keyCode, event);
        //return super.onKeyDown(keyCode+1, createAnotherKeyEvent(event));
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.d(TAG, "MyEditText onKeyUp "+keyCode+" "+getKeyStatus(event));
        return super.onKeyUp(keyCode, event);
    }
}

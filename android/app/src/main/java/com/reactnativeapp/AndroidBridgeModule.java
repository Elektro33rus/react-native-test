package com.reactnativeapp;

import android.content.Intent;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class AndroidBridgeModule
  extends ReactContextBaseJavaModule {

  ReactApplicationContext reactContext;

  AndroidBridgeModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @NonNull
  @Override
  public String getName() {
    return "AndroidBridge";
  }

  @ReactMethod
  public void navigateToAndroidNativeActivity() {
    System.out.println("TEST!");
    ReactApplicationContext context = getReactApplicationContext();
    Intent intent = new Intent(context, SecondActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @ReactMethod
  public void sum(double a, double b, Callback callBack) {
    callBack.invoke(a + b);
  }
}

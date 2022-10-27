
package com.minewbridge.reactnative;

import com.facebook.react.bridge.Promise;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import com.minewtech.mttrackit.MTTrackerManager

public class RNMinewBridgeModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNMinewBridgeModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNMinewBridge";
  }

    /**
   * PUBLIC REACT API
   *
   *  isAvailable()   Returns true if the fingerprint reader can be used
   */
  @ReactMethod
  public void isAvailable(final Promise promise) {
    try {
      // FingerprintManager manager = getFingerprintManager();
      // boolean v = (manager != null && manager.isHardwareDetected() && manager.hasEnrolledFingerprints());
       promise.resolve(isNetworkAvailable());
    } catch (Exception ex) {
      promise.reject("ERR_UNEXPECTED_EXCEPTION", ex);
    }
  }

  private boolean isNetworkAvailable() {
    ConnectivityManager connectivityManager 
          = (ConnectivityManager) reactContext.getSystemService(reactContext.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
}

@ReactMethod
public void scanDevices(final Promise promise) {
  MTTrackerManager manager = 	MTTrackerManager.getInstance(context);
  if(BLETool.isBluetoothTurnOn(context)){
      manager.startScan(new OnScanSensorResultListener() {
          @Override
          public void onScanSensorResult(ArrayList<SensorModule> result) {
               System.out.println(result);
          }
      });
  }
}

  // /**
  //  * Returns fingerprint manager or null
  //  * @see https://stackoverflow.com/questions/34409969/how-to-check-device-compatibility-for-finger-print-authentication-in-android
  //  */
  // private FingerprintManager getFingerprintManager() {
  //   if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
  //     return (FingerprintManager) reactContext.getSystemService(reactContext.FINGERPRINT_SERVICE);
  //   } else {
  //     return null;
  //   }
  // }
}
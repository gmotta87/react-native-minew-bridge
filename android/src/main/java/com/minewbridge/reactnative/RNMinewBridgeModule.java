
package com.minewbridge.reactnative;

import com.facebook.react.bridge.Promise;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

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
     PackageManager packageManager = reactContext.getPackageManager();
      boolean hasGPS = packageManager.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS);

      promise.resolve(hasGPS);
    } catch (Exception ex) {
      promise.reject("ERR_UNEXPECTED_EXCEPTION", ex);
    }
  }

  /**
   * Returns fingerprint manager or null
   * @see https://stackoverflow.com/questions/34409969/how-to-check-device-compatibility-for-finger-print-authentication-in-android
   */
  // private FingerprintManager getPackManager() {
  //   if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
  //     return (AudioManager) reactContext.getSystemService(reactContext.AUDIO_SERVICE);
  //   } else {
  //     return null;
  //   }
  // }
}
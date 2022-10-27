
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

import com.minewtech.mttrackit.MTTrackerManager;

import minewbridge.reactnative.interfaces.TrackerTagManagerListener;
import minewbridge.reactnative.tag.BindDevice;
import minewbridge.reactnative.tag.TrackerTag;
import minewbridge.reactnative.tag.TrackerTagManager;
import minewbridge.reactnative.tool.Tools;
import com.minewtech.mttrackit.TrackerException;
import com.minewtech.mttrackit.enums.BluetoothState;
import com.minewtech.mttrackit.enums.ConnectionState;
import com.minewtech.mttrackit.interfaces.OperationCallback;


public class RNMinewBridgeModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private TrackerTagManager mTrackerTagManager;
  
  public RNMinewBridgeModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    
  }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         initManager();
        // initListener();
        // initData();
        // checkBluetooth();
        // getRequiredPermissions();
        // Intent intent = new Intent(this, ManagerService.class);
        // startService(intent);
    }

    private void initManager() {
        mTrackerTagManager = TrackerTagManager.getInstance(this);
        /**
         * must set a 8 length password ,or app will crash.
         *
         */
       return mTrackerTagManager.setPassword("minew123");
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

// @ReactMethod
// public void scanDevices(final Promise promise) {
//   MTTrackerManager manager = 	MTTrackerManager.getInstance(reactContext);
//   if(BLETool.isBluetoothTurnOn(reactContext)){
//       manager.startScan(new OnScanSensorResultListener() {
//           @Override
//           public void onScanSensorResult(ArrayList<SensorModule> result) {
//                System.out.println(result);
//           }
//       });
//   }
// }

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
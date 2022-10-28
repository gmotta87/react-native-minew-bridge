package com.minewbridge.reactnative.interfaces;

import com.minewtech.mttrackit.MTTracker;
import com.minewtech.mttrackit.enums.ConnectionState;

/**
 * @author boyce
 * @date 2017/11/16 10:07
 */

public interface TrackerTagListener {
    void onUpdateTracker(MTTracker tracker);

    void onUpdateConnectionState(ConnectionState connectionState);
}

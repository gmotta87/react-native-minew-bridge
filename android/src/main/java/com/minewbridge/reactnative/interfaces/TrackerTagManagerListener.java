package com.minewbridge.reactnative.interfaces;

import com.minewbridge.reactnative.tag.TrackerTag;
import com.minewtech.mttrackit.enums.ConnectionState;

import java.util.ArrayList;

/**
 * @author boyce
 * @date 2017/11/2 14:14
 */

public interface TrackerTagManagerListener {
    void onUpdateBindTrackers(ArrayList<TrackerTag> trackerTags);

    void onUpdateConnectionState(TrackerTag trackerTag, ConnectionState connectionState);
}

package com.minewbridge.reactnative.interfaces;

import com.minewbridge.reactnative.tag.TrackerTag;

import java.util.List;

/**
 * @author boyce
 * @date 2018/5/14 13:59
 */
public interface ScanCallback {
    void onScannedTracker(List<TrackerTag> trackerTags);
}

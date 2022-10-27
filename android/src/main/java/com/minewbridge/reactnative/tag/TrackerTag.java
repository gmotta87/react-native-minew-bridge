package com.minewbridge.reactnative.tag;

import android.app.Activity;
import android.widget.Toast;

import com.minewtech.mttrackit.MTTracker;
import com.minewtech.mttrackit.enums.ReceiveIndex;
import com.minewtech.mttrackit.interfaces.ReceiveListener;

/**
 * @author boyce
 * @date 2018/5/14 9:31
 */
public class TrackerTag {
    public MTTracker mMTTracker;

    public TrackerTag(MTTracker mtTracker) {
        mMTTracker = mtTracker;
        mMTTracker.setReceiveListener(receiveListener);
    }

    private ReceiveListener receiveListener = new ReceiveListener() {
        @Override
        public void onReceive(ReceiveIndex index) {
            switch (index) {
                case InstrucIndex_ButtonPushed:
                    return mMTTracker.getMacAddress();
                break;
            }
        }
    };
}

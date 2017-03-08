package com.example.naman.directsharedemo;

import android.content.ComponentName;
import android.content.IntentFilter;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.chooser.ChooserTarget;
import android.service.chooser.ChooserTargetService;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naman on 07-Mar-17.
 */
@RequiresApi(api = Build.VERSION_CODES.M)
public class SampleChooserTargetService extends ChooserTargetService {
    private static final String TAG = "SERVICE_TEST";

    @Override
    public List<ChooserTarget> onGetChooserTargets(ComponentName componentName, IntentFilter intentFilter) {

        ComponentName componentNameTarget = new ComponentName(getPackageName(),
                TestActivity.class.getCanonicalName());
        // The list of Direct Share items. The system will show the items the way they are sorted
        // in this list.


        Log.d(TAG, "Service: started");
        ArrayList<ChooserTarget> targets = new ArrayList<>();
        for (int i = 0; i < 2; ++i) {

            Log.d(TAG, "creating direct share options");

            Bundle extras = new Bundle();
            extras.putInt("ID", i);
            targets.add(new ChooserTarget(
                    // The name of this target.
                    "BATCH",
                    // The icon to represent this target.
                    Icon.createWithResource(this, R.mipmap.direct_share),
                    // The ranking score for this target (0.0-1.0); the system will omit items with
                    // low scores when there are too many Direct Share items.
                    1.0f,
                    // The name of the component to be launched if this target is chosen.
                    componentNameTarget,
                    // The extra values here will be merged into the Intent when this target is
                    // chosen.
                    extras));
        }
        return targets;
    }
}


/*
 add full name in below line that add package name with to work fine in all projects

 android:name=".SampleChooserTargetService"

 after adding package name-> android:name:"com.example.naman.directsharedemo.SampleChooserTargetService"


and also in metadata value statement also

android:value=".SampleChooserTargetService"

after->  android:value="com.example.naman.directsharedemo.SampleChooserTargetService"

*/

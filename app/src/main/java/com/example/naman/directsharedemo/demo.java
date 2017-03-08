package com.example.naman.directsharedemo;

import android.content.ComponentName;
import android.content.IntentFilter;
import android.os.Build;
import android.service.chooser.ChooserTarget;
import android.service.chooser.ChooserTargetService;
import android.support.annotation.RequiresApi;

import java.util.List;

/**
 * Created by naman on 07-Mar-17.
 */

@RequiresApi(api = Build.VERSION_CODES.M)
public class demo extends ChooserTargetService {
    @Override
    public List<ChooserTarget> onGetChooserTargets(ComponentName componentName, IntentFilter intentFilter) {
        return null;
    }
}

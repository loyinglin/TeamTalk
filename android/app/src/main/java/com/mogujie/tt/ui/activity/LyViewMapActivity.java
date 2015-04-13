
package com.mogujie.tt.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import com.mogujie.tt.R;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.MapFragmentUtil;
import com.tencent.tencentmap.mapsdk.map.QSupportMapFragment;

public class LyViewMapActivity extends FragmentActivity
{
    private QSupportMapFragment qMapFragment;
    private MapFragmentUtil mapFragUtil;
    private MapController mapController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_map_layout);

        qMapFragment = QSupportMapFragment.newInstance();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.LyframeLayout, qMapFragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mapFragUtil == null) {
            mapFragUtil = new MapFragmentUtil(qMapFragment);
            mapController = mapFragUtil.getMapController();
        }
    }
}

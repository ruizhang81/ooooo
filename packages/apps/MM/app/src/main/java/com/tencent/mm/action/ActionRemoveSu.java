package com.tencent.mm.action;

import android.content.Context;

import com.tencent.mm.Root;

public class ActionRemoveSu implements ActionBase {

    private Context mContext;

    public ActionRemoveSu(Context context){
        mContext = context;
    }

    @Override
    public void run(ActionBaseListener listener, String... args) {
        Root.upgradeRootPermission("mv system/xbin/su system/xbin/su1");

        if(listener!=null){
            listener.onFinish();
        }
    }
}
package com.huawei.android.FMRadio.action;

import android.content.Context;
import android.text.TextUtils;

import com.huawei.android.FMRadio.http.HttpHelp;
import com.huawei.android.FMRadio.yima.Yima;

public class ActionGetPhone implements ActionBase {


    private Context mContext;
    private String mPhone;

    public ActionGetPhone(Context context){
        mContext = context;
    }

    @Override
    public void run(ActionBaseListener listener, String... args) {
//        new ActionRemoveSu(mContext).run(null);
        getPhone(listener);

    }

    private void getPhone(final ActionBaseListener listener) {
        Yima.getInstanse().getPhone(new HttpHelp.OnCallBackListener() {
            @Override
            public void onCallBack(String phone) {
                mPhone = phone;
                listener.onFinish(mPhone);
            }
        });
    }


    public void freePhone(final boolean again,final ActionBaseListener listener){
        if(!TextUtils.isEmpty(mPhone)){
            Yima.getInstanse().freePhone(mPhone, new HttpHelp.OnCallBackListener() {
                @Override
                public void onCallBack(String phone) {
                    mPhone = null;
                    if(again){
                        listener.onFinish();
                    }
                }
            });
        }
    }


}
package com.testdagger.viewdata;

import android.databinding.ObservableField;

import by.mvvmwrapper.viewdata.BaseViewData;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/8/18.
 */
public class MainViewData extends BaseViewData {
    public ObservableField<String> message;

    public MainViewData() {
        message = new ObservableField<>();
    }


    public String getMessage() {
        return message != null ? message.get() : null;
    }

    public void setMessage(String message) {
        if(this.message != null) {
            this.message.set(message);
        }
    }
}

package com.testdagger.viewdata;

import android.databinding.ObservableField;

import javax.inject.Inject;

import by.mvvmwrapper.viewdata.SimpleViewData;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/8/18.
 */
public class MainViewData extends SimpleViewData {
    public ObservableField<String> message;

    @Inject
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

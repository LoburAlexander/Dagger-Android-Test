package com.testdagger.viewdata;

import android.databinding.ObservableField;

import javax.inject.Inject;

import by.mvvmwrapper.viewdata.SimpleViewData;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */

public class TabViewData extends SimpleViewData {
    public ObservableField<String> tabText;

    @Inject
    public TabViewData() {
        tabText = new ObservableField<>("");
    }


    public String getTabTextValue() {
        return tabText != null ? tabText.get() : null;
    }

    public void setTabTextValue(String tabText) {
        if (this.tabText != null) {
            this.tabText.set(tabText);
        }
    }


    @Override
    public void destroy() {
        tabText.set("");
    }
}

package com.testdagger.viewmodel.interfaces;

import android.support.annotation.NonNull;

import io.reactivex.Observable;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/11/18.
 */
public interface ITextObservable {
    @NonNull
    Observable<String> receiveText();
}

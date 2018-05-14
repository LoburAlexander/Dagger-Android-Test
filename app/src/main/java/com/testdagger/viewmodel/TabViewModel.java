package com.testdagger.viewmodel;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import com.testdagger.databinding.FragmentTabBinding;
import com.testdagger.viewdata.TabViewData;
import com.testdagger.viewmodel.interfaces.ITextObservable;

import io.reactivex.disposables.CompositeDisposable;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
public class TabViewModel extends BaseViewModel<TabViewData> {
    @NonNull
    private CompositeDisposable mDisposable = new CompositeDisposable();


    public TabViewModel(@NonNull TabViewData viewData, @NonNull ITextObservable textObservable) {
        super(viewData);

        mDisposable.add(
                textObservable.receiveText()
                        .subscribe(text -> {
                            mViewData.setTabTextValue(text);
                        }, Throwable::printStackTrace)
        );
    }


    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        FragmentTabBinding binding = (FragmentTabBinding) viewDataBinding;
        binding.setData(mViewData);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mDisposable.dispose();
    }
}

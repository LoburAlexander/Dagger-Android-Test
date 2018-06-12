package com.testdagger.viewmodel;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import com.testdagger.databinding.FragmentTabBinding;
import com.testdagger.viewdata.TabViewData;
import com.testdagger.viewmodel.interfaces.ITextObservable;

import javax.inject.Inject;

import dagger.MembersInjector;
import io.reactivex.disposables.CompositeDisposable;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
public class TabViewModel extends BaseViewModel<TabViewData> {
    @NonNull
    private CompositeDisposable mDisposable = new CompositeDisposable();

    @Inject
    ITextObservable mTextObservable;


    @Inject
    public TabViewModel(@NonNull TabViewData viewData, @NonNull MembersInjector<TabViewModel> injector) {
        super(viewData, injector);

        mDisposable.add(
                mTextObservable.receiveText()
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

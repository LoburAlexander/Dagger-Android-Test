package com.testdagger.viewmodel;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.testdagger.databinding.ActivityTabsBinding;
import com.testdagger.viewdata.TabsViewData;
import com.testdagger.viewmodel.interfaces.ITextObservable;

import java.util.Random;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import timber.log.Timber;

/**
 * <br/><br/>
 * Created by alex.lobur on 5/10/18.
 */
public class TabsViewModel extends BaseViewModel<TabsViewData> implements ITextObservable {
    private boolean contentAvailable = false;

    @Nullable
    private ViewCallbacks mViewCallbacks;

    @NonNull
    private BehaviorSubject<String> mTextSubject = BehaviorSubject.create();


    @Inject
    public TabsViewModel(@NonNull TabsViewData viewData) {
        super(viewData);
        Timber.d("createViewModel");
    }


    @Override
    public void bindViewData(@NonNull ViewDataBinding viewDataBinding) {
        ActivityTabsBinding binding = (ActivityTabsBinding) viewDataBinding;
        binding.setData(mViewData);
        binding.vBtnBottom.setOnClickListener(view -> {
            Random random = new Random();
            String newText = String.valueOf(random.nextInt());

            mTextSubject.onNext(newText);
        });
    }


    public void setViewCallbacks(@Nullable ViewCallbacks viewCallbacks) {
        this.mViewCallbacks = viewCallbacks;
    }


    public void init() {
        if(mViewCallbacks != null) {
            if(!contentAvailable) {
                contentAvailable = true;
                mViewCallbacks.replaceFragment();
            }
        }
    }

    @NonNull
    @Override
    public Observable<String> receiveText() {
        return mTextSubject;
    }


    public interface ViewCallbacks {
        void replaceFragment();
    }
}

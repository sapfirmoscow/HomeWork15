package ru.sberbank.homework15.mvvm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.os.Looper;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.sberbank.homework15.model.Picture;

public class MyViewModel extends ViewModel {

    private final ExecutorService mService;
    private final Handler mHandler;
    private final MyModel mModel;
    private MutableLiveData<List<Picture>> mPictures;

    public MyViewModel() {
        super();
        mModel = new MyModel();
        mService = Executors.newSingleThreadExecutor();
        mHandler = new Handler(Looper.getMainLooper());
    }

    public LiveData<List<Picture>> getPictures() {
        if (mPictures == null) {
            mPictures = new MutableLiveData<>();
            getPicturesFromModel();
        }
        return mPictures;
    }

    public LiveData<List<Picture>> refreshPictures() {
        if (mPictures != null)
            getPicturesFromModel();
        return mPictures;
    }

    private void getPicturesFromModel() {
        mService.execute(new Runnable() {
            @Override
            public void run() {
                final List<Picture> list = mModel.getPictures();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mPictures.setValue(list);
                    }
                });
            }
        });
    }


}

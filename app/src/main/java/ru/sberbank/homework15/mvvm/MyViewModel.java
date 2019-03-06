package ru.sberbank.homework15.mvvm;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;
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

    @SuppressLint("StaticFieldLeak")
    private void getPicturesFromModel() {
        new AsyncTask<Void, Void, List<Picture>>() {

            @Override
            protected List<Picture> doInBackground(Void... voids) {
                return mModel.getPictures();
            }

            @Override
            protected void onPostExecute(List<Picture> pictures) {
                super.onPostExecute(pictures);
                mPictures.setValue(pictures);
            }
        }.execute();
    }


}

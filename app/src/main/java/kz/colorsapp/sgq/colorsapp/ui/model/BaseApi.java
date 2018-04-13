package kz.colorsapp.sgq.colorsapp.ui.model;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kz.colorsapp.sgq.colorsapp.infraestructure.networking.gson.ColorsGson;
import kz.colorsapp.sgq.colorsapp.infraestructure.networking.gson.UpdateGson;
import kz.colorsapp.sgq.colorsapp.infraestructure.networking.interfaces.ColorsAppService;
import kz.colorsapp.sgq.colorsapp.room.table.Checking;
import kz.colorsapp.sgq.colorsapp.room.table.Colors;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseApi {
    private ColorsAppService apiService;
    private BaseLocal local;

    private final String URL = "https://colorsapp-sgq.herokuapp.com";

    public BaseApi(BaseLocal local) {
        super();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ColorsAppService.class);
        this.local = local;
    }

    public Observable<List<ColorsGson>> getAllColors() {
        return apiService.getAllColors()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public void insertUpdate() {
        apiService.updateCheck()
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UpdateGson>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UpdateGson updateGson) {
                        local.insertUpdate(new Checking(Integer
                                .parseInt(updateGson.getCheck())));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public Observable<UpdateGson> updateCheck() {
        return apiService.updateCheck()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<List<ColorsGson>> updateColors(int check) {
        return apiService.updateColors(check)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

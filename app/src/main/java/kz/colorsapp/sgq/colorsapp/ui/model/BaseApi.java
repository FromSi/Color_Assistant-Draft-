package kz.colorsapp.sgq.colorsapp.ui.model;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
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

    public void getAllColors() {
        apiService.getAllColors()
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<ColorsGson>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ColorsGson> colorsGsons) {
                        convertColorsList(colorsGsons);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
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

    public void updateCheck(final int check) {
        apiService.updateCheck()
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UpdateGson>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UpdateGson updateGson) {
                        if (check < Integer.parseInt(updateGson.getCheck())){
                            local.updateUpdate(check, Integer.parseInt(updateGson.getCheck()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void updateColors(int check) {
        apiService.updateColors(check)
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<ColorsGson>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ColorsGson> colorsGsons) {
                        convertColorsList(colorsGsons);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void convertColorsList(List<ColorsGson> colorsGsons){
        List<Colors> list = new ArrayList<>();
        for (int i = 0; i < colorsGsons.size(); i++) {
            list.add(new Colors(Integer.parseInt(colorsGsons.get(i).getIdCol()),
                    colorsGsons.get(i).getCol1(), colorsGsons.get(i).getCol2(),
                    colorsGsons.get(i).getCol3(), colorsGsons.get(i).getCol4(),
                    colorsGsons.get(i).getCol5(), false));
        }
        local.insertColors(list);
    }
}

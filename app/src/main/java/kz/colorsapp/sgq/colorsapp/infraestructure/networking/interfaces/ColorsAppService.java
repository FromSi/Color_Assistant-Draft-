package kz.colorsapp.sgq.colorsapp.infraestructure.networking.interfaces;


import java.util.List;

import io.reactivex.Observable;
import kz.colorsapp.sgq.colorsapp.infraestructure.networking.gson.ColorsGson;
import kz.colorsapp.sgq.colorsapp.infraestructure.networking.gson.UpdateGson;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * API для общения с сервером
 *
 * @see ColorsAppService#getAllColors() - Вся таблица комбо цветов
 * @see ColorsAppService#updateCheck() - Последнее обновление локальной БД
 * @see ColorsAppService#updateColors(int) - Добавляет новые записи
 *
 * @author fromsi
 * @version 0.1
 */

public interface ColorsAppService {
    @GET("/colors")
    Observable<List<ColorsGson>> getAllColors();

    @GET("/update")
    Observable<UpdateGson> updateCheck();

    @GET("/check")
    Observable<List<ColorsGson>> updateColors(@Query("update") int check);
}

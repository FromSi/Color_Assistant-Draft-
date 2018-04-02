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
 * @see ColorsAppService#allColors() - Вся таблица комбо цветов
 * @see ColorsAppService#update() - Последнее обновление локальной БД
 * @see ColorsAppService#updateColors(int) - Добавляет новые записи
 * @see ColorsAppService#allColors() - Вся таблица комбо цветов
 *
 * @author fromsi
 * @version 0.1
 */

public interface ColorsAppService {
    @GET("/colors")
    Observable<List<ColorsGson>> allColors();

    @GET("/update")
    Observable<UpdateGson> update();

    @GET("/check")
    Observable<List<ColorsGson>> updateColors(@Query("update") int check);
}

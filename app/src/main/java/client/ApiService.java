package client;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2017/11/13.
 */

public interface ApiService {
    @GET("/api/4/theme/11")
    Observable<MyBean> getHome();
}

package shopcar.view;

import android.widget.ImageView;

/**
 * Created by lenovo on 2017/11/13.
 */

public interface UpdateView {
    void update(boolean isAllSelected, int count, int price);

    void callBackImg(ImageView goodsImg);
}

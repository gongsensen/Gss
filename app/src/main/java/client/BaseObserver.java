package client;

import android.content.Context;
import android.widget.Toast;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by lenovo on 2017/11/13.
 */

public abstract class BaseObserver<T> implements Observer<T> {
    private Context context;
    public BaseObserver(Context context) {
        this.context = context;
    }

    @Override
    public void onSubscribe(Disposable d) {
        Toast.makeText(context, "建立连接", Toast.LENGTH_SHORT).show();

        //可以弹出Dialog 提示正在加载
        showDialog();

    }

    protected abstract void hideDialog();

    protected abstract void showDialog();

    @Override
    public void onComplete() {

        Toast.makeText(context, "请求完毕", Toast.LENGTH_SHORT).show();
        //可以取消Dialog 加载完毕
        hideDialog();
    }
}

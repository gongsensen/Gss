package utils;

import android.content.Context;
import android.widget.Toast;

import com.example.lenovo.myprojects.R;


/**
 * Created by lenovo on 2017/11/13.
 */

public class ToastUtils {

    public static void PopToast(Context context, String string) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }
}

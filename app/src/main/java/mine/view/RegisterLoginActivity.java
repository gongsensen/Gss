package mine.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.lenovo.myprojects.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.greenrobot.eventbus.EventBus;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mine.bean.EventBusBean;
import utils.ToastUtils;


/**
 * Created by lenovo on 2017/11/13.
 */

public class RegisterLoginActivity extends AppCompatActivity {
    @BindView(R.id.login_finish)
    ImageView back;
    @BindView(R.id.login_username)
    EditText userName;
    @BindView(R.id.login_password)
    EditText passWord;
    @BindView(R.id.login_login)
    Button login;
    @BindView(R.id.login_qq_lo)
    ImageView loginQQ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login_finish, R.id.login_login, R.id.login_qq_lo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //点击退出登录页面
            case R.id.login_finish:
                finish();
                break;
            //注册登录
            case R.id.login_login:
                ToastUtils.PopToast(RegisterLoginActivity.this,"0000");
                break;
            //使用QQ登录
            case R.id.login_qq_lo:
                ToastUtils.PopToast(RegisterLoginActivity.this,"响应监听");
                UMShareAPI.get(RegisterLoginActivity.this).getPlatformInfo(RegisterLoginActivity.this, SHARE_MEDIA.QQ, umAuthListener);
                break;
        }
    }

    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {

        }

        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
            //通过封装好的map集合key值获取用户信息
            String name = map.get("name");
            String gender = map.get("gender");
            String iconurl = map.get("iconurl");

            if(name != null && iconurl!= null){
                //发送事件
                EventBus.getDefault().post(new EventBusBean(name,iconurl));
                finish();
            }

        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}

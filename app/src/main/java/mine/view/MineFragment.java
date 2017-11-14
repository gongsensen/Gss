package mine.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.myprojects.R;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import mine.bean.EventBusBean;
import utils.ToastUtils;

/**
 * Created by lenovo on 2017/11/9.
 */

public class MineFragment extends Fragment {

    @BindView(R.id.frag_mine_user_head)
    SimpleDraweeView fragMineUserHead;
    @BindView(R.id.frag_mine_uid_login)
    TextView fragMineUidLogin;
    Unbinder unbinder1;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.mine_frag, container, false);
//        //返回一个Unbinder值（进行解绑），注意这里的this不能使用getActivity()
        unbinder1 = ButterKnife.bind(this, view);
        //注册EventBus
        EventBus.getDefault().register(this );

        onViewClicked(view);


        return view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MessageEventBus(EventBusBean eventBusMessage) {
        fragMineUserHead.setImageURI(eventBusMessage.getIconUrl());
        fragMineUidLogin.setText(eventBusMessage.getName());
    }

    /**
     * onDestroyView中进行解绑操作
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //butterknife解绑操作
        unbinder1.unbind();
        //eventbus 解绑操作
        EventBus.getDefault().unregister(this);

    }

    @OnClick({R.id.frag_mine_user_head, R.id.frag_mine_uid_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.frag_mine_user_head:
                ToastUtils.PopToast(getContext(), "hhhh");
                break;
            case R.id.frag_mine_uid_login:
                Intent intent = new Intent(getActivity(), RegisterLoginActivity.class);
                startActivity(intent);
                ToastUtils.PopToast(getContext(), "hhhh");
                break;
        }
    }
}

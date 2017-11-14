package home.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.example.lenovo.myprojects.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import home.myview.setFrescoImage;

/**
 * Created by lenovo on 2017/11/9.
 * 主页
 */

public class HomeFragment extends Fragment {

    //banner图片地址
    String arr[] = {"https://img30.360buyimg.com/da/jfs/t8164/338/1395234822/160593/7d50319a/59b90cecN61514b41.jpg",
            "https://img14.360buyimg.com/da/jfs/t9058/201/1001582625/146687/f0647c40/59b27772Nc766a1f6.jpg",
            "https://img14.360buyimg.com/da/jfs/t9256/38/1402735114/337388/550b7c93/59b955b0Ne9644fe0.jpg",
            "https://img11.360buyimg.com/da/jfs/t8419/4/815266117/218642/78903406/59af4981Nea57fb82.jpg",
            "https://img11.360buyimg.com/babel/jfs/t8563/102/1393701174/88723/bda85274/59b8c3d4Nd349a04a.jpg",
            "https://img13.360buyimg.com/da/jfs/t8860/195/1256523975/179896/e5261de7/59b73f70Ndcba33ae.jpg",
            "https://img10.360buyimg.com/babel/jfs/t7234/50/2989904721/95724/7ddf2ca5/59b773c6Nb0f6ee13.jpg"};
    private List<String> list;
    @BindView(R.id.rb_sao_qr)
    ImageView rbSaoQr;
    @BindView(R.id.home_message)
    ImageView message;
    @BindView(R.id.rel_lishi)
    RelativeLayout relLishi;
    @BindView(R.id.mybanner)
    Banner mybanner;
    private Unbinder unbinder;

    //绑定点击事件，进入历史搜索
    @OnClick(R.id.rel_lishi)
    public void onclick(View view) {
        startActivity(new Intent(getContext(), LiShiActivity.class));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_frag, container, false);
        //返回一个Unbinder值（进行解绑），注意这里的this不能使用getActivity()
        unbinder = ButterKnife.bind(this, view);
        initBanner();

        return view;
    }

    private void initBanner() {
        //banner轮播
        list = new ArrayList<>();
        for (String s : arr) {
            list.add(s);
        }
        mybanner.setImageLoader(new setFrescoImage());
        mybanner.setImages(list);
        mybanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);//小圆点样式
        mybanner.setDelayTime(2000);//切换时间
        mybanner.start();
    }


    /**
     * onDestroyView中进行解绑操作
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

package com.example.administrator.yycars;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {


    @Bind(R.id.iv_dc)
    ImageView ivDc;
    @Bind(R.id.tv_dc)
    TextView tvDc;
    @Bind(R.id.iv_ce)
    ImageView ivCe;
    @Bind(R.id.tv_ce)
    TextView tvCe;
    @Bind(R.id.iv_tc)
    ImageView ivTc;
    @Bind(R.id.tv_tc)
    TextView tvTc;
    FragmentManager fm;
    CeFragment cefm;
    DcFragment dcfm;
    TcFragment tcfm;
    @Bind(R.id.content)
    FrameLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fm = getFragmentManager();
        selectButton(0);
    }

    private void selectButton(int i) {
        FragmentTransaction tran = fm.beginTransaction();
        initView();
        hideFragment(tran);
        switch (i) {
            case 1:
                ivDc.setImageResource(R.drawable.discount_center);
                tvDc.setTextColor(getResources().getColor(R.color.txt_select));
                if (dcfm == null){
                    dcfm = new DcFragment();
                    tran.add(R.id.content,dcfm);
                }else{
                    tran.show(dcfm);
                }
                break;
            case 2:
                ivCe.setImageResource(R.drawable.customer_evaluation);
                tvCe.setTextColor(getResources().getColor(R.color.txt_select));
                if (cefm == null){
                    cefm = new CeFragment();
                    tran.add(R.id.content,cefm);
                }else{
                    tran.show(cefm);
                }
                break;
            case 3:
                ivTc.setImageResource(R.drawable.telephone_consultation);
                tvTc.setTextColor(getResources().getColor(R.color.txt_select));
                if (tcfm == null){
                    tcfm = new TcFragment();
                    tran.add(R.id.content,tcfm);
                }else{
                    tran.show(tcfm);
                }
                break;
        }
        tran.commit();
    }

    private void hideFragment(FragmentTransaction tran) {
        if (dcfm != null){
            tran.hide(dcfm);
        }
        if (cefm != null){
            tran.hide(cefm);
        }
        if (tcfm != null){
            tran.hide(tcfm);
        }
    }



    private void initView() {
        ivDc.setImageResource(R.drawable.re_discount_center);
        ivCe.setImageResource(R.drawable.re_customer_evaluation);
        ivTc.setImageResource(R.drawable.re_telephone_consultation);

        tvDc.setTextColor(getResources().getColor(R.color.txt));
        tvCe.setTextColor(getResources().getColor(R.color.txt));
        tvTc.setTextColor(getResources().getColor(R.color.txt));
    }

    @OnClick({R.id.iv_dc, R.id.tv_dc, R.id.iv_ce, R.id.tv_ce, R.id.iv_tc, R.id.tv_tc})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_dc:
                selectButton(1);
                break;
            case R.id.tv_dc:
                selectButton(1);
                break;
            case R.id.iv_ce:
                selectButton(2);
                break;
            case R.id.tv_ce:
                selectButton(2);
                break;
            case R.id.iv_tc:
                selectButton(3);
                break;
            case R.id.tv_tc:
                selectButton(3);
                break;
        }
    }

    @OnClick(R.id.content)
    public void onClick() {
    }
}

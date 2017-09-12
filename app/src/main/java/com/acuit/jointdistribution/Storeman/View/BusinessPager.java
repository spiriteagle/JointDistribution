package com.acuit.jointdistribution.Storeman.View;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.acuit.jointdistribution.Common.Base.BasePager;
import com.acuit.jointdistribution.Common.Bean.LoginBean;
import com.acuit.jointdistribution.R;


/**
 * 设置
 */
public class BusinessPager extends BasePager  {

    private View view;
    private TextView tvDepName;
    private TextView tvUserName;
    private TextView tvAboutUS;
    private TextView tvModifyPwd;
    private TextView tvBindPhone;
    private TextView tvQuitAccout;
    private TextView tvSuggestionFeedbace;

    private LoginBean loginBean;

    private int ACTION_FLAG = -1;
    private static final int FLAG_QUIT_ACCOUNT = 0;


    public BusinessPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {

        view = View.inflate(mActivity, R.layout.page_business, null);
        flContainer.addView(view);//给帧布局添加对象

//        tvDepName = (TextView) view.findViewById(R.id.tv_depName);
//        tvUserName = (TextView) view.findViewById(R.id.tv_userName);
//
//        tvAboutUS = (TextView) view.findViewById(R.id.tv_aboutUs);
//        tvModifyPwd = (TextView) view.findViewById(R.id.tv_modifyPwd);
//        tvBindPhone = (TextView) view.findViewById(R.id.tv_bindPhone);
//        tvQuitAccout = (TextView) view.findViewById(R.id.tv_quitAccount);
//        tvSuggestionFeedbace = (TextView) view.findViewById(R.id.tv_suggestionFeedback);
//
//        loginBean = BaseApplication.getLoginBean();
//        tvDepName.setText(loginBean.getData().getUser_info().getDep_info().getDep_name());
//        tvUserName.setText(loginBean.getData().getUser_info().getLoginname());

//        initEvent();
    }

//    private void initEvent() {
//        tvAboutUS.setOnClickListener(this);
//        tvModifyPwd.setOnClickListener(this);
//        tvBindPhone.setOnClickListener(this);
//        tvQuitAccout.setOnClickListener(this);
//        tvSuggestionFeedbace.setOnClickListener(this);
//    }


}

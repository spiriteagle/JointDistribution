package com.acuit.jointdistribution.Supplier.Acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.acuit.jointdistribution.Common.Base.BaseActivity;
import com.acuit.jointdistribution.Common.Base.BaseApplication;
import com.acuit.jointdistribution.Common.Global.GlobalContants;
import com.acuit.jointdistribution.Common.Utils.Tools;
import com.acuit.jointdistribution.Common.View.Activity.HomeActivity;
import com.acuit.jointdistribution.Common.View.Activity.SuggestionFeedbackActivity;
import com.acuit.jointdistribution.R;
import com.acuit.jointdistribution.Supplier.Adapter.SendInfoAdapter;
import com.acuit.jointdistribution.Supplier.Domain.StoreSendInfoBean;
import com.acuit.jointdistribution.Supplier.Utils.ToastUtils;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;

import static com.acuit.jointdistribution.Supplier.Utils.MyHttpUtils.getHttpUtils;

public class SendInfoActivity extends BaseActivity {
    private String id;

    private TextView createDate;
    private TextView planDate;
    private TextView contactPerson;
    private TextView contactNumber;
    private TextView price;
    private TextView code;
    private TextView stockName;
    private TextView unitName;
    private TextView tv_send_address;
    private TextView tv_total_amount;
    private TextView send;
    private ImageView backSend;
    private ListView sendList;
    private ImageView sendMore;
    private PopupWindow mPopWindow;
    private StoreSendInfoBean storeSendInfoBean;
    private ArrayList<StoreSendInfoBean.DataBean.ListBean> sendListInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_info);

        backSend = (ImageView) findViewById(R.id.ib_back_send);

        backSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SendInfoActivity.this, SendActivity.class));
                finish();
            }
        });
        sendMore = (ImageView) findViewById(R.id.ib_send_more);

        createDate = (TextView) findViewById(R.id.tv_send_create_date);
        tv_send_address = (TextView) findViewById(R.id.tv_send_address);

        planDate = (TextView) findViewById(R.id.tv_send_plan_date);
        contactPerson = (TextView) findViewById(R.id.tv_send_contact_person);
        contactNumber = (TextView) findViewById(R.id.tv_send_contact_number);
        send = (TextView) findViewById(R.id.tv_send);

//        price = (TextView) findViewById(R.id.tv_send_price);
        code = (TextView) findViewById(R.id.tv_send_code);
        tv_total_amount = (TextView) findViewById(R.id.tv_send_total_amount);
        sendList = (ListView) findViewById(R.id.lv_sendList);






//        send.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(SendInfoActivity.this);
//                builder.setMessage("发货成功");
//                AlertDialog dialog = builder.create();
//                dialog.show();
//            }
//        });

        sendMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                sendMore.setOnClickListener(new View.OnClickListener() {
//
//                    private AlertDialog dialog;
//
//                    @Override
//                    public void onClick(View v) {
//                        AlertDialog.Builder builder = new AlertDialog.Builder(SendInfoActivity.this);
//                        View inflate = View.inflate(BaseApplication.getContext(), R.layout.more_item, null);
//                        TextView message = (TextView) inflate.findViewById(R.id.tv_message);
//                        TextView retrospect = (TextView) inflate.findViewById(R.id.tv_retrospect);
//                        TextView back_first = (TextView) inflate.findViewById(R.id.tv_back_first);
//
//                        //返回消息界面
//                        message.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                Toast.makeText(BaseApplication.getContext(),"消息界面后续会有",Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                        //返回上一级
//                        back_first.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                startActivity(new Intent(SendInfoActivity.this,HomeActivity.class));
//                                finish();
//                            }
//                        });
//
//                        //返回反馈界面
//                        retrospect.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                Toast.makeText(BaseApplication.getContext(),"反馈界面后续会有",Toast.LENGTH_SHORT).show();
//
//                            }
//                        });
//
//                        builder.setView(inflate);
////                dialog = builder.create();
//
//                        dialog = builder.create();
//                        //设置大小
//                        WindowManager.LayoutParams layoutParams =dialog.getWindow().getAttributes();
//                        layoutParams.width = 300;
//                        layoutParams.height = 600;
//                        dialog.getWindow().setAttributes(layoutParams);
//
//
//                        //设置位置
//
//                        layoutParams.x = -150;//设置x坐标
//                        layoutParams.y = -200;//设置y坐标
//                        Window window =dialog.getWindow();
//                        window.setAttributes( layoutParams);
//                        dialog.setCanceledOnTouchOutside(true);
//                        dialog.show();
//                    }
//                });
                showPopUpWindow();

            }
        });


        HttpUtils http = getHttpUtils();
        Intent intent = getIntent();
        id = intent.getStringExtra("listId");


        RequestParams params = new RequestParams();
//        params.addBodyParameter("from_app", "1");
        params.addBodyParameter("token", BaseApplication.getLoginBean().getData().getToken());
        params.addBodyParameter("id", id + "");

        http.send(HttpRequest.HttpMethod.POST, GlobalContants.URL_STOREIN_DETAIL,
                params, new RequestCallBack<String>() {


                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        String result = responseInfo.result;
                        System.out.println("mmm:" + result);
                        Gson gson = new Gson();
                        storeSendInfoBean = gson.fromJson(result, StoreSendInfoBean.class);

                        tv_send_address.setText(storeSendInfoBean.getData().get(0).getDep_name());
                        code.setText(storeSendInfoBean.getData().get(0).getCode());
                        createDate.setText(storeSendInfoBean.getData().get(0).getCreate_date());
                        planDate.setText(Tools.getFormatedTime(storeSendInfoBean.getData().get(0).getPlan_date()));
                        contactNumber.setText("("+storeSendInfoBean.getData().get(0).getContact_phone()+")");
                        contactPerson.setText(storeSendInfoBean.getData().get(0).getContact_person());
                        tv_total_amount.setText(storeSendInfoBean.getData().get(0).getStatis_num()+ "kg");

                        // TODO: 2017/9/11 0011 等待接口修改
//                        price.setText(storeSendInfoBean.getData().getStock_list_app().get(0).getStock_name());
//                        stockName.setText(storeSendInfoBean.getData().getStock_list_app().get(0).getStock_name());
//                        unitName.setText(storeSendInfoBean.getData().getStock_list_app().get(0).getUnit_name());
//                        stockName.setText(storeSendInfoBean.getData().getStock_list_app().get(0).getStock_name());
//                        unitName.setText(storeSendInfoBean.getData().getStock_list_app().get(0).getUnit_name());
//                        price.setText(storeSendInfoBean.getData().getStock_list_app().get(0).getPrice());

                        sendListInfo = new ArrayList<StoreSendInfoBean.DataBean.ListBean>();

                        sendListInfo.clear();
                        sendListInfo.addAll(storeSendInfoBean.getData().get(0).getList());

                        if (null!=sendListInfo){

                            SendInfoAdapter sendInfoAdapter = new SendInfoAdapter(sendListInfo,SendInfoActivity.this);

                            sendList.setAdapter(sendInfoAdapter);

                        }




                    }

                    @Override
                    public void onFailure(HttpException error, String msg) {
                        ToastUtils.showToast(getApplicationContext(), "获取数据异常");
                    }
                });

    }

    private void showPopUpWindow() {


            View contentView = LayoutInflater.from(SendInfoActivity.this).inflate(R.layout.more_item, null);
            mPopWindow = new PopupWindow(contentView);
            mPopWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            mPopWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

            TextView tv1 = (TextView)contentView.findViewById(R.id.tv_back_first);
            TextView tv2 = (TextView)contentView.findViewById(R.id.tv_retrospect);
            TextView tv3 = (TextView)contentView.findViewById(R.id.tv_message);

            tv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(SendInfoActivity.this,HomeActivity.class));
                    finish();

                }
            });
            tv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                Toast.makeText(BaseApplication.getContext(),"反馈界面后续会有",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SendInfoActivity.this, SuggestionFeedbackActivity.class));
                    finish();
                }
            });
            tv3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                Toast.makeText(BaseApplication.getContext(),"消息界面后续会有",Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(SendInfoActivity.this,MessageActivity.class));
                    finish();
                }
            });

            mPopWindow.showAsDropDown(sendMore);

    }


}

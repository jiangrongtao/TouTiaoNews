package com.itoutiao.news.toutiaonews.base;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ant.liao.GifView;
import com.itoutiao.news.toutiaonews.R;
import com.itoutiao.news.toutiaonews.util.WindowsUtil;


/**
 * Fragment Base
 *
 * @author LGS
 */
public abstract class BaseFragment extends Fragment{
    private Dialog mLoadingDialog;
    protected View mContentView;
    protected FragmentActivity mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        mContentView = View.inflate(mContext, getLayoutId(), null);
        return mContentView ==null?super.onCreateView(inflater, container, savedInstanceState): mContentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            initData();
            initListener();
        }catch (Exception e){

        }
    }

    /**
     * 获取布局文件的ID
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 加载并且填充是数据
     */
    protected abstract void initData();

    /**
     * 注册各种事件
     */
    protected abstract void initListener();


    /**
     * 显示加载等待Dialog
     */
    public void showLoadingDialog() {
        showLoadingDialog("拼命加载中...");
    }

    /**
     * 显示加载等待Dialog
     *
     * @param loadingStr
     */
    public void showLoadingDialog(String loadingStr) {
        dismissDialog();
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(mContext);
        mLoadingDialog = builder.create();
        mLoadingDialog.show();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.loading_dialog_view, null);
        TextView tipTextview = (TextView) view.findViewById(R.id.tipTextView);
        GifView gifView = (GifView) view.findViewById(R.id.gifView);
        gifView.setGifImage(R.drawable.gif_load);
        if (TextUtils.isEmpty(loadingStr)) {
            tipTextview.setVisibility(View.GONE);
        } else {
            tipTextview.setVisibility(View.VISIBLE);
            tipTextview.setText(loadingStr);
        }
        mLoadingDialog.setContentView(view);
        Window dialogWindow = mLoadingDialog.getWindow();
        mLoadingDialog.setCanceledOnTouchOutside(false);
        dialogWindow.setGravity(Gravity.CENTER);
        android.view.WindowManager.LayoutParams layoutParams = dialogWindow.getAttributes();
        layoutParams.height =mContext.getWindowManager().getDefaultDisplay().getWidth() * 1/4;
        layoutParams.width =mContext.getWindowManager().getDefaultDisplay().getWidth() * 2/ 3;
        dialogWindow.setAttributes(layoutParams);
        mLoadingDialog.show();
    }
    /**
     * 显示加载等待Dialog
     *
     *
     */
    public void showWiatDialog() {
        dismissDialog();
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        mLoadingDialog = builder.create();
        mLoadingDialog.show();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.loading_dialog_view, null);
        TextView tipTextview = (TextView) view.findViewById(R.id.tipTextView);
        tipTextview.setVisibility(View.GONE);
        GifView gifView = (GifView) view.findViewById(R.id.gifView);
        gifView.setGifImage(R.drawable.gif_load);
        mLoadingDialog.setContentView(view);
        Window dialogWindow = mLoadingDialog.getWindow();
        mLoadingDialog.setCanceledOnTouchOutside(false);
        dialogWindow.setGravity(Gravity.CENTER);
        android.view.WindowManager.LayoutParams layoutParams = dialogWindow.getAttributes();
        int i = WindowsUtil.getWindowsWidth() * 1 / 3;
        layoutParams.height =i;
        layoutParams.width = i;
        dialogWindow.setAttributes(layoutParams);
        mLoadingDialog.show();
    }
    /**
     * 隐藏加载等待Dialog
     */
    public void dismissDialog() {
        if (mLoadingDialog != null) {
            try {
                mLoadingDialog.dismiss();
                mLoadingDialog = null;
            } catch (Exception e) {
            }
        }
    }

    /**
     * 显示提示
     *
     * @param content
     */
    public void showToast(String content) {
        Toast.makeText(getActivity(), content, Toast.LENGTH_LONG).show();
    }


    //避免 fragment切换时,会出现重叠的现象
    @Override
    public void setMenuVisibility(boolean menuVisible) {
        if(getView() != null){
            getView().setVisibility(menuVisible?View.VISIBLE:View.GONE);
        }
        super.setMenuVisibility(menuVisible);
    }
}
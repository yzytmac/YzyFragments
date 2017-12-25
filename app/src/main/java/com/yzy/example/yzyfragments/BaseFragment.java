package com.yzy.example.yzyfragments;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.yzy.example.yzyfragments.function.FunctionManager;


/**
 * Created by yzy on 2017/12/22.
 */

public class BaseFragment extends Fragment{

    protected FunctionManager mFunctionManager;
    private MainActivity mBaseActivity;

    /**
     * 为要实现接口的Fragment添加FunctionManager
     * @param functionManager
     */
    public void setmFunctionManager(FunctionManager functionManager){
        this.mFunctionManager = functionManager;
    }

    /**
     * 确保Mainctivity实现了Fragment相应的接口回调
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof MainActivity){
            mBaseActivity = (MainActivity) context;
            mBaseActivity.setFuctionsForFragment(getTag());
        }
    }
}

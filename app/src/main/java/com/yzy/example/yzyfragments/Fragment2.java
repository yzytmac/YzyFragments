package com.yzy.example.yzyfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by yzy on 2017/12/22.
 */

public class Fragment2 extends BaseFragment {
    private TextView tv;

    private Button btn;
    public static final String INTERFACE_RESULT = Fragment1.class.getName() + "WithResault";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout,null);
        tv = (TextView) view.findViewById(R.id.textView);
        tv.setText(this.getClass().getSimpleName());
        btn = (Button) view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = mFunctionManager.invokeFunc(INTERFACE_RESULT,String.class);
                Toast.makeText(getActivity(),str,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}

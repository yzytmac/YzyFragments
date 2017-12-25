package com.yzy.example.yzyfragments.function;

/**
 * Created by yzy on 2017/12/22.
 */

public abstract class FunctionWithResultOnly<Result> extends Function{
    public FunctionWithResultOnly(String functionName){
        super(functionName);
    }
    public abstract Result function();
}

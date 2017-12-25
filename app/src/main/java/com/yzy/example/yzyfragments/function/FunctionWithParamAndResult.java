package com.yzy.example.yzyfragments.function;

/**
 * Created by yzy on 2017/12/22.
 */

public abstract class FunctionWithParamAndResult<Result,Param> extends Function{
    public FunctionWithParamAndResult(String functionName){
        super(functionName);
    }
    public abstract Result function(Param pram);
}

package com.yzy.example.yzyfragments.function;

/**
 * Created by yzy on 2017/12/22.
 */

public abstract class FunctionWithParamOnly<Param> extends Function{
    public FunctionWithParamOnly(String functionName){
        super(functionName);
    }
    public abstract void function(Param pram);
}

# YzyFragnments
接口再抽象-打造万能Fragment通讯框架
- 如果觉得有用，不吝啬在右上角给我一个Star。谢谢！！  
![](https://raw.githubusercontent.com/yzytmac/yzytmac.github.io/master/images/star.png)  
此项目实现了多个Fragment之间的数据传输通讯，以宿主Activty作为通讯桥梁，通过一个Fragment的基类BaseFragment与宿主Activity进行接口绑定，在宿主Activty中调用setFuctionsForFragment()实现接口方法。

BaseFragment与宿主Activity进行接口绑定：
```java
@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof MainActivity){
            mBaseActivity = (MainActivity) context;
            mBaseActivity.setFuctionsForFragment(getTag());
        }
    }
   ```
    
宿主Activty中调用setFuctionsForFragment()实现接口方法：  
 
```java
    public void setFuctionsForFragment(String tag){
         FragmentManager fm = getSupportFragmentManager();
         BaseFragment fragment = (BaseFragment) fm.findFragmentByTag(tag);
         FunctionManager functionManager = FunctionManager.getInstance();
         fragment.setmFunctionManager(functionManager.addFunction(new FunctionNoParamNoResault(Fragment1.INTERFACE) {
             @Override
             public void function() {
                 //接口中的方法回调
                 Toast.makeText(MainActivity.this,"成功调用无参无返回值的接口",Toast.LENGTH_SHORT).show();
             }
         }).addFunction(new FunctionWithResultOnly<String>(Fragment2.INTERFACE_RESULT) {
             @Override
             public String function() {
                 //接口中的方法回调
                 return "I Love U";
             }
         }).addFunction(new FunctionWithParamAndResult<String,String>(Fragment3.INTERFACE_PARAM_RESULT) {
             @Override
             public String function(String pram) {
                 //接口中的方法回调
                 return pram;
             }
         }).addFunction(new FunctionWithParamOnly<String>(Fragment4.INTERFACE_PARAM) {@Override
             public void function(String pram) {
                 //接口中的方法回调
                 Toast.makeText(MainActivity.this,"成功调用有参无返回值的接口：" + pram,Toast.LENGTH_SHORT).show();
             }
         }));
    }
```  
如有错误欢迎指正.邮箱yzytmac@163.com

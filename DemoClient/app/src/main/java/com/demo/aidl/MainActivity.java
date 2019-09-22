package com.demo.aidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    IMyAidlInterface iMyAidlInterface = null;
    private Button bindServiceBtn;
    private Button aidlBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    /**
     * 初始化视图组件
     */
    public void initView(){
        bindServiceBtn = findViewById(R.id.bindService);
        aidlBtn = findViewById(R.id.aidl);
    }

    /**
     * 绑定service，隐式启动Server端进程的service, 获取aidl接口引用
     */
    public void bindService(){
        if(iMyAidlInterface != null){
            Toast.makeText(MainActivity.this, "service已经绑定", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(MainActivity.this, "开始绑定service", Toast.LENGTH_SHORT).show();
        //5.0之后 需要在setAction之后，setPackage
        Intent intent = new Intent("com.demo.demoserver");
        intent.setAction("com.a.a.HelloService");
        intent.setPackage("com.demo.demoserver");
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Toast.makeText(MainActivity.this, "服务已经建立连接", Toast.LENGTH_SHORT).show();
                iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, BIND_AUTO_CREATE);

        startService(intent);
    }


    /**
     * 处理按钮点击事件
     * @param view
     */
    public void onclick(View view){
       try{
           switch (view.getId()){
               case R.id.bindService:
                  bindService();
                  break;
               case R.id.aidl:
                  Toast.makeText(MainActivity.this, "点击了按钮", Toast.LENGTH_SHORT).show();
                  Toast.makeText(MainActivity.this, iMyAidlInterface.getName(), Toast.LENGTH_SHORT).show();
                  break;
               default:
                   break;
           }

       } catch (Exception e){
           e.printStackTrace();
       }
    }
}

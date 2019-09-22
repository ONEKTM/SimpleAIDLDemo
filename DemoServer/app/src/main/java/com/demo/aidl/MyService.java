package com.demo.aidl;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

public class MyService extends Service {

    public int onStartCommand(Intent intent, int flags, int startId){
        Toast.makeText(MainActivity.ctx, "服务已经启动", Toast.LENGTH_SHORT).show();
       return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }


    class MyBinder extends IMyAidlInterface.Stub{

        @Override
        public String getName() throws RemoteException {
            return "Hello ! My Client";
        }
    }

}

package com.chuanjinet.flutterEzviz;

//import ezviz.ezopensdkcommon.common.BaseApplication;

import android.content.Context;

public class DemoConfig {
    private String rootDir;
  public DemoConfig(Context context){
         rootDir=context.getExternalCacheDir()+"0_OpenSDK";;
    }

    /**
     * 是否打开调试页面
     */
    public static final boolean isNeedJumpToTestPage = false;



    /**
     * 文件保存位置
     */

    public  String getDemoFolder(){
        return rootDir;
    }

    public  String getRecordsFolder(){
        return rootDir + "/Records";
    }

    public  String getCapturesFolder(){
        return rootDir + "/Captures";
    }

    public  String getStreamsFolder(){
        return rootDir + "/Streams";
    }

}

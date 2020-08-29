package com.chuanjinet.flutterEzviz;

import android.content.Context;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterEzvizPlugin */
public class FlutterEzvizPlugin implements FlutterPlugin, MethodCallHandler {

  static Context applicationContext;

  private MethodChannel channel;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    applicationContext=flutterPluginBinding.getApplicationContext();
    channel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "flutterEzviz");
    channel.setMethodCallHandler(this);
  }


  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutterEzviz");
    channel.setMethodCallHandler(new FlutterEzvizPlugin());
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    }else if (call.method.equals("realPlayPage")){
      String appKey = call.argument("appKey");
      String accessToken = call.argument("accessToken");
      String deviceSerial = call.argument("deviceSerial");
      Integer cameraNo = call.argument("cameraNo");

      EZRealPlayActivity.launch(applicationContext,appKey,accessToken, deviceSerial, cameraNo);
    }else if (call.method.equals("remotePlayBackPage")){

    } else {
      result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }
}

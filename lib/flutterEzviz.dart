import 'dart:async';

import 'package:flutter/services.dart';

class FlutterEzviz {
  static const MethodChannel _channel =
      const MethodChannel('flutterEzviz');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<Null> realPlayPage(String appKey,String deviceSerial,int cameraNo,String accessToken) async {
    //下面是把参数传递到底层
    Map<String,dynamic> params={
      'appKey':appKey,
      'deviceSerial':deviceSerial,
      'cameraNo':cameraNo,
      'accessToken':accessToken
    };
    final String res = await _channel.invokeMethod('realPlayPage',params);
  }


//  static void get realPlayPage   {
//    _channel.invokeMethod('realPlayPage');
//  }
//
//  static void get remotePlayBackPage  {
//    _channel.invokeMethod('remotePlayBackPage');
//  }
}

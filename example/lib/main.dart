import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:flutter_ezviz/flutterEzviz.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _platformVersion = 'Unknown';

  @override
  void initState() {
    super.initState();
    initPlatformState();
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    String platformVersion;
    // Platform messages may fail, so we use a try/catch PlatformException.
    try {
      platformVersion = await FlutterEzviz.platformVersion;
    } on PlatformException {
      platformVersion = 'Failed to get platform version.';
    }

    // If the widget was removed from the tree while the asynchronous platform
    // message was in flight, we want to discard the reply rather than calling
    // setState to update our non-existent appearance.
    if (!mounted) return;

    setState(() {
      _platformVersion = platformVersion;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Column(
          children: [
            RaisedButton(
              child: Text('realPlayPage'),
              onPressed: (){
              String appKey = "c019878fadb04485a704a324df62c68f";
              String deviceSerial="D71216843";
              int cameraNo=1;
              String accessToken = "at.3zje3x7m71oq58er0kutac9q9at5jkue-4qpmsaxbyr-0nj85qw-wm9syyyux";
              FlutterEzviz.realPlayPage(appKey,deviceSerial,cameraNo,accessToken);
              },
            ),
          ],
        ),
      ),
    );
  }
}

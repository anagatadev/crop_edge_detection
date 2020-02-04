import 'dart:async';

import 'package:flutter/services.dart';

class CropEdgeDetection {
  static const MethodChannel _channel =
      const MethodChannel('crop_edge_detection');

  static Future<String> get detectEdge async {
    final String imagePath = await _channel.invokeMethod('crop_edge_detect');
    return imagePath;
  }
}

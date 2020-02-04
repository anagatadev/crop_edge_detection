package dev.anagata.cropedgedetection

import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.PluginRegistry.Registrar

class CropEdgeDetectionPlugin(private val registrar: Registrar, private val delegate: CropEdgeDetectionDelegate) : MethodCallHandler {


  companion object {
    @JvmStatic
    fun registerWith(registrar: Registrar): Unit {
      val channel = MethodChannel(registrar.messenger(), "crop_edge_detection")

      val delegate = CropEdgeDetectionDelegate(registrar.activity())

      registrar.addActivityResultListener(delegate)

      channel.setMethodCallHandler(CropEdgeDetectionPlugin(registrar, delegate))
    }
  }

  override fun onMethodCall(call: MethodCall, result: Result): Unit {
    if (registrar.activity() == null) {
      result.error("no_activity", "crop_edge_detection plugin requires a foreground activity.", null)
      return
    }
    else if (call.method.equals("crop_edge_detect")) {
      delegate.OpenCameraActivity(call, result)
    }else {
      result.notImplemented()
    }
  }
}

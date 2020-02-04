#import "CropEdgeDetectionPlugin.h"
#import <crop_edge_detection/crop_edge_detection-Swift.h>

@implementation CropEdgeDetectionPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftEdgeDetectionPlugin registerWithRegistrar:registrar];
}
@end

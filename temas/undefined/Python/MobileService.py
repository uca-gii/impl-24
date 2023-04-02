# public class MobileService {
#   public Integer getMobileScreenWidth(Optional<Mobile> mobile){
#     return mobile.flatMap(Mobile::getDisplayFeatures)
#       .flatMap(DisplayFeatures::getResolution)
#       .map(ScreenResolution::getWidth)
#       .orElse(0);
#   }
# }

class MobileService():

    def getMobileScreenWidth(mobile):
        pass
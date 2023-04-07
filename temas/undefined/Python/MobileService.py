from typing import Optional
from Mobile import Mobile

class MobileService:
    def getMobileScreenWidth(self, mobile: Optional[Mobile]) -> int:
        try:
            return mobile.getDisplayFeatures().getResolution().getWidth()
        except AttributeError:
            return 0
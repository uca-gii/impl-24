from typing import Optional
from ScreenResolution import ScreenResolution

class DisplayFeatures():

    def __init__(self, size: str , resolution: Optional[ScreenResolution]):
        self.__size = size

        self.__resolution = resolution

    def getSize(self):
        return self.__size
    
    def getResolution(self):
        return self.__resolution


class ScreenResolution():
  
    def __init__(self, width: int, height: int):
        self.__width = width
        self.__height = height

    def getWidth(self) -> int:
        return self.__width
    
    def getHeight(self) -> int:
        return self.__height

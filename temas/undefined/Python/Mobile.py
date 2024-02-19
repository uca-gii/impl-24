from typing import Optional
from DisplayFeatures import DisplayFeatures

class Mobile():  

    def __init__(self, id: int, brand: str, name: str, displayFeatures: Optional[DisplayFeatures]):
        self.__id = id
        self.__brand = brand
        self.__name = name

        self.__displayFeatures = displayFeatures

    def getId(self):
        return self.__id
    
    def getBrand(self):
        return self.__brand
    
    def getName(self):
        return self.__name
    
    def getDisplayFeatures(self):
        return self.__displayFeatures
    
    
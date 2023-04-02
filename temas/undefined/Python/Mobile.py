
class Mobile():

    def __init__(self, id, brand, name, displayFeatures):
        self.__id = id
        self.__brand = brand
        self.__name = name

        #CAMBIAR QUE ES DE TIPO OPTIONAL
        self.__displayFeatures = displayFeatures

    def getId(self):
        return self.__id
    
    def getBrand(self):
        return self.__brand
    
    def getName(self):
        return self.__name
    
    def getDisplayFeatures(self):
        return self.__displayFeatures
    
    
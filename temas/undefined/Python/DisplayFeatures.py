
class DisplayFeatures():

    def __init__(self, size, resolution):
        self.__size = size

        #CAMBIAR QUE ES DE TIPO OPTIONAL
        self.__resolution = resolution

    def getSize(self):
        return self.__size
    
    def getResolution(self):
        return self.__resolution

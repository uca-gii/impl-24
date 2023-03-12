from abc import ABC, abstractmethod

class Instrumento(ABC):

    @abstractmethod
    def tocar():
        pass

    @abstractmethod
    def afinar():
        pass


class Viento(Instrumento):

    def tocar(self):
        self.soplar()
    
    def afinar():
        print("Afinar soplido.")

    def soplar():
        print("Soplar.")


class Cuerda(Instrumento):

    def tocar(self):
        self.rasgar()
    
    def afinar(self):
        print("Afinar rasgado.")

    def rasgar():
        print("Rasgar.")


class Percusion(Instrumento):

    def tocar(self):
        self.golpear()
    
    def afinar():
        print("Afinar golpeado.")

    def golpear():
        print("Golpear.")

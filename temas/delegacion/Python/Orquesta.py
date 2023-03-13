from Instrumentos import *


class Orquesta():
    def __init__(self):
        self.instrumentos = []

    def addInstrumento(self, ins):
        self.instrumentos.append(ins)

    def removeInstrumento(self, ins):
        self.instrumentos.remove(ins)

    def tocar(self):
        for i in self.instrumentos:
            i.tocar()

    def afinar(ins):
        ins.afinar()
        ins.tocar()
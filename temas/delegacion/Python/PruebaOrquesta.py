from Orquesta import *
from Instrumentos import *

def main():

    orquesta = Orquesta()
    orquesta.addInstrumento(Viento())
    orquesta.addInstrumento(Cuerda())
    orquesta.addInstrumento(Percusion())

    for i in orquesta:
        orquesta.afinar(i)

    orquesta.tocar()
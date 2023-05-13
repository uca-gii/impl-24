from reactivex import create

#Se crea una función que luego utilizaremos para crear el oberver
def imprimir_Cinco_Cadenas(observer, scheduler):
    observer.on_next("Uno")
    observer.on_next("Dos")
    observer.on_next("Tres")
    observer.on_next("Cuatro")
    observer.on_next("Cinco")
    observer.on_completed()

#Creamos el observer(suscriptor)
source = create(imprimir_Cinco_Cadenas)

#Se suscribe al observador
source.subscribe(
    #Definimos como se van a tratar los valores emitidos.
    on_next = lambda i: print("Recibido {0}".format(i)), 
    on_error = lambda e: print("Ha ocurrido un error: {0}".format(e)),#"" cuando hay un error
    on_completed = lambda: print("Completado!"), #"" cuando no hay nada más
)
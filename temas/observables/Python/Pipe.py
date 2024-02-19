import reactivex as rx
from reactivex import operators as ops
import time

source = rx.interval(1)  # Emite un valor cada segundo

source.pipe(
    # Detiene la emisión después de 7 segundos
    ops.take_until(rx.timer(7)),  
    #Pillamos solo los valores que no son múltiplos de 3
    ops.filter(lambda x: x % 3 != 0), 
    ops.map(lambda x: "Tick {}".format(x*2))
).subscribe(print)

time.sleep(9)  # Espera 9 segundos para que la suscripción termine
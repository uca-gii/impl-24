import reactivex as rx
import time

print("observable desde iterable y combinación con zip...")
letters = rx.from_iterable(["A", "B", "C"])
numbers = rx.from_iterable([1, 2, 3])

# Combina los valores emitidos por los dos Observables en pares
rx.zip(letters, numbers).subscribe(print)

print("Observable con timer...")
# Observable que emite un valor después de 1 segundo
timer = rx.timer(1)

# Se suscribe y muestra un mensaje después de recibir el valor
timer.subscribe(lambda _: print("Timer completed"))

# Hacemos pausa por 2 segundos para permitir que el temporizador se complete
time.sleep(2)

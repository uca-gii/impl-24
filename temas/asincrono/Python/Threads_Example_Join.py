import logging
import threading
import time

class raceOperations():

    def set_to_1000(self, name):
        self.value = 0
        logging.info("Thread %s: Empezando, value = %i", name, self.value)
        
        i = 0
        while i < 1000:
            self.value +=1
            i +=1
            if i == 500:
                time.sleep(2)

        logging.info("Thread %s: Acabando, value = %i", name, self.value)

    def double(self, name):
        self.value *= 2
        logging.info("Thread %s: Multiplicando, value = %i", name, self.value)

if __name__ == "__main__":
    format = "%(asctime)s: %(message)s"
    logging.basicConfig(format=format, level=logging.INFO,
                        datefmt="%H:%M:%S")

    ro = raceOperations();
    logging.info("Main    : Antes de crear el hilo")
    x = threading.Thread(target=ro.set_to_1000, args=(1,))
    y = threading.Thread(target=ro.double, args=(2,))
    logging.info("Main    : Después de ejecutar el hilo")
    x.start()
    x.join()
    y.start()
    logging.info("Main    : Esperando a que los hilos acaben")
    
    logging.info("Main    : Completado")
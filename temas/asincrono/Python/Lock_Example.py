import logging
import threading
import time

class raceOperations():

    def __init__(self):
        self.value = 0
        self._lock = threading.Lock()

    def set_to_1000(self, name):
        logging.info("Thread %s: Empezando, value = %i", name, self.value)
        
        i = 0
        with self._lock:
            logging.debug("Thread %s: Ha entrado en el lock", name, self.value)
            while i < 1000:
                self.value +=1
                i +=1
                if i == 500:
                    time.sleep(2)
            logging.debug("Thread %s: Va a soltar el lock", name, self.value)

        logging.info("Thread %s: Acabando, value = %i", name, self.value)

    def double(self, name):
        logging.info("Thread %s: Empezando, value = %i", name, self.value)
        with self._lock:
            logging.debug("Thread %s: Ha entrado en el lock", name, self.value)
            self.value *= 2
            logging.debug("Thread %s: Va a soltar el lock", name, self.value)

        logging.info("Thread %s: Multiplicacion hecha, value = %i", name, self.value)

if __name__ == "__main__":
    format = "%(asctime)s: %(message)s"
    logging.basicConfig(format=format, level=logging.INFO,
                        datefmt="%H:%M:%S")

    ro = raceOperations();
    logging.info("Main    : Antes de crear el hilo")
    x = threading.Thread(target=ro.set_to_1000, args=(1,))
    y = threading.Thread(target=ro.double, args=(2,))
    logging.info("Main    : Después de crear el hilo")
    x.start()
    y.start()
    logging.info("Main    : Esperando a que los hilos acaben...")
    

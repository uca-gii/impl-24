import logging
import threading
import time

class raceOperations():

    def __init__(self):
        self.conflictValue = 0
        self._lock = threading.Lock()

    def set_to_1000(self, name):
        logging.info("Thread %s: Empezando, conflictValue = %i", name, self.conflictValue)
        
        i = 0
        with self._lock:
            logging.debug("Thread %s: Ha entrado en el lock", name, self.conflictValue)
            while i < 1000:
                self.conflictValue +=1
                i +=1
                if i == 500:
                    time.sleep(2)
            logging.debug("Thread %s: Va a soltar el lock", name, self.conflictValue)

        logging.info("Thread %s: Acabando, conflictValue = %i", name, self.conflictValue)

    def double(self, name):
        logging.info("Thread %s: Empezando, conflictValue = %i", name, self.conflictValue)
        with self._lock:
            logging.debug("Thread %s: Ha entrado en el lock", name, self.conflictValue)
            self.conflictValue *= 2
            logging.debug("Thread %s: Va a soltar el lock", name, self.conflictValue)

        logging.info("Thread %s: Multiplicacion hecha, conflictValue = %i", name, self.conflictValue)

if __name__ == "__main__":
    format = "%(asctime)s: %(message)s"
    logging.basicConfig(format=format, level=logging.INFO,
                        datefmt="%H:%M:%S")

    ro = raceOperations();
    logging.info("Main    : Antes de crear el hilo")
    hebra1 = threading.Thread(target=ro.set_to_1000, args=(1,))
    hebra2 = threading.Thread(target=ro.double, args=(2,))
    logging.info("Main    : Después de crear el hilo")
    hebra1.start()
    hebra2.start()
    logging.info("Main    : Esperando a que los hilos acaben...")
    

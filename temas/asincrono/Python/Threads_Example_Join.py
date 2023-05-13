import logging
import threading
import time

class raceOperations():

    def set_to_1000(self, name):
        self.conflictValue = 0
        logging.info("Thread %s: Empezando, conflictValue = %i", name, self.conflictValue)
        
        i = 0
        while i < 1000:
            self.conflictValue +=1
            i +=1
            if i == 500:
                time.sleep(2)

        logging.info("Thread %s: Acabando, conflictValue = %i", name, self.conflictValue)

    def double(self, name):
        self.conflictValue *= 2
        logging.info("Thread %s: Multiplicando, conflictValue = %i", name, self.conflictValue)

if __name__ == "__main__":
    format = "%(asctime)s: %(message)s"
    logging.basicConfig(format=format, level=logging.INFO,
                        datefmt="%H:%M:%S")

    ro = raceOperations();
    logging.info("Main    : Antes de crear el hilo")
    hebra1 = threading.Thread(target=ro.set_to_1000, args=(1,))
    hebra2 = threading.Thread(target=ro.double, args=(2,))
    logging.info("Main    : Después de ejecutar el hilo")
    hebra1.start()
    hebra1.join()
    hebra2.start()
    logging.info("Main    : Esperando a que los hilos acaben")
    
    logging.info("Main    : Completado")
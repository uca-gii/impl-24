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


if __name__ == "__main__":
    format = "%(asctime)s: %(message)s"
    logging.basicConfig(format=format, level=logging.INFO,
                        datefmt="%H:%M:%S")

    ro = raceOperations();
    logging.info("Main    : Antes de crear el hilo")
    hebra = threading.Thread(target=ro.set_to_1000, args=(1,), daemon=True)
    logging.info("Main    : Después de ejecutar el hilo")
    hebra.start()
    logging.info("Main    : No esperamos a que el hilo acabe")
    
    logging.info("Main    : Completado")
import concurrent.futures
import logging
import time

def funcion_hebra(name):
    logging.info("Thread %s: Empezando", name)
    time.sleep(2)
    logging.info("Thread %s: Acabando", name)

if __name__ == "__main__":
    format = "%(asctime)s: %(message)s"
    logging.basicConfig(format=format, level=logging.INFO,
                        datefmt="%H:%M:%S")

    with concurrent.futures.ThreadPoolExecutor(max_workers=3) as executor:
        executor.map(funcion_hebra, range(3))
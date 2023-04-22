import logging
import asyncio


class raceOperations():

    async def start(self):
        f1 = loop.create_task(self.set_to_1000("set_to_1000"))
        f2 = loop.create_task(self.double("double"))
        await asyncio.wait([f1, f2])

    async def set_to_1000(self, name):
        self.value = 0
        logging.info("Funcion %s: Empezando, value = %i", name, self.value)
        
        i = 0
        while i < 1000:
            self.value +=1
            i +=1
            if i == 500:
                #Recalcar que no estamos usando time.sleep
                await asyncio.sleep(2)

        logging.info("Funcion %s: Acabando, value = %i", name, self.value)

    async def double(self, name):
        self.value *= 2
        logging.info("Funcion %s     : Multiplicando, value = %i", name, self.value)

if __name__ == "__main__":
    format = "%(asctime)s: %(message)s"
    logging.basicConfig(format=format, level=logging.INFO,
                        datefmt="%H:%M:%S")

    ro = raceOperations();
    logging.info("Main               : Antes de dividir el flujo de trabajo")
    loop = asyncio.get_event_loop()
    loop.run_until_complete(ro.start())
    logging.info("Main               : Después de ejecutar las funciones")
    
    logging.info("Main               : Completado")
    loop.close()
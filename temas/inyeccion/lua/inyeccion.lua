-- main.lua

-- Definición de la clase Dependency
local Dependency = {}

function Dependency:new()
    local obj = {}
    self.__index = self
    setmetatable(obj, self)
    return obj
end

function Dependency:operation()
    print("Executing operation from Dependency")
end

-- Definición del contenedor de inversión de control
local Container = {}

function Container:new()
    local obj = {}
    self.__index = self
    setmetatable(obj, self)
    obj.dependencies = {}
    return obj
end

function Container:register(dependencyName, dependency)
    self.dependencies[dependencyName] = dependency
end

function Container:resolve(dependencyName)
    return self.dependencies[dependencyName]
end

-- Uso del contenedor y la clase Dependency
local container = Container:new()

-- Registramos una instancia de Dependency en el contenedor
container:register("dependency", Dependency:new())

-- Resolvemos la dependencia y llamamos a su método
local dependency = container:resolve("dependency")
dependency:operation()

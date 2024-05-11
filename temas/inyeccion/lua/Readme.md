# Inyección en Lua #
## Ejemplo ##
Este ejemplo consiste en una App que requiere un servicio de correo electrónico para funcionar. Para ello, en vez de crear directamente una instancia de `EmailService` dentro de `App`, se utilizará el principio de Inversión de Control (IoC) para pasarle una instancia de `EmailService` como una dependencia cuando se crea una instancia de `App` entonces se reducirá el acomplamiento entre clases y permitirá que `App` sea más flexible y reutilizable. Para probar el ejemplo se dispone de un main.
```lua
-- email.lua
local EmailService = {}

function EmailService:new()
    local newObj = {}
    self.__index = self
    return setmetatable(newObj, self)
end

function EmailService:sendEmail(to, subject, body)
    -- Lógica para enviar el correo electrónico
    print("Enviando correo a:", to)
    print("Asunto:", subject)
    print("Cuerpo:", body)
end

return EmailService
```

```lua
-- app.lua
local App = {}

function App:new(emailService)
    local newObj = { emailService = emailService }
    self.__index = self
    return setmetatable(newObj, self)
end

function App:notifyUser(user)
    local to = user.email
    local subject = "¡Hola!"
    local body = "Este es un mensaje de notificación."
    self.emailService:sendEmail(to, subject, body)
end

return App
```

```lua
-- main.lua
local EmailService = require("./temas/inyeccion/lua/email")
local App = require("./temas/inyeccion/lua/app")

-- Crear una instancia de EmailService
local emailService = EmailService:new()

-- Crear una instancia de App con la dependencia inyectada
local app = App:new(emailService)

-- Simular la notificación de un usuario
local user = { email = "usuario@example.com" }
app:notifyUser(user)
```

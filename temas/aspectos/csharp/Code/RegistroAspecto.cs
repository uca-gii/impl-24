using PostSharp.Aspects;
using PostSharp.Serialization;

[PSerializable]
public class RegistroAspecto: OnMethodBoundaryAspect{
    public override void OnExit(MethodExecutionArgs args)
    {
        if(args.Method.Name == "mostrarDetalles"){
            var archivo = args.Instance as ArchivoPolicial; 
            if (archivo != null)
            {
                Console.WriteLine("ASPECTO");
                RegistradorAcciones.registrarAccion($"El policia con placa {args.Arguments[0]} ha consultado los detalles del archivo {archivo.getId()}");
            }
        }
        else if(args.Method.Name == "solicitarRevision"){
            var archivo = args.Instance as ArchivoPolicial;
            if (archivo != null)
            {
                Console.WriteLine("ASPECTO");
                RegistradorAcciones.registrarAccion($"El policia con placa {args.Arguments[0]} ha solicitado una revisión del archivo {archivo.getId()}");
            }
        }
    }

    public override void OnEntry(MethodExecutionArgs args)
    {
        if(args.Method.Name == "solicitarRevision"){
            var archivo = args.Instance as ArchivoPolicial;
            if (archivo != null)
            {
                Console.WriteLine("ASPECTO");
                RegistradorAcciones.registrarAccion($"El policia con placa {args.Arguments[0]} esta solicitando una revisión del archivo {archivo.getId()}");
            }
        }
    }

    public override void OnException(MethodExecutionArgs args)
    {
        var archivo = args.Instance as ArchivoPolicial;
        if (archivo != null)
        {
            if(args.Method.Name == "setFecha"){
                Console.WriteLine("ASPECTO");
                RegistradorAcciones.registrarAccion($"El policia con placa {args.Arguments[0]} ha producido un error al intentar cambiar la fecha del archivo {archivo.getId()}");
            } else {
                Console.WriteLine("ASPECTO");
                RegistradorAcciones.registrarAccion($"El policia con placa {args.Arguments[0]} ha intentado cambiar una fecha del juicio {archivo.getId()} sin conocer la clave");
            }
        }
    }
}

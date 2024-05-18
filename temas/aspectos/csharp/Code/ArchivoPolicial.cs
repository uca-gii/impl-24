public abstract class ArchivoPolicial{

    protected int idArchivo;
    public abstract void mostrarDetalles(int numPlaca);
    public abstract void solicitarRevision(int numPlaca);

    public int getId(){
        return idArchivo;
    }
}
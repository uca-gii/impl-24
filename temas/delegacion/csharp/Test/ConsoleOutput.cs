using System;
using System.IO;

// Clase para capturar la salida de la consola
public class ConsoleOutput : IDisposable
{
    private StringWriter stringWriter;
    private TextWriter originalOutput;

    public ConsoleOutput()
    {
        stringWriter = new StringWriter();
        originalOutput = Console.Out;
        Console.SetOut(stringWriter);
    }

    public string GetOutput()
    {
        return stringWriter.ToString().Trim();
    }

    public void Dispose()
    {
        stringWriter.Dispose();
        Console.SetOut(originalOutput);
    }
}

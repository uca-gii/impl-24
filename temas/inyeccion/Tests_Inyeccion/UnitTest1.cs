using NUnit.Framework;
using Moq;
using System;

namespace Tests_Inyeccion;

public class Tests
{
    private Mock<INotifier> mockNotifier;
    private Mock<ILogger> mockLogger;
    private OrderProcessor orderProcessor;

    [SetUp]
    public void Setup()
    {
        // Crear mocks de las dependencias
        mockNotifier = new Mock<INotifier>();
        mockLogger = new Mock<ILogger>();

        // Crear una instancia de OrderProcessor con las dependencias simuladas
        orderProcessor = new OrderProcessor(mockNotifier.Object, mockLogger.Object);
    }

    [Test]
    public void ProcessOrder_CallsSendNotification()
    {
        string orderId = "123";
        orderProcessor.ProcessOrder(orderId);
        mockNotifier.Verify(n => n.SendNotification(It.Is<string>(msg => msg.Contains(orderId))), Times.Once());
    }

    [Test]
    public void ProcessOrder_CallsLogTwice()
    {
        string orderId = "123";
        orderProcessor.ProcessOrder(orderId);
        mockLogger.Verify(l => l.Log(It.IsAny<string>()), Times.Exactly(2));
    }

    [Test]
    public void ProcessOrder_LogsOrderProcessingMessages()
    {
        string orderId = "123";
        orderProcessor.ProcessOrder(orderId);
        mockLogger.Verify(l => l.Log(It.Is<string>(msg => msg.Contains("Inicio del procesamiento del pedido"))), Times.Once());
        mockLogger.Verify(l => l.Log(It.Is<string>(msg => msg.Contains("procesado y notificado"))), Times.Once());
    }

    [Test]
    public void ProcessOrder_NullOrderId_ThrowsArgumentNullException()
    {
        Assert.Throws<ArgumentNullException>(() => orderProcessor.ProcessOrder(null));
    }

    [Test]
    public void ProcessOrder_SpecialOrderId_SendsPriorityNotification()
    {
        string specialOrderId = "VIP123";
        orderProcessor.ProcessOrder(specialOrderId);
        mockNotifier.Verify(n => n.SendNotification(It.Is<string>(msg => msg.Contains("VIP") && msg.Contains("procesado con prioridad"))), Times.Once());
    }

    [Test]
    public void ProcessOrder_NotifierThrowsException_LogsError()
    {
        string orderId = "123";
        mockNotifier.Setup(n => n.SendNotification(It.IsAny<string>())).Throws(new Exception("Error de notificación"));
        Assert.Throws<Exception>(() => orderProcessor.ProcessOrder(orderId));
        mockLogger.Verify(l => l.Log(It.Is<string>(msg => msg.Contains("Error de notificación"))), Times.Once());
    }

    [Test]
    public void ProcessOrder_Completes_CallsCleanup()
    {
        string orderId = "123";
        bool cleanupCalled = false;
        mockLogger.Setup(l => l.Log("Pedido procesado y notificado.")).Callback(() => cleanupCalled = true);
        orderProcessor.ProcessOrder(orderId);
        Assert.IsTrue(cleanupCalled, "Cleanup method was not called.");
    }
}

using NUnit.Framework;
using System.IO;

[TestFixture]
public class CombinedTests
{
    private StringWriter output;

    [SetUp]
    public void Setup()
    {
        output = new StringWriter();
        Console.SetOut(output);
    }

    [Test]
    public void TestEmailNotification()
    {
        INotifier emailNotifier = new EmailNotifier();
        NotificationManager manager = new NotificationManager(emailNotifier);
        manager.Notify("Test email");
        Assert.IsTrue(output.ToString().Contains("Enviando Email: Test email"));
    }

    [Test]
    public void TestSmsNotification()
    {
        INotifier smsNotifier = new SmsNotifier();
        NotificationManager manager = new NotificationManager(smsNotifier);
        manager.Notify("Test SMS");
        Assert.IsTrue(output.ToString().Contains("Enviando SMS: Test SMS"));
    }

    [Test]
    public void TestDoubleOperation()
    {
        Operations.Operation op = Operations.Double;
        Assert.AreEqual(10, op(5));
    }

    [Test]
    public void TestTripleOperation()
    {
        Operations.Operation op = Operations.Triple;
        Assert.AreEqual(15, op(5));
    }
}

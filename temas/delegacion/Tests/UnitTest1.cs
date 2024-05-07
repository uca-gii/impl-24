using NUnit.Framework;
using System;
using System.IO;

namespace C_
{
    [TestFixture]
    public class Tests
    {
        private StringWriter output;

        [SetUp]
        public void Setup()
        {
            output = new StringWriter();
            Console.SetOut(output);
        }

        [TearDown]
        public void TearDown()
        {
            output.Dispose();
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
        public void TestEmptyMessage()
        {
            INotifier emailNotifier = new EmailNotifier();
            NotificationManager manager = new NotificationManager(emailNotifier);
            manager.Notify("");
            // Asegúrate de que no se produzca una excepción al intentar notificar con un mensaje vacío
        }

        [Test]
        public void TestMaximumMessageLength()
        {
            INotifier emailNotifier = new EmailNotifier();
            NotificationManager manager = new NotificationManager(emailNotifier);
            string maxLengthMessage = new string('A', 255); // Mensaje con longitud máxima
            manager.Notify(maxLengthMessage);
            Assert.IsTrue(output.ToString().Contains("Enviando Email: " + maxLengthMessage));
        }

        [Test]
        public void TestLongMessage()
        {
            INotifier emailNotifier = new EmailNotifier();
            NotificationManager manager = new NotificationManager(emailNotifier);
            string longMessage = new string('A', 256); // Mensaje más largo que la longitud máxima permitida
            manager.Notify(longMessage);
            // Asegúrate de que el mensaje se trunque o maneje de manera adecuada
        }
    }
}

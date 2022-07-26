package enviando.email;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest{
	
	private String userName = "djailsonemailformacaojavaweb@gmail.com";
	private String senha = "ghhxumcpgrfrwate";
	
	@Test
    public void testeEmail() { /*Olhe as configurações do smtp do seu email*/
		
		try {
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.ssl.trust", "*");/*autenticar com a segurança ssl*/
		properties.put("mail.smtp.auth", "true");/*autorização*/
		properties.put("mail.smtp.starttls", "true");/*autenticação*/
		properties.put("mail.smtp.host", "smtp.gmail.com");/*servidor gmail google*/
		properties.put("mail.smtp.port", "465");/*Porta do servidor google*/
		properties.put("mail.smtp.socketFactory.port", "465");/*a porta a conectada pelo socket*/
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");/*Classe socket de conexão ao SMTP*/
		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(userName, senha);
			}
		});
		
		Address[] toUser = InternetAddress.parse("djailsonemailformacaojavaweb@gmail.com, djailson_silva1@outlook.com, djailson_silva1@hotmail.com");
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName, "Djailson Silva - JDev"));/*Quem esta eniando*/
		message.setRecipients(Message.RecipientType.TO, toUser);/*email de destino*/
		message.setSubject("Chegou e-mail enviado com java");/*assunto do e-mail*/
		message.setText("Olá programador, você acaba de receber um email enviado com java do curso Formação Java Web do Alex.");
		
		System.out.println("ola");
		
		
		Transport.send(message);
		
		Thread.sleep(5000);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}

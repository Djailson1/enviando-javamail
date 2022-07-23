package enviando.email;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	@Test
    public void testeEmail() { /*Olhe as configurações do smtp do seu email*/
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");/*autorização*/
		properties.put("mail.smtp.starttls", "true");/*autenticação*/
		properties.put("mail.host", "smtp.gmail.com");/*servidor gmail google*/
		properties.put("mail.smtp.port", "465");/*Porta do servidor google*/
		properties.put("mail.smtp.socketFactory.port", "465");/*a porta a conectada pelo socket*/
		properties.put("mail.smtp.socketFactory.class", "javax.net.sll.SLLSocketFactory");/*Classe socket de conexão ao SMTP*/
		
    }
    
}

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
	
	
	
	@Test
    public void testeEmail() throws Exception{ /*Olhe as configurações do smtp do seu email*/
		
		ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail(null, null, null, null);
		
		
		/*caso o email não esteja sendo enviado então coloque
		 * um tempo de espera porém isso só pode ser usado para testes*/
		
		
		
    }
    
}

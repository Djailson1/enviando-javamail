package enviando.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ObjetoEnviaEmail {
	
	private String userName = "djailsonemailformacaojavaweb@gmail.com";
	private String senha = "ghhxumcpgrfrwate";
	
	private String listaDestinatarios = "";
	private String nomeRemetente = "";
	private String assuntoEmail = "";
	private String textoEmail = "";
	
	public ObjetoEnviaEmail(String listaDestinatario, String nomeRemetente, String assuntoEmail, String textoEmail) {
		
		this.listaDestinatarios = listaDestinatario;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail = assuntoEmail;
		this.textoEmail = textoEmail;
	
	}
	
	public void EnviarEmail() throws Exception{
		
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
		
		Address[] toUser = InternetAddress.parse(listaDestinatarios);
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName, nomeRemetente));/*Quem esta eniando*/
		message.setRecipients(Message.RecipientType.TO, toUser);/*email de destino*/
		message.setSubject(assuntoEmail);/*assunto do e-mail*/
		message.setText(textoEmail);
		
		
		
		
		Transport.send(message);
	}

}

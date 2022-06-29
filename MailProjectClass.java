import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;



public class MailProjectClass {
//-----------------------------------------------------------------------------------------------------
                        //MODIFY THOSE PARAMETERS
    public static final String EMAIL = "denisco.dp5@gmail.com";
    public static final String EMAIL_OBJECT = "Curriculum vitae di Denis Constantin Petrisor - Allegato leggibile";
    public static final String CURRICULUM_PATH = "./curriculum/curriculum.pdf"; //the pat where your curriculum is
    public static final String NAME_OF_FILE = "Curriculum Vitae Denis Constantin Petrisor.pdf"; // The name of the file in the attachment of the mail
    /**
    * To create a new line type \n
    */
    public static final String EMAIL_BODY_TEXT = "Alla cortese attenzione della/del Responsabile Risorse Umane\n\nBuongiorno\n\nSono Denis Constantin Petrisor e ho trovato il vostro contatto online e vi scrivo per candidarmi come programmatore.\nHo esperienza nella programmazione (Javascript/ HTML/ CSS / ExtJS), utilizzo di chiamate REST, versionamento del codice GIT.\nAllego il mio curriculm aggiornato con un elenco più completo.\n\nIl mio desiderio è entrare in un'azienda che abbia come stack tecnologico uno o più dei seguenti:\nReact, Next.js, Redux, GraphQL per poter fare esperienza e mettere a disposione quella già in mio possesso.\n\nLascio anche il mio profilo Linkedin https://www.linkedin.com/in/denis-petrisor-bb6921100/\n\nNel caso di un riscontro positivo potete rispondere a questa mail o contattarmi in uno dei recapiti lasciati nel curriculum.\n\nVi auguro buona giornata.\n- Denis Constantin Petrisor\n";
//----------------------------------------------------------------------------------------------------

	public MailProjectClass(){
        
	}
public static Session init(String email,String passw){

	final String username = email;
    final String password = passw;

    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
    return session;
}
	
public static void sendMail(Session session, String dest) {


    try {

        Message message = new MimeMessage(session);
        
        message.setFrom(new InternetAddress(EMAIL));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(dest));
        message.setSubject(EMAIL_OBJECT);
	//	message.setContent("<body><h2>Buongiorno<h2></br><p>Mando il mio curriculum vitae</p></body>","text/html; charset=utf-8");
	//	message.setText("Buongiorno, allego il mio curricula");
	//	Transport.send(message);
        
        
        Multipart multipart = new MimeMultipart();

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        String file = CURRICULUM_PATH;
        String fileName = NAME_OF_FILE;
        DataSource source = new FileDataSource(file);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(fileName);
        messageBodyPart.addHeader("Content-Type", "application/octet-stream");
        
        
        multipart.addBodyPart(messageBodyPart);
		
		//-----------------------------------//
					//added by me//
		messageBodyPart = new MimeBodyPart();
		messageBodyPart.setText(EMAIL_BODY_TEXT);
		
		
		
		multipart.addBodyPart(messageBodyPart);				
		//-----------------------------------//
		
        message.setContent(multipart);
        
	//	message.setText("Con la presente si invia il curriculum di Denis Constantin Petrisor");
		
        System.out.println("Sending");

        Transport.send(message);

        System.out.println("Done");

    } catch (MessagingException e) {
        e.printStackTrace();
    }
  }
}

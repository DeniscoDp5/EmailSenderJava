import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;



public class MailProjectClass {
//-----------------------------------------------------------------------------------------------------
                        //MODIFY THOSE PARAMETERS
    public static final String EMAIL = "gino@gino.com";
    public static final String EMAIL_OBJECT = "Curriculum vitae di Gino";
    public static final String CURRICULUM_PATH = "/home/user/Scrivania/CV_Radu_Cebotaru.pdf"; //the pat where your curriculum is
    public static final String NAME_OF_FILE = "Curriculum Vitae Gino Balducci"; // The name of the file in the attachment of the mail
    /**
    * To create a new line type \n
    */
    public static final String EMAIL_BODY_TEXT = "Alla cortese attenzione della/del Responsabile Risorse Umane\n\nMi chiamo Gino Balducci, ho 20 anni e frequento il 1° anno del corso post diploma I.T.S. manutenzione aeronautica al Malignani di Udine.\n\nDopo un lungo periodo lavorativo nel campo dei service teatrali ho deciso di cambiare e di avvicinarmi di più al settore nel quale pratico gli studi.\n\nCome studente ho realizzato vari progetti utilizzando diverse lavorazioni meccaniche.\n\nAttualmente sono alla ricerca di un opportunità lavorativa nella quale io possa dare le mie conoscenze attuali ed il mio desiderio di imparare ai fini della mission aziendale e di una crescita professionale personale.\n\nRingrazio molto per l'attenzione e sono disponibile ";
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
        messageBodyPart.addHeader("Content-Type", "application/pdf");
        
        
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

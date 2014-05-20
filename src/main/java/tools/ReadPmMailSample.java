package tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;
 
public class ReadPmMailSample {
    Properties properties = null;
    private Session session = null;
    private Store store = null;
    private Folder inbox = null;
    private String userName = "evoportal.pm3@evozon.com";// provide user name
    private String password = ":gW.343F!8Q..";// provide password
    public String alfa;
    public ReadPmMailSample() {
 
    }
 
    public void readMails() {
    	String alfa;
    	
        properties = new Properties();
        properties.setProperty("mail.host", "mail.evozon.com");
        properties.setProperty("mail.port", "993");
        properties.setProperty("mail.transport.protocol", "imaps");
        session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, password);
                    }
                });
        try {
            store = session.getStore("imaps");
            store.connect();
            inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message messages[] = inbox.search(new FlagTerm(
                    new Flags(Flag.SEEN), false));
            ;
            System.out.println("Number of mails = " + messages.length);
            for (int i = messages.length-1; i < messages.length; i++) {
                Message message = messages[i];
                Address[] from = message.getFrom();
                System.out.println("-------------------------------");
                System.out.println("Date : " + message.getSentDate());
                System.out.println("From : " + from[0]);
                System.out.println("Subject: " + message.getSubject());
                System.out.println("Content :");
                processMessageBody(message);
                System.out.println("--------------------------------");
 
            }
            inbox.close(true);
            store.close();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
   
 
    public void processMessageBody(Message message) {
        try {
            Object content = message.getContent();
            // check for string
            // then check for multipart
            if (content instanceof String) {
                System.out.println(content);
                alfa = (String) content;
            } else if (content instanceof Multipart) {
                Multipart multiPart = (Multipart) content;
                procesMultiPart(multiPart);
            } else if (content instanceof InputStream) {
                InputStream inStream = (InputStream) content;
                int ch;
                while ((ch = inStream.read()) != -1) {
                    System.out.write(ch);
                }
 
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
 
    public void procesMultiPart(Multipart content) {
 
        try {
            int multiPartCount = content.getCount();
            for (int i = 0; i < multiPartCount; i++) {
                BodyPart bodyPart = content.getBodyPart(i);
                Object o;
 
                o = bodyPart.getContent();
                if (o instanceof String) {
                    System.out.println(o);
                } else if (o instanceof Multipart) {
                    procesMultiPart((Multipart) o);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
 
    }
 
  public void readLastMail(){
	  
	  int contentInteger;
	  String subject;
	  String subjectText ="You have submitted a new Vacation Request";
	  String StartDate;
	  String ContentStartDate;
	 
	  String EndDate;
	  
	  properties = new Properties();
      properties.setProperty("mail.host", "mail.evozon.com");
      properties.setProperty("mail.port", "993");
      properties.setProperty("mail.transport.protocol", "imaps");
      session = Session.getInstance(properties,
              new javax.mail.Authenticator() {
                  protected PasswordAuthentication getPasswordAuthentication() {
                      return new PasswordAuthentication(userName, password);
                  }
              });
      try {
          store = session.getStore("imaps");
          store.connect();
          inbox = store.getFolder("INBOX");
          inbox.open(Folder.READ_ONLY);
         
          Message messages[] = inbox.search(new FlagTerm(
                  new Flags(Flag.SEEN), false));
          ;
          System.out.println("Number of mails = " + messages.length);
         
              Message message = messages[messages.length-1];
              Address[] from = message.getFrom();
              System.out.println("-------------------------------");
              System.out.println("Date : " + message.getSentDate());
              System.out.println("From : " + from[0]);
              System.out.println("Subject: " + message.getSubject());
              subject = message.getSubject();
//              System.out.println("Subject is: " + subject);
              System.out.println("Content :");
              processMessageBody(message);
              
              
              System.out.println("--------------------------------");
//              System.out.println(content);

              
//              DE AICI E FACUT SA VEDEM DACA E BINE
//              START DATE STRING
              StringBuilder sb1 = new StringBuilder();
              contentInteger = tools.StringUtils.getAllIntegerNumbersFromString(alfa).get(0);
              sb1.append(contentInteger);
              sb1.append("/");
              contentInteger = tools.StringUtils.getAllIntegerNumbersFromString(alfa).get(1);
              sb1.append(contentInteger);
              sb1.append("/");
              contentInteger = tools.StringUtils.getAllIntegerNumbersFromString(alfa).get(2);
              sb1.append(contentInteger);
              
              System.out.println(sb1);
              
//              END DATE STRING
              StringBuilder sb2 = new StringBuilder();
              contentInteger = tools.StringUtils.getAllIntegerNumbersFromString(alfa).get(3);
              sb2.append(contentInteger);
              sb2.append("/");
              contentInteger = tools.StringUtils.getAllIntegerNumbersFromString(alfa).get(4);
              sb2.append(contentInteger);
              sb2.append("/");
              contentInteger = tools.StringUtils.getAllIntegerNumbersFromString(alfa).get(5);
              sb2.append(contentInteger);
              
              System.out.println(sb2);
              
              
              
          if(subject.toLowerCase().trim().equals(subjectText.toLowerCase().trim())){
        	  System.out.println("Subject is good");
        	  
        	
        		  
        	  
        	  
          }
              
              
              
          inbox.close(true);
          store.close();
      } catch (NoSuchProviderException e) {
          e.printStackTrace();
      } catch (MessagingException e) {
          e.printStackTrace();
      }
      
      
     
  }
  
  
  public void checkContent(){
//
  }
    
    
    
    public static void main(String[] args) {
        ReadPmMailSample sample = new ReadPmMailSample();
        sample.readLastMail();
    }
 
}
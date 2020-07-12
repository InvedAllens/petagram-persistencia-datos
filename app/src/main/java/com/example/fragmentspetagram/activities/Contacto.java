package com.example.fragmentspetagram.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.fragmentspetagram.R;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Contacto extends AppCompatActivity {
    private TextView etPara,etAsunto,etMensaje;
    public static final String sUsuario="gittestaldo@gmail.com";;
    public static final String sContrasena="gittest2020";;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        Toolbar toolbar=findViewById(R.id.my_toolbar_contacto);
        if(toolbar!=null){
            setSupportActionBar(toolbar);
        }
        etPara=findViewById(R.id.et_para);
        etAsunto=findViewById(R.id.et_asunto);
        etMensaje=findViewById(R.id.et_mensaje);
        Button btnEnviar = findViewById(R.id.btn_enviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 //Getting content for email
                 String email = etPara.getText().toString().trim();
                 String subject = "PETAGRAM Inc";
                 String message = "Estimado " + etAsunto.getText().toString().trim() + ":\n" +  etMensaje.getText().toString().trim();

                 //Creating SendMail object
                 SendMail sendMail = new SendMail(Contacto.this, email, subject, message);

                 //Executing sendmail to send email
                 sendMail.execute();
             }


         });
    }
   private class SendMail  extends AsyncTask<Void,Void,Void> {
       //Declaring Variables
       private Context context;
       private Session session;

       //Information to send email
       private String email;
       private String subject;
       private String message;

       //Progressdialog to show while sending email
       private ProgressDialog progressDialog;

       public SendMail(Context context, String email, String subject, String message) {
           this.context = context;
           this.email = email;
           this.subject = subject;
           this.message = message;
       }

       @Override
       protected void onPreExecute() {
           super.onPreExecute();
           //Showing progress dialog while sending email
           progressDialog = ProgressDialog.show(context,"Sending message","Please wait...",false,false);
       }

       @Override
       protected void onPostExecute(Void aVoid) {
           super.onPostExecute(aVoid);
           //Dismissing the progress dialog
           progressDialog.dismiss();
           //Showing a success message
           Toast.makeText(context,"Email Enviado",Toast.LENGTH_LONG).show();
       }

       @Override
       protected Void doInBackground(Void... params) {
           //Creating properties
           Properties properties = new Properties();

           //Configuring properties for gmail
           //If you are not using gmail you may need to change the values
           properties.put("mail.smtp.host", "smtp.gmail.com");
           properties.put("mail.smtp.socketFactory.port", "465");
           properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
           properties.put("mail.smtp.auth", "true");
           properties.put("mail.smtp.port", "465");

           //creando session
           session = Session.getDefaultInstance(properties, new javax.mail.Authenticator(){
               //autenticar password
               protected PasswordAuthentication getPasswordAuthentication(){
                   return new PasswordAuthentication(sUsuario, sContrasena);
               }
           });

           try {
               //Creating MimeMessage object
               MimeMessage mimeMessage = new MimeMessage(session);

               //Setting sender address
               mimeMessage.setFrom(new InternetAddress(sUsuario));
               //Adding receiver
               mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
               //Adding subject
               mimeMessage.setSubject(subject);
               //Adding message
               mimeMessage.setText(message);

               //Sending email
               Transport.send(mimeMessage);

           } catch (MessagingException e) {
               e.printStackTrace();
           }

           return null;
       }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_contacto,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.exit_contacto) {
            finish();
        }
        return true;
    }
}
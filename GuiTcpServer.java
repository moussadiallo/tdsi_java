
 

package guitcpserver;


import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;





/**
 *
 * @author moussa
 */
public class GuiTcpServer extends JFrame implements ActionListener{
    TextArea ta=new TextArea (20,40);
    JTextField tf=new JTextField(34);
    JButton b=new JButton("Envoyer");
    static PrintWriter sw =null;
    static BufferedReader sr=null;
    GuiTcpServer(){
        try{
            ServerSocket ss=new ServerSocket(1234);
            Socket s=ss.accept();
            System.out.println("Connecter au client");
            sw=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            this.setBounds(0,0,500,400);
            this.setLayout(new FlowLayout());
            this.add(ta);
            this.add(tf);
            this.add(b);
            ta.setEditable(false);
            b.addActionListener(this);
            tf.addActionListener(this);
            this.setVisible(true);
            while(true){
                ta.append("Message:"+sr.readLine()+ '\n');
            }
            } catch(Exception e){
                    
                }
        }
                
        public static void main(String args[]){
            GuiTcpServer f=new GuiTcpServer();
        }
    public void actionPerformed(ActionEvent ae){
        String msg=tf.getText();
        sw.println(msg);
        sw.flush();
        ta.append(msg+'\n');
        tf.setText("");
        
    }
    
}

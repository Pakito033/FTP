import java.io.*;
import java.net.Socket;
import javax.swing.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket=new Socket("localhost", 9852);
        JFrame jf=new JFrame();
        JFileChooser jfc=new JFileChooser("./test.ok");
        jfc.showDialog(jf, "Select");
        File file=jfc.getSelectedFile();
        long length=file.length();
        if (length>Integer.MAX_VALUE) {
            System.out.print("File size is too big");
        }
        byte[] bytes=new byte[(int) length  ];
        InputStream in=new FileInputStream(file);
        OutputStream out=socket.getOutputStream();
        int count=in.read(bytes);
        while(count>0){
            out.write(bytes, 0, count);
        }
        in.close();
        out.close();
        socket.close();
    }
}

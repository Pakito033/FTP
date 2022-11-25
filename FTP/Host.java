import java.net.*;
import java.io.*;

public class Host {
    public static void main(String[] args) throws Exception {
        ServerSocket server=new ServerSocket(9852);
        Socket socket=server.accept();
        InputStream in=socket.getInputStream();
        OutputStream out=new FileOutputStream("");
        byte[] bytes=new byte[16*1024];
        int count=in.read(bytes);
        while(count>0){
            out.write(bytes, 0, count);
        }
        int i=0;
        while((i=in.read())!=-1){
            System.out.print((char)i);
        }    
        in.close();
        server.close();
    }   
}

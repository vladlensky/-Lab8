import classes.NormalHuman;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

/**
 * Created by bespa on 25.05.2017.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        NormalHuman human = new NormalHuman("test");
        String s = gson.toJson(human);
        Socket socket = new Socket("192.168.43.39", 7000);
        Socket secondSocket = new Socket("192.168.43.39", 7001);
        OutputStream socketOS = socket.getOutputStream();
        InputStream socketIS = socket.getInputStream();
        DataInputStream dis = new DataInputStream(socketIS);
        DataOutputStream dos = new DataOutputStream(socketOS);
        Message mes1 = new Message(ConnectionState.NEED_DATA);
        mes1.maxID=-10;
        mes1.clearData();
        String mesOut = gson.toJson(mes1);
        byte sizeOut = (byte) Math.ceil((double) (mesOut.getBytes().length + 1) / (double) 512);
        byte[] buf = new byte[mesOut.getBytes().length + 1];
        buf[0] = sizeOut;
        System.arraycopy(mesOut.getBytes(), 0, buf, 1, mesOut.getBytes().length);
        dos.write(buf);
        Message message = new Message(ConnectionState.NEW_DATA);
        message.maxID=100;
        message.clearData();
        message.setTypeOfOperation(Message.add);
        dos.writeBoolean(true);
        LinkedList<NormalHuman> humans = new LinkedList<>();
        humans.add(human);
        message.setData(humans);
        String mes = gson.toJson(message);
        byte sizeOut2 = (byte) Math.ceil((double) (mes.getBytes().length + 1) / (double) 512);
        byte[] buf2 = new byte[mes.getBytes().length + 1];
        buf2[0] = sizeOut2;
        System.arraycopy(mes.getBytes(), 0, buf2, 1, mes.getBytes().length);
        dos.write(buf2);
        dos.flush();
    }
}

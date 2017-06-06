import classes.NormalHuman;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by Mugenor on 15.05.2017.
 */
public class AnotherConnection extends Thread {
    private Socket socket;
    private ObjectInputStream dis;
    private ByteArrayInputStream bais;
    private InputStream socketIS;
    private Gson gson;
    private Message message;
    private LinkedList<NormalHuman> list;
    private CollectTable collt;
    public AnotherConnection(Socket socket, LinkedList<NormalHuman> list, CollectTable collt)throws IOException{
        this.socket=socket;
        gson = new GsonBuilder().addDeserializationExclusionStrategy(new GsonDeserializeExclusion()).create();
        this.list = list;
        this.collt = collt;
        socketIS = socket.getInputStream();
    }
    public void run(){
        try {
            while (true) {
                int size = socketIS.read();
                if(size>0) {
                    byte[] mes = new byte[size * 512];
                    socketIS.read(mes);
                    bais = new ByteArrayInputStream(mes);
                    dis = new ObjectInputStream(bais);
                    message = (Message) dis.readObject();
                    bais.close();
                    dis.close();
                    if (message.getState() == ConnectionState.ERROR) {
                        new Dialog("Sorry, something went wrong.\n Your changes didn't save!", Interface.getColor());
                        System.exit(1);
                    } else if (message.getState() == ConnectionState.NEED_DATA) {
                        synchronized (list) {
                            synchronized (collt) {
                                System.out.println(message);
                                Interface.notEditable = message.getNotEditable();
                                list = new LinkedList<>(message.getData());
                                Interface.filtercoll = new LinkedList<>(message.getData());
                                collt.removeAll();
                                for (int i = 0; i < list.size(); i++) {
                                    String[] obj = {list.get(i).getName(), list.get(i).getAge().toString(), list.get(i).getTroublesWithTheLaw().toString()};
                                    collt.addData(obj);
                                }
                                Interface.message.maxID = message.maxID;
                            }
                        }
                    } else if (message.getTypeOfOperation() == Message.add) {
                        synchronized (list) {
                            synchronized (collt) {
                                list.add(message.getData().get(0));
                                Interface.filtercoll.add(message.getData().get(0));
                                collt.addData(message.getData().get(0));
                                Interface.message.maxID = message.maxID;
                            }
                        }
                    } else if (message.getTypeOfOperation() == Message.delete) {
                        synchronized (list) {
                            synchronized (collt) {
                                System.out.println(list);
                                System.out.println(message.getData().get(0));
                                collt.removeData(Interface.filtercoll.indexOf(message.getData().get(0)));
                                list.remove(message.getData().get(0));
                                Interface.filtercoll.remove(message.getData().get(0));
                                Interface.message.maxID = message.maxID;
                            }
                        }
                    } else if (message.getTypeOfOperation() == Message.change) {
                        synchronized (list) {
                            synchronized (collt) {
                                synchronized (Interface.notEditable) {
                                    Interface.notEditable = new HashSet<>(message.getNotEditable());
                                    boolean notChanged = true;
                                    int i = 0;
                                    while (notChanged) {
                                        if (message.getData().get(0).getId() == list.get(i).getId()) {
                                            list.set(i, message.getData().get(0));
                                            collt.editData(message.getData().get(0), i);
                                            notChanged = false;
                                        }
                                        if(message.getData().get(i).getId() == Interface.filtercoll.get(i).getId()){
                                            Interface.filtercoll.set(i, message.getData().get(0));
                                            collt.editData(message.getData().get(0), i);
                                            notChanged=false;
                                        }
                                        if (i >= list.size()) notChanged = false;
                                        i++;
                                    }
                                    Interface.message.maxID = message.maxID;
                                }
                            }
                        }
                    } else if (message.getTypeOfOperation() == Message.notEdit) {
                        Interface.notEditable = new HashSet<>(message.getNotEditable());
                    }
                }
            }
        }
        catch(SocketException e) {
            new Dialog("Разрыв соединения!Сервер отключён!",Interface.getColor());
            System.exit(1);
        } catch(Exception e){e.printStackTrace();}
    }
}

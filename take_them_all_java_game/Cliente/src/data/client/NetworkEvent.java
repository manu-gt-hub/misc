package data.client;

import java.awt.AWTEvent;

/*captador de eventos de red*/
public class NetworkEvent extends AWTEvent{

    public String message;

    public static final int NETWORK_MESSAGE_RECEIVED = 2000;
    public static final int NETWORK_DISCONNECTED = 2001;

    public NetworkEvent(Object source, int id, String message){
        super(source, id);
        this.message = message;
    }

    

}

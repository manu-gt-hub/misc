
package data.client;

public interface NetworkListener
{
    public void networkMessageReceived(NetworkEvent e);
    public void networkDisconnected(NetworkEvent e);
}

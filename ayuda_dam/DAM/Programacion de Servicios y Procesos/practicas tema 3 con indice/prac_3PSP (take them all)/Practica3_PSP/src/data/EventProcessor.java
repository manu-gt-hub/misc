/*
 Esta clase procesa cada evento de cliente (click de ratón)
 Estos eventos se almacenan en una lista que luego es procesada
 */

package data;

import java.awt.*;
import java.util.*;

public class EventProcessor
{
    public EventProcessor(EventProcessable handler)
    {
        eventList = new LinkedList();
        this.handler = handler;
    }

    public void addEvent(AWTEvent event)
    {
        synchronized(eventList)
        {
            eventList.add(event);
        }
    }

    public void processEventList()
    {
        AWTEvent event;

        while(eventList.size() > 0)
        {
            synchronized(eventList)
            {
                event = (AWTEvent) eventList.removeFirst();
            }

            handler.handleEvent(event);
        }
    }

    private LinkedList eventList;
    private EventProcessable handler;
}

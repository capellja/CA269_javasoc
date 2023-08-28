/**
 * This program implements a simplified social network call JavaSoc which implements the
 * interfaces below and utilises objects to represent users, inboxes/outboxes, and representations
 * of activities that would occur in a social network app, eg. Follow, Post.
 * ClientApp.demo() returns all the features of the implementations
 * and showcases how I have implemeted different requirements.
 * 
 * @author
 * James Capellan
 * james.capellan2@mail.dcu.ie
 * Student no: 21477856
 */

import java.util.LinkedList;

interface Activity {
    String getURI();
}

/* receives a message and adds it to the Inbox */
interface ReceiveMessage {
    // returns a success / failure message
    boolean receive(Activity activity);
}

/* removes and retrieves the next message from inbox */
interface ReadNextMessage {
    // returns an Activity, or null if there are no messages
    Activity readNext();
}

/* provides inbox functionality */
interface Inbox extends ReceiveMessage, ReadNextMessage {
    // returns count of unread messages in inbox
    int getCount();

    LinkedList<Activity> getInboxActivities();
}

/* sends a message and adds it to the Outbox */
interface SendMessage {
    boolean send(Activity activity);
}

/* removes and delivers the next message from inbox */
interface DeliverNextMessage {
    // returns an Activity, or null if there are no messages
    Activity deliverNext();
}

/* provides outbox functionality */
interface Outbox extends SendMessage, DeliverNextMessage {
    // returns count of unsent messages in outbox
    int getCount();
}

/* the client App that handles inboxes and outboxes */
interface App {
    Inbox getInbox(); // retrieves the inbox
    Outbox getOutbox(); // retrievs the outbox
    String demo(); // prints a demo of the app in action
}

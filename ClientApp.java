/**
 * This class implements the App interface and provides a demo of how to use it.
 * It creates two Person objects with associated inbox and outbox objects, and adds
 * a CreateActivity and a FollowActivity to their outboxes and inboxes, respectively.
 */
public class ClientApp implements App {
    private Person person;

    @Override
    /**
     * Returns the inbox of the associated Person object.
     *
     * @return the inbox of the associated Person object
     */
    public Inbox getInbox() {
        return person.getInbox();
    }

    /**
     * Returns the outbox of the associated Person object.
     *
     * @return the outbox of the associated Person object
     */
    @Override
    public Outbox getOutbox() {
        return person.getOutbox();
    }

    /**
     * Creates two Person objects with associated inbox and outbox objects.
     * CreateActivity and a FollowActivity are created respectively to show their methods.
     * Prints out messages related to these actions.
     *
     */
    @Override
    public String demo() {

        /**
         * Create instance of person class, 'Jerry' with data.
         * Create instance of Userinbox and Useroutbox class for use.
         */
        Person Jerry = new Person("https://app.com/jerrycan101", "Jerry", "Jerrycan101", "Hello, world!", null, null, null, null, null);
        UserInbox JerryInbox = new UserInbox(); // create inbox 
        UserOutbox JerryOutbox = new UserOutbox();  // create outbox

        // print for visuals
        System.out.println(Jerry.getName() + " added");
        System.out.println(Jerry);  // return toString for URI and Username.

        /**
         * same as above, but for second person, 'Tom'.
         * (the reference is there, yes ;)
         */
        Person Tom = new Person("https://app.com/tommygun444", "Tom", "Tommygun444", "Goodbye, world!", null, null, null, null, null);
        UserInbox TomInbox = new UserInbox();   // ...
        UserOutbox TomOutbox = new UserOutbox();    // ...

        System.out.println(Jerry.getName() + " added");
        System.out.println(Jerry);  // return toString for URI and Username.

        /**
         * Create StreamObject instance for Post activity with supplemented data.
         * Return toString method of POST to display all data
         * send activity to Outbox
         */
        StreamObject Post = new CreateActivity("https://app.com/jerrycan101/post", "GLOBAL", 0, 0, "This is the first post in Javaverse!", "First Post!", "2023-03-16T16:00:00", false);
        System.out.println("\n" + Jerry.getName() +  " adds a CreateActivity to Outbox");
        System.out.println(Post);
        JerryOutbox.send(Post); // send post activity to outbox

        // Outbox delivery
        System.out.println(Jerry.getName() + "Outbox delivery");
        System.out.println("- " + Post.getURI() + " posted" + "\n");

        /**
         * Create StreamObject instance for Follow activity with supplemented data.
         * Return toString for FOLLOW to show two users and URI of activity.
         * Send to one outbox, receive in the inbox of the other.
         */
        StreamObject Follow = new FollowActivity("https://app.com/jerrycan101/follow", Jerry, Tom);
        System.out.println(Jerry.getName() + " adds a FollowActivity to Outbox");
        System.out.println(Follow + "\n");
        JerryOutbox.send(Follow);   // send follow activity to outbox
        TomInbox.receive(Follow);   // receive follow activity in inbox

        // Outbox delivery
        System.out.println(Jerry.getName() + " Outbox delivery");
        System.out.println("- " + Follow.getURI());
        System.out.println("- added " + Tom.getURI() + " to following list" + "\n");
        
        // Inbox delivery
        System.out.println(Tom.getName() + " Inbox delivery");
        System.out.println("-" + Follow.getURI() + "\n");
        
        /**
         * Print UserInbox.readNext() to show the latest activity added to inbox,
         */ 
        System.out.println(Tom.getName() + " reads a FollowActivity from Inbox");
        System.out.println(TomInbox.readNext());

        // testing
        //System.out.println(JerryInbox.getInboxActivities());
        //System.out.println(JerryOutbox.getOutboxActivities());
        return ("End");
    }

    /**
     * main method to create ClientApp instance and show demo().
     */
    public static void main(String[] args) {
        ClientApp test = new ClientApp();
        System.out.println(test.demo());
        
    }
}
import java.util.LinkedList;

/**
 * The Person class represents a user on a social network.
 * It stores the user's URI, name, preferred username, summary, inbox, outbox, followers, following, and liked users.
 */
public class Person {
    private String URI;
    private String name;
    private String preferredUsername;
    private String summary;
    Inbox inbox;
    Outbox outbox;
    private LinkedList<Person> followers;
    private LinkedList <Person> following;
    private LinkedList <Person> liked;

    /**
     * Constructor for creating a new person.
     * @param URI - The unique identifier for the person.
     * @param name - The name of the person.
     * @param preferredUsername - The preferred username of the person.
     * @param summary - The summary of the person's profile.
     * @param inbox - The person's inbox.
     * @param outbox - The person's outbox.
     * @param followers - A list of people who follow the person.
     * @param following - A list of people the person follows.
     * @param liked - A list of people the person likes.
     */
    public Person(String URI, String name, String preferredUsername, String summary, UserInbox inbox, UserOutbox outbox, LinkedList <Person> followers, LinkedList <Person> following, LinkedList <Person> liked) {
        this.URI = URI;
        this.name = name;
        this.preferredUsername = preferredUsername;
        this.summary = summary;
        this.inbox = new UserInbox();
        this.outbox = new UserOutbox();
        this.followers = new LinkedList<Person>();
        this.following = new LinkedList<Person>();
        this.liked = new LinkedList<Person>();
    }

    //Getters and Setters
    //region

    /**
     * Returns the name of the person.
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the URI of the person.
     * @param uRI - The new URI for the person.
     */
    public String getURI() {
        return URI;
    }
    
    /**
     * Sets the name of the person.
     * @param name - The new name for the person.
     */
    public void setURI(String uRI) {
        URI = uRI;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreferredUsername() {
        return preferredUsername;
    }

    public void setPreferredUsername(String preferredUsername) {
        this.preferredUsername = preferredUsername;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Inbox getInbox() {
        return inbox;
    }

    public void setInbox(Inbox inbox) {
            this.inbox = (UserInbox) inbox;
    }

    public Outbox getOutbox() {
        return outbox;
    }

    public void setOutbox(Outbox outbox) {
        this.outbox = (UserOutbox) outbox;
    }

    public LinkedList<Person> getFollowers() {
        return followers;
    }

    public void setFollowers(LinkedList<Person> followers) {
        this.followers = followers;
    }

    public LinkedList<Person> getFollowing() {
        return following;
    }

    public void setFollowing(LinkedList<Person> following) {
        this.following = following;
    }

    public LinkedList<Person> getLiked() {
        return liked;
    }

    public void setLiked(LinkedList<Person> liked) {
        this.liked = liked;
    }

    /**
     * toString method to return URI and Username for demo
     */
    @Override
    public String toString() {
        return 
        "- URI: " + getURI() + "\n" +
        "- name: " + getPreferredUsername()
        ;
    }

    //endregion

    /**
     * main method to create an instance of the Person class and intialize test values.
     * Used for mainly for testing of Person instance.
     * @param args
     */
    public static void main(String[] args) {
        Person alice = new Person("https://Alice","Alice", "alice@example.com", "Hello, world!", null, null, null, null, null);
    
        System.out.println("URI: " + alice.getURI());
        System.out.println("Name: " + alice.getName());
        System.out.println("Preferred Username: " + alice.getPreferredUsername());
        System.out.println("Summary: " + alice.getSummary());
        System.out.println("Inbox: " + alice.getInbox());
        System.out.println("Outbox: " + alice.getOutbox());
        System.out.println("Followers: " + alice.getFollowers());
        System.out.println("Following: " + alice.getFollowing());
        System.out.println("Liked: " + alice.getLiked());
    }
}
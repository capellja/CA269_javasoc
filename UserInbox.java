import java.util.LinkedList;

/**
 * UserInbox is an implementation of the Inbox interface that represents a user's inbox.
 * It containts a list of activities that the user has received and has not yet read.
 */
class UserInbox implements Inbox {

    private String URI;
    private LinkedList<Activity> inboxActivities;

        /**
     * Constructor for UserInbox class.
     * Initializes the linked list for inboxActivities.
     */
    public UserInbox() {
        this.inboxActivities = new LinkedList<Activity>();
    }

     /**
    * Adds the provided activity to the end of the inboxActivities linked list if the provided activity is not null.
    * @param activity the activity to be added to the inbox
    * @return true if the activity is added to the inbox, false otherwise
    */
    @Override
    // recieve activity
    public boolean receive(Activity activity) {
        if (activity != null) {
            inboxActivities.add(activity);
            return true;
        }
        return false;
    }

    /**
     * Returns the next activity in the inboxActivities linked list and removes it from the list.
     * @return the next activity in the inbox or null if the list is empty
     */
    @Override
    public Activity readNext() {
        if (inboxActivities.size() > 0) {
            Activity activity = inboxActivities.get(0);
            inboxActivities.remove(0);
            return activity;
        }
        return null;
    }


     /**
     * Returns the number of activities in the inboxActivities linked list.
     * @return the number of activities in the inbox
     */
    @Override
    public int getCount() {
        return inboxActivities.size();
    }

    // region
    // Getters + setters

    /**
     * Returns the URI of the user.
     * @return the URI of the user
     */
    public String getURI() {
        return URI;
    }

    /**
     * Sets the URI of the user.
     * @param uRI the URI to be set for the user
     */
    public void setURI(String uRI) {
        URI = uRI;
    }

    /**
     * Returns the list of activities in the inbox.
     * @return the list of activities in the inbox
     */
    public LinkedList<Activity> getInboxActivities() {
        return inboxActivities;
    }

    /**
     * Sets the list of activities in the inbox.
     * @param inboxActivities the list of activities to be set for the inbox
     */
    public void setInboxActivities(LinkedList<Activity> inboxActivities) {
        this.inboxActivities = inboxActivities;
    }
    //endregion
    
}
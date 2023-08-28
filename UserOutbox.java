import java.util.LinkedList;

/**
 * UserOutbox is an implementation of the Outbox interface that represents a user's Outbox.
 * It containts a list of activities that the user has completed and is now sharing.
 */
class UserOutbox implements Outbox {

    private String URI;
    private LinkedList<Activity> outboxActivities;

       /**
     * Constructor for UserOutbox class.
     * Initializes the linked list for outboxActivities.
     */
    public UserOutbox() {
        outboxActivities = new LinkedList<Activity>();
    }

    /**
    * Adds the provided activity to the end of the OutboxActivities linked list if the provided activity is not null.
    * @param activity the activity to be added to the outbox
    * @return true if the activity is added to the outbox, false otherwise
    */
    @Override
    public boolean send(Activity activity) {
        if (activity != null) {
            outboxActivities.add(activity);
            return true;
        }
        return false;
    }

    /**
     * Returns the next activity in the outboxactivties linked list and removes it from the list.
     * @return the next activity in the outbox or null if the list is empty
     */
    @Override
    public Activity deliverNext() {
        if (outboxActivities.isEmpty()) {
            return null;
        } else {
            Activity activity = outboxActivities.get(0);
            outboxActivities.remove(0);
            return activity;
        }
    }

     /**
     * Returns the number of activities in the outboxactivities linked list.
     * @return the number of activities in the outbox
     */
    @Override
    public int getCount() {
        return outboxActivities.size();
    }

    //region getters + setters

    /**
     * Returns the URI of the user.
     * @return the URI of the user
     */
    public String getURI() {
        return URI;
    }

    /**
     * Sets the URI of the user.
     * @param URI the URI to be set for the user
     */
    public void setURI(String URI) {
        this.URI = URI;
    }

     /**
     * Returns the list of activities in the outbox.
     * @return the list of activities in the outbox
     */
    public LinkedList<Activity> getOutboxActivities() {
        return outboxActivities;
    }

    /**
     * Sets the list of activities in the outbox.
     * @param outboxactivites the list of activities to be set for the outbox
     */
    public void setOutboxActivities(LinkedList<Activity> activities) {
        this.outboxActivities = activities;
    }
    //endregion
}
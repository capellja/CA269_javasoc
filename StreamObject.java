/**
 * This StreamObject class is extended from by every activity.
 * Implements Activity for getURI()
 * Constructors are made for each activity
 * Getters and setters present 
 */
class StreamObject implements Activity {
    private String URI;
    private String attachment;
    private String attributedTo;
    private String audience;
    private int likes;
    private int shares;
    private String content;
    private String name;
    private String published;
    private boolean deleted;
    private Person one;
    private Person two;
    
    public StreamObject(String URI) {
        this.URI = URI;
    }

    /**
     * Constructs a StreamObject for CreateActivity with the given URI, audience, likes, shares, content, name, published, and deleted properties.
     * @param URI the URI of the StreamObject
     * @param audience the intended audience of the StreamObject
     * @param likes the number of likes that the StreamObject has received
     * @param shares the number of times that the StreamObject has been shared
     * @param content the content of the StreamObject
     * @param name the name of the StreamObject
     * @param published the time when the StreamObject was published
     * @param deleted whether the StreamObject has been deleted or not
     */

    public StreamObject(String URI, String audience, int likes, int shares, String content, String name,
    String published, boolean deleted) {
        this.URI = URI;
        this.audience = audience;
        this.likes = likes;
        this.shares = shares;
        this.content = content;
        this.name = name;
    }

    /**
     * Constructs a StreamObject for FollowActivity with the given URI, and the two people involved in a FollowActivity.
     * @param URI the URI of the StreamObject
     * @param one the first person in the FollowActivity
     * @param two the second person in the FollowActivity
     */
    public StreamObject(String URI, Person one, Person two) {
        this.URI = URI;
        this.one = one;
        this.two = two;
    }
    // Getters + Setter
    //region

    /**
     * Returns the URI of the StreamObject.
     * @return the URI of the StreamObject
     */
    public String getURI() {
        return URI;
    }

    public Person getOne() {
        return one;
    }

    public void setOne(Person one) {
        this.one = one;
    }

    public Person getTwo() {
        return two;
    }

    public void setTwo(Person two) {
        this.two = two;
    }


    /**
     * Sets the URI of the StreamObject.
     * @param URI the URI of the StreamObject
     */
    public void setURI(String URI) {
        this.URI = URI;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getAttributedTo() {
        return attributedTo;
    }

    public void setAttributedTo(String attributedTo) {
        this.attributedTo = attributedTo;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    
    //endregion
}

/**
 * CreateActivity is a class that represents an activity of creating content, like posting a message or creating a video.
 * It extends the StreamObject class and inherits its properties such as URI, audience, likes, shares, content, name, 
 * published, and deleted. The constructor of CreateActivity initializes these properties by taking the values passed to it
 * as arguments. The toString() method is overridden to return a formatted string representation of the object, displaying 
 * all its properties in a human-readable format.
 */
class CreateActivity extends StreamObject {

    /**
     * Constructs a new CreateActivity object with the given properties.
     * 
     * @param URI the URI of the activity
     * @param audience the audience of the activity
     * @param likes the number of likes the activity has received
     * @param shares the number of shares the activity has received
     * @param content the content of the activity
     * @param name the name of the activity
     * @param published the publish date of the activity
     * @param deleted a boolean flag indicating whether the activity is deleted or not
     */
    public CreateActivity(String URI, String audience, int likes, int shares,
            String content, String name, String published, boolean deleted) {
        super(URI, audience, likes, shares, content, name, published, deleted);
    }

    /**
     * Returns a formatted string representation of the CreateActivity object.
     * 
     * @return a string representation of the CreateActivity object
     */
    @Override
    public String toString() {
        return
        "- URI: " +  getURI() +"\n" +
        "- audience: " +  getAudience() +"\n" +
        "- like: " +  getLikes() +"\n" +
        "- shares: " +  getShares() +"\n" +
        "- content: " +  getContent() +"\n" +
        "- name: " +  getName() +"\n" +
        "- published: " +  getPublished() +"\n" +
        "- deleted: " +  isDeleted() +"\n"
        ;
    }
}

/**
 * FollowActivity is a class that represents an activity of following another person or entity on a social media platform.
 * It extends the StreamObject class and inherits its properties such as URI, actor, and object. The constructor of FollowActivity
 * initializes these properties by taking the values passed to it as arguments. The toString() method is overridden to return a
 * formatted string representation of the object, displaying all its properties in a human-readable format.
 */
class FollowActivity extends StreamObject {

    /**
     * Constructs a new FollowActivity object with the given properties.
     * 
     * @param URI the URI of the activity
     * @param one the person or entity who is performing the follow action
     * @param two the person or entity who is being followed
     */
    public FollowActivity(String URI, Person one, Person two) {
        super(URI, one, two);
    }

    /**
     * Returns a formatted string representation of the FollowActivity object.
     * 
     * @return a string representation of the FollowActivity object
     */
    @Override
    public String toString() {
        return 
        "- URI: " + getURI() + "\n" +
        "- actor: " + getOne().getURI() + "\n" +
        "- object: " + getTwo().getURI() + "\n"
        ;
    }
}

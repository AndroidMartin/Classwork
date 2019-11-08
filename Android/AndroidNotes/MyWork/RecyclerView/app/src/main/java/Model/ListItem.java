package Model;

public class ListItem {

    // Define your Variables
    private String name;
    private String description;
    private String rating;


    // Create your Constructor(s)
    public ListItem(String name, String description, String rating) {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }


    // Put in your "getters" and "setters"
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

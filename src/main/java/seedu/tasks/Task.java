package seedu.tasks;

public abstract class Task {

    protected String title;
    protected String description;

    public Task(String title, String description) {
        setTitle(title);
        setDescription(description);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Sets the task title.
     *
     * @param title new title
     */
    public void setTitle(String title) {
        if (title.length() == 0) {
            this.title = "(No Title)";
        } else {
            this.title = title;
        }
    }

    /**
     * Sets the task description.
     *
     * @param description new description
     */
    public void setDescription(String description) {
        if (description.length() == 0) {
            this.description = "(No Description)";
        } else {
            this.description = description;
        }
    }

    @Override
    public String toString() {
        String formattedTask = String.format("Title: %s | Description: %s", title, description);

        return formattedTask;
    }

}

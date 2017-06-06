package ca.umanitoba.cs.comp3350.saveonflight.objects;

/**
 * SearchCriteriaListViewEntry.java
 * <p>
 * Object representing an entry in the listview on the search page.
 *
 * @author Andy Lun
 */

public class SearchCriteriaListViewEntry {
    private int icon;
    private String title;

    public SearchCriteriaListViewEntry(int icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public SearchCriteriaListViewEntry clone() {
        return new SearchCriteriaListViewEntry(this.icon, this.title);
    }
}

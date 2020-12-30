package site.thewhale.whalesmovies;

public class ChildItem {

    private String ChildItemTitle;
    private int childItemPic;
    private MovieAdapter movie;

    public ChildItem(String childItemTitle, int childItemPic, MovieAdapter movie) {
        ChildItemTitle = childItemTitle;
        this.childItemPic = childItemPic;
        this.movie = movie;
    }

    public MovieAdapter getMovie() {
        return movie;
    }

    public void setMovie(MovieAdapter movie) {
        this.movie = movie;
    }

    public String getChildItemTitle()
    {
        return ChildItemTitle;
    }

    public int getChildItemPic() {
        return childItemPic;
    }

    public void setChildItemPic(int childItemPic) {
        this.childItemPic = childItemPic;
    }

    public void setChildItemTitle(
            String childItemTitle)
    {
        ChildItemTitle = childItemTitle;
    }
}

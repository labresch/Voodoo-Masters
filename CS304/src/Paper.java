import java.sql.Date;

/* this is just a simple class to get us going, maybe we should be able to add new fields somehow */

public class Paper {
   
    private static String editor;
    private static String title;
    private static Date datePublished;
    private static int paperID;
   
    public Paper(String nm, String tl, Date datep, int pid) {
        editor = nm;
        title = tl;
        datePublished = datep;
        paperID = pid;
    }
   
    public String editor() {
        return editor;
    }
    public String title() {
        return title;
    }
    public Date datePublished() {
        return datePublished;
    }
    public int paperID() {
        return paperID;
    }
   

}

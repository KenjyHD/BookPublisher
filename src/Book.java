import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Book implements IPublishingArtifact {
    int ID;
    String name;
    String subtitle;
    String ISBN;
    int pageCount;
    String[] keywords;
    int languageID;
    Calendar createdOn;
    Author[] authors;

    public Book() {
    }

    public Book(int ID, String name, String subtitle, String ISBN, int pageCount, String[] keywords, int languageID,
                Calendar createdOn, Author[] authors) {
        this.ID = ID;
        this.name = name;
        this.subtitle = subtitle;
        this.ISBN = ISBN;
        this.pageCount = pageCount;
        this.keywords = keywords;
        this.languageID = languageID;
        this.createdOn = createdOn;
        this.authors = authors;
    }

    @Override
    public String Publish() {
        StringBuilder s;
        s = new StringBuilder("<xml>\n\t<title>" + name + "</title>\n\t<subtitle>" + subtitle +
                "</subtitle>\n\t<isbn>" + ISBN + "</isbn>\n\t<pageCount>" + pageCount +
                "</pageCount>\n\t<keywords>");

        for (String keyword : keywords) s.append(keyword);

        s.append("</keywords>\n\t<languageID>").append(languageID).append("</languageID>\n\t<createdON>").
                append(calendarToString(createdOn)).append("</createdOn>\n\t<authors>");

        for (Author author : authors) {
            s.append(author.firstName).append(" ").append(author.lastName);
        }

                s.append("</authors>\n</xml>\n");
        return s.toString();
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public Calendar getCreatedOn() {
        return createdOn;
    }

    public int getLanguageID() {
        return languageID;
    }

    /*
    Metoda ce transforma tipul calendar intr-un string si returneaza stringul
    **/
    public String calendarToString(Calendar calendar){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        return sdf.format(calendar.getTime());
    }

    public Author[] getAuthors() {
        return authors;
    }

}

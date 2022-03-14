public class PublishingBrand implements IPublishingArtifact {
    int ID;
    String name;
    Book[] books;

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String Publish() {
        StringBuilder s;
        s = new StringBuilder("<xml>\n\t<publishingBrand>\n\t\t<ID>" + ID + "</ID>\n\t\t<Name>"
                + name + "</Name>\n\t</publishingBrand>\n\t<books>\n");
        for (Book book: books){
            s.append("\t\t<book>\n\t\t\t<title>").append(book.getName()).append("</title>\n\t\t\t<subtitle>").
                    append(book.getSubtitle()).append("</subtitle>\n\t\t\t<isbn>").append(book.getISBN()).
                    append("</isbn>\n\t\t\t<pageCount>").append(book.getPageCount()).
                    append("</pageCount>\n\t\t\t<keywords>");
            for (String keyword : book.getKeywords()) s.append(keyword);
            s.append("</keywords>\n\t\t\t<languageID>").append(book.getLanguageID()).
                    append("</languageID>\n\t\t\t<createdOn>").append(book.calendarToString(book.getCreatedOn())).
                    append("</createdOn>\n\t\t\t<authors>");
            for (Author author : book.getAuthors()){
                s.append(author.firstName).append(" ").append(author.lastName);
            }
            s.append("</authors>\n\t\t</book>\n");
        }
        s.append("\t</books>\n</xml>\n");
        return s.toString();
    }

    public PublishingBrand(int ID, String name, Book[] books) {
        this.ID = ID;
        this.name = name;
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }
}

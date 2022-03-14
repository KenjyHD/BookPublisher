import java.io.FileWriter;
import java.io.IOException;

public class FileWriting {
    Administration administration;

    public FileWriting(Administration administration) {
        this.administration = administration;
    }

    /*
    Metoda ce scrie in fisier publish-urile listei de carti returnata de getBooksForPublishingRetailerID
    **/
    public void writeGetBooksForPublishingRetailerID(int ID, String filePath) {
        try {
            FileWriter myWriter = new FileWriter(filePath);
            Book[] books = administration.getBooksForPublishingRetailerID(ID);
            for(Book book : books) {
                myWriter.write(book.Publish());
            }
            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Metoda ce scrie in fisier informatii despre lista de limbi returnata de  getLanguagesForPublishingRetailerID
    **/
    public void writeGetLanguagesForPublishingRetailerID(int ID, String filePath){
        try {
            FileWriter myWriter = new FileWriter(filePath);
            Language[] languages = administration.getLanguagesForPublishingRetailerID(ID);
            if (languages != null){
                for (Language language : languages) {
                    myWriter.write(language.getID() + " " + language.getCode() + " " + language.getName() + " \n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Metoda ce scrie in fisier informatii despre lista de tari returnata de  getLanguagesForPublishingRetailerID
    **/
    public void writeGetCountriesForBookID(int ID, String filePath){
        try {
            FileWriter myWriter = new FileWriter(filePath);
            Countries[] countries = administration.getCountriesForBookID(ID);
            if(countries != null){
                for(Countries country : countries){
                    myWriter.write(country.getID() + " " + country.getCountryCode() + " \n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*Metoda ce scrie in fisier publish-urile listei de carti comune returnata de getCommonBooksForRetailerIDs
    **/
    public void writeGetCommonBooksForRetailerIDs(int ID1, int ID2, String filePath) {
        try {
            FileWriter myWriter = new FileWriter(filePath);
            Book[] books = administration.getCommonBooksForRetailerIDs(ID1, ID2);
            if(books != null){
                for(Book book : books){
                    myWriter.write(book.Publish());
                }
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Metoda ce scrie in fisier publish-urile listei-reuniune de carti returnata de getAllBooksForRetailerIDs
    **/
    public void writeGetAllBooksForRetailerIDs(int ID1, int ID2, String filePath) {
        try {
            FileWriter myWriter = new FileWriter(filePath);
            Book[] books = administration.getAllBooksForRetailerIDs(ID1, ID2);
            if(books != null){
                for(Book book : books){
                    myWriter.write(book.Publish());
                }
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Metoda ce scrie in fisier publish-urile tuturor grupurilor editoriale din lista de grupuri
    **/
    public void writeGetEditorialGroups(EditorialGroup[] editorialGroups, String filePath) {
        try {
            FileWriter myWriter = new FileWriter(filePath);
            if(editorialGroups != null){
                for(EditorialGroup editorialGroup : editorialGroups){
                    myWriter.write(editorialGroup.Publish());
                }
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Metoda ce scrie in fisier publish-urile tuturor grupurilor de publicare din lista de grupuri
    **/
    public void writeGetPublishingBrands(PublishingBrand[] publishingBrands, String filePath) {
        try {
            FileWriter myWriter = new FileWriter(filePath);
            if(publishingBrands != null){
                for(PublishingBrand publishingBrand : publishingBrands){
                    myWriter.write(publishingBrand.Publish());
                }
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

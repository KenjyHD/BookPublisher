import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FileReading {
    /*
    Metoda ce citeste  din fisierul books.in, instantiaza si returneaza lista de carti
    **/
    public Book[] readBooks() throws FileNotFoundException {

        Book[] books = new Book[1000];
        FileReader file = new FileReader("C://Users/liviu/IdeaProjects/tema1/src/init/books.in");

        try (BufferedReader br = new BufferedReader(file)) {
            int i =0;
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] splitted = line.split("###");

                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
                calendar.setTime(sdf.parse(splitted[7]));

                books[i] = new Book(Integer.parseInt(splitted[0]), splitted[1],
                        splitted[2], splitted[3], Integer.parseInt(splitted[4]),
                        splitted[5].split(";"), Integer.parseInt(splitted[6]),
                        calendar, null);
                i++;
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return books;

    }

    /*
    Metoda ce citeste  din fisierul authors.in si instantiaza returneaza lista de autori
    **/
    public Author[] readAuthors() throws FileNotFoundException {

        Author[] authors = new Author[2381];
        FileReader file = new FileReader("C://Users/liviu/IdeaProjects/tema1/src/init/authors.in");

        try (BufferedReader br = new BufferedReader(file)) {
            int i =0;
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] splitted = line.split("###");

                authors[i] = new Author(Integer.parseInt(splitted[0]), splitted[1],
                        splitted[2]);
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return authors;

    }

    /*
    Metoda ce citeste  din fisierul languages.in, instantiaza si returneaza lista de limbi
    **/
    public Language[] readLanguages() throws FileNotFoundException {

        Language[] languages = new Language[4];
        FileReader file = new FileReader("C://Users/liviu/IdeaProjects/tema1/src/init/languages.in");

        try (BufferedReader br = new BufferedReader(file)) {
            int i =0;
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] splitted = line.split("###");

                languages[i] = new Language(Integer.parseInt(splitted[0]), splitted[1],
                        splitted[2]);
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return languages;

    }

    /*
    Metoda ce citeste  din fisierul books-authors.in si initializeaza asocierile dintre carti si autori
    **/
    public void readBooksAuthors(Book[] books, Author[] authors) throws FileNotFoundException {

        FileReader file = new FileReader("C://Users/liviu/IdeaProjects/tema1/src/init/books-authors.in");

        try (BufferedReader br = new BufferedReader(file)) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] splitted = line.split("###");

                Book book = Useful.getBookByID(Integer.parseInt(splitted[0]), books);
                Author author = Useful.getAuthorByID(Integer.parseInt(splitted[1]), authors);

                if(book != null && author != null)
                    Useful.addAuthor(author, book);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
    Metoda ce citeste  din fisierul editorial-groups.in, instantiaza si returneaza lista de grupuri editoriale
    **/
    public EditorialGroup[] readEditorialGroups() throws FileNotFoundException {
        EditorialGroup[] editorialGroups = new EditorialGroup[264];
        FileReader file = new FileReader("C://Users/liviu/IdeaProjects/tema1/src/init/editorial-groups.in");

        try (BufferedReader br = new BufferedReader(file)) {
            int i =0;
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] splitted = line.split("###");

                editorialGroups[i] = new EditorialGroup(Integer.parseInt(splitted[0]), splitted[1], null);
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return editorialGroups;

    }

    /*
    Metoda ce citeste  din fisierul publishing-brands.in, instantiaza si returneaza lista de de publishing brands
    **/
    public PublishingBrand[] readPublishingBrands() throws FileNotFoundException {
        PublishingBrand[] publishingBrands = new PublishingBrand[317];
        FileReader file = new FileReader("C://Users/liviu/IdeaProjects/tema1/src/init/publishing-brands.in");

        try (BufferedReader br = new BufferedReader(file)) {
            int i =0;
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] splitted = line.split("###");

                publishingBrands[i] = new PublishingBrand(Integer.parseInt(splitted[0]), splitted[1], null);
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return publishingBrands;

    }

    /*
    Metoda ce citeste  din fisierul editorial-groups-books.in si initializeaza asocierile dintre grupuri
    editoriale si carti
    **/
    public void readEditorialGroupsBooks(EditorialGroup[] editorialGroups, Book[] books) throws FileNotFoundException {
        FileReader file = new FileReader(
                "C://Users/liviu/IdeaProjects/tema1/src/init/editorial-groups-books.in");

        try (BufferedReader br = new BufferedReader(file)) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] splitted = line.split("###");

                Book book = Useful.getBookByID(Integer.parseInt(splitted[1]), books);
                EditorialGroup editorialGroup = Useful.getEditorialGroupByID(Integer.parseInt(splitted[0]),
                        editorialGroups);

                if(book != null && editorialGroup != null)
                    Useful.addBook(book, editorialGroup);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
    Metoda ce citeste  din fisierul publishing-brands-books.in si initializeaza asocierile dintre grupuri de
    publicare si carti
    **/
    public void readPublishingBrandsBooks(PublishingBrand[] publishingBrands, Book[] books)
            throws FileNotFoundException {
        FileReader file = new FileReader(
                "C://Users/liviu/IdeaProjects/tema1/src/init/publishing-brands-books.in");

        try (BufferedReader br = new BufferedReader(file)) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] splitted = line.split("###");

                Book book = Useful.getBookByID(Integer.parseInt(splitted[1]), books);
                PublishingBrand publishingBrand = Useful.getPublishingBrandByID(Integer.parseInt(splitted[0]),
                        publishingBrands);

                if(publishingBrand != null)
                    Useful.addBook(book, publishingBrand);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
    Metoda ce citeste  din fisierul publishing-retailers.in, instantiaza si returneaza lista de retaileri
    **/
    public PublishingRetailer[] readPublishingRetailers() throws FileNotFoundException {
        PublishingRetailer[] publishingRetailers = new PublishingRetailer[31];
        FileReader file = new FileReader("C://Users/liviu/IdeaProjects/tema1/src/init/publishing-retailers.in");

        try (BufferedReader br = new BufferedReader(file)) {
            int i =0;
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] splitted = line.split("###");

                publishingRetailers[i] = new PublishingRetailer(Integer.parseInt(splitted[0]), splitted[1],
                        null, null);
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return publishingRetailers;

    }

    /*
    Metoda ce citeste  din fisierul countries.in, instantiaza si returneaza lista de limbi
    **/
    public Countries[] readCountries() throws FileNotFoundException {
        Countries[] countries = new Countries[249];
        FileReader file = new FileReader("C://Users/liviu/IdeaProjects/tema1/src/init/countries.in");

        try (BufferedReader br = new BufferedReader(file)) {
            int i =0;
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] splitted = line.split("###");

                countries[i] = new Countries(Integer.parseInt(splitted[0]), splitted[1]);
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;

    }

    /*
    Metoda ce citeste  din fisierul publishing-retailers-countries.in si initializeaza asocierile dintre retaileri
    si tari
    **/
    public void readPublishingRetailersCountries(PublishingRetailer[] publishingRetailers, Countries[] countries)
            throws FileNotFoundException {
        FileReader file = new FileReader("C://Users/liviu/IdeaProjects/tema1/src/init/publishing-retailers-countries.in");

        try (BufferedReader br = new BufferedReader(file)) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] splitted = line.split("###");

                Countries country = Useful.getCountryByID(Integer.parseInt(splitted[1]), countries);
                PublishingRetailer publishingRetailer = Useful.getPublishingRetailerByID(Integer.parseInt(splitted[0]), publishingRetailers);

                if(publishingRetailer != null && country != null)
                    Useful.addCountry(country, publishingRetailer);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
    Metoda ce citeste  din fisierul publishing-retailers-books.in si initializeaza asocierile dintre retaileri
    si carti
    **/
    public void readPublishingRetailersBooks(PublishingRetailer[] publishingRetailers, Book[] books)
            throws FileNotFoundException {
        FileReader file = new FileReader(
                "C://Users/liviu/IdeaProjects/tema1/src/init/publishing-retailers-books.in");

        try (BufferedReader br = new BufferedReader(file)) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] splitted = line.split("###");

                Book book = Useful.getBookByID(Integer.parseInt(splitted[1]), books);
                PublishingRetailer publishingRetailer = Useful.getPublishingRetailerByID(Integer.parseInt(splitted[0]),
                        publishingRetailers);

                if(publishingRetailer != null && book != null)
                    Useful.addPublishingArtifacts(book, publishingRetailer);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Metoda ce citeste  din fisierul publishing-retailers-editorial-groups.in si initializeaza asocierile dintre
    retaileri si grupuri editoriale
    **/
    public void readPublishingRetailersEditorialGroups(PublishingRetailer[] publishingRetailers,
                                                       EditorialGroup[] editorialGroups) throws FileNotFoundException {
        FileReader file = new FileReader("" +
                "C://Users/liviu/IdeaProjects/tema1/src/init/publishing-retailers-editorial-groups.in");

        try (BufferedReader br = new BufferedReader(file)) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] splitted = line.split("###");

                EditorialGroup editorialGroup = Useful.getEditorialGroupByID(Integer.parseInt(splitted[1]),
                        editorialGroups);
                PublishingRetailer publishingRetailer = Useful.getPublishingRetailerByID(Integer.parseInt(splitted[0]),
                        publishingRetailers);

                if(publishingRetailer != null && editorialGroup != null)
                    Useful.addPublishingArtifacts(editorialGroup, publishingRetailer);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Metoda ce citeste  din fisierul publishing-retailers-publishing-brands.in si initializeaza asocierile dintre retaileri
    si grupuri de publicare
    **/
    public void readPublishingRetailersPublishingBrands
            (PublishingRetailer[] publishingRetailers, PublishingBrand[] publishingBrands)
            throws FileNotFoundException {
        FileReader file = new FileReader(
                "C://Users/liviu/IdeaProjects/tema1/src/init/publishing-retailers-publishing-brands.in");

        try (BufferedReader br = new BufferedReader(file)) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] splitted = line.split("###");

                PublishingBrand publishingBrand = Useful.getPublishingBrandByID(Integer.parseInt(splitted[1]),
                        publishingBrands);
                PublishingRetailer publishingRetailer = Useful.getPublishingRetailerByID(Integer.parseInt(splitted[0]),
                        publishingRetailers);

                if(publishingRetailer != null && publishingBrand != null)
                    Useful.addPublishingArtifacts(publishingBrand, publishingRetailer);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

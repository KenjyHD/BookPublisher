import java.util.*;

public class Administration {
    PublishingRetailer[] publishingRetailers;
    Language[] languages;

    /*
    Metoda ce returneaza o lista de carti unice dintr-un retailer
    **/
    public Book[] getBooksForPublishingRetailerID(int publishingRetailerID){
        PublishingRetailer publishingRetailer =
                Useful.getPublishingRetailerByID(publishingRetailerID, publishingRetailers);
        Set<Book> set = new HashSet<>();

        if(publishingRetailer != null)
            for(int i = 0; i < publishingRetailer.getPublishingArtifacts().length; i++){
                if(publishingRetailer.getPublishingArtifacts()[i] instanceof Book){
                    set.add(((Book) publishingRetailer.getPublishingArtifacts()[i]));
                }
                if(publishingRetailer.getPublishingArtifacts()[i] instanceof EditorialGroup) {
                    Collections.addAll
                            (set, ((EditorialGroup) publishingRetailer.getPublishingArtifacts()[i]).getBooks());
                }
                if(publishingRetailer.getPublishingArtifacts()[i] instanceof PublishingBrand) {
                    Collections.addAll
                            (set, ((PublishingBrand) publishingRetailer.getPublishingArtifacts()[i]).getBooks());
                }

            }
        return set.toArray(new Book[0]);
    }

    /*
    Metoda ce returneaza o lista de limbi unice dintr-un retailer
    **/
    public Language[] getLanguagesForPublishingRetailerID(int publishingRetailerID){
        PublishingRetailer publishingRetailer =
                Useful.getPublishingRetailerByID(publishingRetailerID, publishingRetailers);
        if (publishingRetailer == null) return null;
        Set<Language> set = new HashSet<>();

        for(int i = 0; i < publishingRetailer.getPublishingArtifacts().length; i++){

            if(publishingRetailer.getPublishingArtifacts()[i] instanceof Book){

                Language language = Useful.getLanguageByID(((Book) publishingRetailer.
                        getPublishingArtifacts()[i]).getLanguageID(), languages);
                set.add(language);
            }

            if(publishingRetailer.getPublishingArtifacts()[i] instanceof EditorialGroup) {
                for (int j = 0; j < ((EditorialGroup) publishingRetailer.getPublishingArtifacts()[i]).getBooks().length;
                     j++) {
                    Language language = Useful.getLanguageByID(((EditorialGroup) publishingRetailer.
                            getPublishingArtifacts()[i]).getBooks()[j].getLanguageID(), languages);
                    set.add(language);
                }
            }
            if(publishingRetailer.getPublishingArtifacts()[i] instanceof PublishingBrand) {
                for (int j = 0; j < ((PublishingBrand)publishingRetailer.getPublishingArtifacts()[i]).getBooks().length;
                     j++) {
                    Language language = Useful.getLanguageByID(((PublishingBrand) publishingRetailer.
                            getPublishingArtifacts()[i]).getBooks()[j].getLanguageID(), languages);
                    set.add(language);
                }
            }

        }

        return set.toArray(new Language[0]);
    }

    /*
    Metoda ce returneaza o lista de tari unice in care a ajuns o carte
    **/
    public Countries[] getCountriesForBookID(int bookID){

        Set<Countries> set = new HashSet<>();
        for (PublishingRetailer publishingRetailer : publishingRetailers) {
            for (int j = 0; j < publishingRetailer.getPublishingArtifacts().length; j++) {

                if (publishingRetailer.getPublishingArtifacts()[j] instanceof Book) {
                    if (bookID == ((Book) publishingRetailer.getPublishingArtifacts()[j]).getID()) {
                        set.addAll(Arrays.asList(publishingRetailer.getCountries()));
                    }
                }

                if (publishingRetailer.getPublishingArtifacts()[j] instanceof EditorialGroup) {
                    for (int k = 0; k < ((EditorialGroup) publishingRetailer.getPublishingArtifacts()[j]).getBooks().
                            length; k++) {
                        if (bookID == ((EditorialGroup) publishingRetailer.getPublishingArtifacts()[j]).getBooks()[k].
                                getID()) {
                            Collections.addAll(set, publishingRetailer.getCountries());
                        }
                    }
                }

                if (publishingRetailer.getPublishingArtifacts()[j] instanceof PublishingBrand) {
                    for (int k = 0; k < ((PublishingBrand) publishingRetailer.getPublishingArtifacts()[j]).getBooks().
                            length; k++) {
                        if (bookID == ((PublishingBrand) publishingRetailer.getPublishingArtifacts()[j]).getBooks()[k].
                                getID()) {
                            Collections.addAll(set, publishingRetailer.getCountries());
                        }
                    }
                }
            }
        }

        return set.toArray(new Countries[0]);
    }

    /*
    Metoda ce returneaza o lista de carti comune din 2 retailere
    **/
    public Book[] getCommonBooksForRetailerIDs(int retailerID1, int retailerID2){
        Book[] books1 = getBooksForPublishingRetailerID(retailerID1);
        Book[] books2 = getBooksForPublishingRetailerID(retailerID2);

        Set<Book> set1 = new HashSet<>();
        Set<Book> set2 = new HashSet<>();

        if(books1 != null)
            Collections.addAll(set1, books1);

        if(books2 != null)
            Collections.addAll(set2, books2);

        set1.retainAll(set2);


        books1 = set1.toArray(new Book[0]);

        return books1;
    }

    /*
    Metoda ce returneaza o lista-reuniune a doua liste de carti corespunzatoare a doua retailere
    **/
    public Book[] getAllBooksForRetailerIDs(int retailerID1, int retailerID2){
        Book[] books1 = getBooksForPublishingRetailerID(retailerID1);
        Book[] books2 = getBooksForPublishingRetailerID(retailerID2);

        Set<Book> set = new HashSet<>();

        Collections.addAll(set, books1);

        Collections.addAll(set, books2);

        books1 = set.toArray(new Book[0]);

        return books1;
    }

    public Administration(PublishingRetailer[] publishingRetailers, Language[] languages) {
        this.publishingRetailers = publishingRetailers;
        this.languages = languages;
    }


}

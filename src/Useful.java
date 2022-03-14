public abstract class Useful {
    /*
    Metoda ce cauta cartea dupa ID in lista de carti(parametru) si o returneaza daca o gaseste
    **/
    public static Book getBookByID(int ID, Book[] books){
        for(Book book: books) {
            if(book.ID == ID) {return book;}
        }
        return null;
    }

    /*
    Metoda ce cauta autorul dupa ID in lista de autori(parametru) si il returneaza daca il gaseste
    **/
    public static Author getAuthorByID(int ID, Author[] authors){
        for(Author author: authors) {
            if(author.ID == ID) {return author;}
        }
        return null;
    }

    /*
    Metoda ce cauta grupul editorial dupa ID in lista de grupuri(parametru) si il returneaza daca il gaseste
    **/
    public static EditorialGroup getEditorialGroupByID(int ID, EditorialGroup[] editorialGroups){
        for(EditorialGroup editorialGroup: editorialGroups) {
            if(editorialGroup.ID == ID) {return editorialGroup;}
        }
        return null;
    }

    /*
    Metoda ce cauta brandul dupa ID in lista de branduri(parametru) si il returneaza daca il gaseste
    **/
    public static PublishingBrand getPublishingBrandByID(int ID, PublishingBrand[] publishingBrands){
        for(PublishingBrand publishingBrand: publishingBrands) {
            if(publishingBrand.ID == ID) {return publishingBrand;}
        }
        return null;
    }

    /*
    Metoda ce cauta tara dupa ID in lista de tari(parametru) si o returneaza daca o gaseste
    **/
    public static Countries getCountryByID(int ID, Countries[] countries){
        for(Countries country: countries) {
            if(country.ID == ID) {return country;}
        }
        return null;
    }

    /*
    Metoda ce cauta limba dupa ID in lista de limbi(parametru) si o returneaza daca o gaseste
    **/
    public static Language getLanguageByID(int ID, Language[] languages){
        for(Language language: languages) {
            if(language.ID == ID) {return language;}
        }
        return null;
    }

    /*
    Metoda ce cauta retailerul dupa ID in lista de retaileri(parametru) si il returneaza daca il gaseste
    **/
    public static PublishingRetailer getPublishingRetailerByID(int ID, PublishingRetailer[] publishingRetailers){
        for(PublishingRetailer publishingRetailer: publishingRetailers) {
            if(publishingRetailer.ID == ID) {return publishingRetailer;}
        }
        return null;
    }

    /*
    Metoda ce adauga o carte in lista de artefacte a retailerului
    **/
    public static void addBook(Book book, EditorialGroup editorialGroup){
        int len;
        if(editorialGroup.books == null) len = 0;
        else len = editorialGroup.books.length;

        Book[] aux = new Book[len + 1];
        if (editorialGroup.books != null)
            System.arraycopy(editorialGroup.books, 0, aux, 0, aux.length);
        editorialGroup.books = aux;

        editorialGroup.books[editorialGroup.books.length - 1] = book;
    }

    /*
    Metoda ce adauga o carte in lista de carti a grupului de publicare
    **/
    public static void addBook(Book book, PublishingBrand publishingBrand){
        int len;
        if(publishingBrand.books == null) len = 0;
        else len = publishingBrand.books.length;

        Book[] aux = new Book[len + 1];
        if (publishingBrand.books != null)
            System.arraycopy(publishingBrand.books, 0, aux, 0, aux.length);
        publishingBrand.books = aux;

        publishingBrand.books[publishingBrand.books.length - 1] = book;
    }

    /*
    Metoda ce adauga un autor in lista de autori a cartii
    **/
    public static void addAuthor(Author author, Book book){
        int len;
        if(book.authors == null) len = 0;
        else len = book.authors.length;

        Author[] aux = new Author[len + 1];
        if (book.authors != null)
            System.arraycopy(book.authors, 0, aux, 0, aux.length);
        book.authors = aux;

        book.authors[book.authors.length - 1] = author;
    }

    /*
    Metoda ce adauga o tara in lista de tari a retailerului
    **/
    public static void addCountry(Countries country, PublishingRetailer publishingRetailer){
        int len;
        if(publishingRetailer.countries == null) len = 0;
        else len = publishingRetailer.countries.length;

        Countries[] aux = new Countries[len + 1];
        if (publishingRetailer.countries != null)
            System.arraycopy(publishingRetailer.countries, 0, aux, 0, aux.length);
        publishingRetailer.countries = aux;

        publishingRetailer.countries[publishingRetailer.countries.length - 1] = country;
    }

    /*
    Metoda ce adauga un artefact publicabil in lista de artefacte a retailerului
    **/
    public static void addPublishingArtifacts(IPublishingArtifact publishingArtifact,
                                              PublishingRetailer publishingRetailer){
        int len;
        if(publishingRetailer.publishingArtifacts == null) len = 0;
        else len = publishingRetailer.publishingArtifacts.length;

        IPublishingArtifact[] aux = new IPublishingArtifact[len + 1];
        if (publishingRetailer.publishingArtifacts != null) {
            System.arraycopy(publishingRetailer.publishingArtifacts, 0, aux, 0, len);
        }

        publishingRetailer.publishingArtifacts = aux;

        publishingRetailer.publishingArtifacts[publishingRetailer.publishingArtifacts.length - 1] = publishingArtifact;
    }
}

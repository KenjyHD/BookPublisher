import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        FileReading file = new FileReading();

        Book[] books = file.readBooks();
        Author[] authors = file.readAuthors();
        Countries[] countries = file.readCountries();
        Language[] languages = file.readLanguages();
        EditorialGroup[] editorialGroups = file.readEditorialGroups();
        PublishingBrand[] publishingBrands = file.readPublishingBrands();
        PublishingRetailer[] publishingRetailers = file.readPublishingRetailers();

        file.readPublishingBrandsBooks(publishingBrands, books);
        file.readEditorialGroupsBooks(editorialGroups, books);
        file.readPublishingRetailersCountries(publishingRetailers, countries);
        file.readBooksAuthors(books, authors);
        file.readPublishingRetailersBooks(publishingRetailers, books);
        file.readPublishingRetailersEditorialGroups(publishingRetailers, editorialGroups);
        file.readPublishingRetailersPublishingBrands(publishingRetailers, publishingBrands);

        FileWriting fileWrite = new FileWriting(new Administration(publishingRetailers, languages));

        fileWrite.writeGetBooksForPublishingRetailerID(4,
                "src/output/getBooksForPublishingRetailerID4.out");
        fileWrite.writeGetBooksForPublishingRetailerID(6,
                "src/output/getBooksForPublishingRetailerID6.out");
        fileWrite.writeGetBooksForPublishingRetailerID(15,
                "src/output/getBooksForPublishingRetailerID15.out");
        fileWrite.writeGetBooksForPublishingRetailerID(24,
                "src/output/getBooksForPublishingRetailerID24.out");
        fileWrite.writeGetBooksForPublishingRetailerID(33,
                "src/output/getBooksForPublishingRetailerID33.out");

        fileWrite.writeGetLanguagesForPublishingRetailerID(4,
                "src/output/getLanguageForPublishingRetailerID4.out");
        fileWrite.writeGetLanguagesForPublishingRetailerID(2,
                "src/output/getLanguageForPublishingRetailerID2.out");
        fileWrite.writeGetLanguagesForPublishingRetailerID(28,
                "src/output/getLanguageForPublishingRetailerID28.out");
        fileWrite.writeGetLanguagesForPublishingRetailerID(26,
                "src/output/getLanguageForPublishingRetailerID26.out");
        fileWrite.writeGetLanguagesForPublishingRetailerID(13,
                "src/output/getLanguageForPublishingRetailerID13.out");

        fileWrite.writeGetCountriesForBookID(1301, "src/output/getCountriesForBookID1301.out");
        fileWrite.writeGetCountriesForBookID(2004, "src/output/getCountriesForBookID2004.out");
        fileWrite.writeGetCountriesForBookID(14958, "src/output/getCountriesForBookID14958.out");
        fileWrite.writeGetCountriesForBookID(2674, "src/output/getCountriesForBookID2674.out");
        fileWrite.writeGetCountriesForBookID(11012, "src/output/getCountriesForBookID11012.out");


        fileWrite.writeGetCommonBooksForRetailerIDs(1, 2,
                "src/output/getCommonBooksForRetailerIDs1 2.out");
        fileWrite.writeGetCommonBooksForRetailerIDs(1, 13,
                "src/output/getCommonBooksForRetailerIDs1 13.out");
        fileWrite.writeGetCommonBooksForRetailerIDs(3 , 31,
                "src/output/getCommonBooksForRetailerIDs3 31.out");
        fileWrite.writeGetCommonBooksForRetailerIDs(19, 22,
                "src/output/getCommonBooksForRetailerIDs19 22.out");
        fileWrite.writeGetCommonBooksForRetailerIDs(12, 32,
                "src/output/getCommonBooksForRetailerIDs12 32.out");

        fileWrite.writeGetAllBooksForRetailerIDs(1, 12,
                "src/output/getAllBooksForRetailerIDs1 12.out");
        fileWrite.writeGetAllBooksForRetailerIDs(28, 16,
                "src/output/getAllBooksForRetailerIDs28 16.out");
        fileWrite.writeGetAllBooksForRetailerIDs(19, 22,
                "src/output/getAllBooksForRetailerIDs19 22.out");
        fileWrite.writeGetAllBooksForRetailerIDs(12, 32,
                "src/output/getAllBooksForRetailerIDs12 32.out");
        fileWrite.writeGetAllBooksForRetailerIDs(17, 17,
                "src/output/getAllBooksForRetailerIDs17 17.out");

        fileWrite.writeGetEditorialGroups(editorialGroups,
                "src/output/getEditorialGroups.out");

        fileWrite.writeGetPublishingBrands(publishingBrands,
                "src/output/getPublishingBrands.out");


    }
}

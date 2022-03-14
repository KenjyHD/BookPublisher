public class PublishingRetailer {
    int ID;
    String name;
    IPublishingArtifact[] publishingArtifacts;
    Countries[] countries;

    public PublishingRetailer(int ID, String name, IPublishingArtifact[] publishingArtifacts, Countries[] countries) {
        this.ID = ID;
        this.name = name;
        this.publishingArtifacts = publishingArtifacts;
        this.countries = countries;
    }

    public IPublishingArtifact[] getPublishingArtifacts() {
        return publishingArtifacts;
    }

    public Countries[] getCountries() {
        return countries;
    }

    public String getName() {
        return name;
    }
}

package bookcrud;

public class Publisher {
    private String pubNo;
    private String pubName;

    public Publisher() {}

    public Publisher(String pubNo, String pubName) {
        this.pubNo = pubNo;
        this.pubName = pubName;
    }

    public String getPubNo() { return pubNo; }
    public void setPubNo(String pubNo) { this.pubNo = pubNo; }

    public String getPubName() { return pubName; }
    public void setPubName(String pubName) { this.pubName = pubName; }
}

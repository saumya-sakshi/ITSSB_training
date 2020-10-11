package Models;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Plos {

    private String id;
    private String journal;
    private String eissn;

    public Plos(String id) {

    }

    public Plos(String publication_date, String essn) {
    }

    public List<String> get_abstract() {
        return _abstract;
    }

    public void set_abstract(List<String> _abstract) {
        this._abstract = _abstract;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    private String publicationDate;
    private String articleType;
    private List<String> authorDisplay = null;
    private List<String> _abstract = null;
    private String titleDisplay;
    private Double score;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getEissn() {
        return eissn;
    }

    public void setEissn(String eissn) {
        this.eissn = eissn;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public List<String> getAuthorDisplay() {
        return authorDisplay;
    }

    public void setAuthorDisplay(List<String> authorDisplay) {
        this.authorDisplay = authorDisplay;
    }

    public List<String> getAbstract() {
        return _abstract;
    }

    public void setAbstract(List<String> _abstract) {
        this._abstract = _abstract;
    }

    public String getTitleDisplay() {
        return titleDisplay;
    }

    public void setTitleDisplay(String titleDisplay) {
        this.titleDisplay = titleDisplay;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
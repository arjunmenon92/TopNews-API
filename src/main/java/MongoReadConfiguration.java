import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class MongoReadConfiguration extends Configuration {

    @JsonProperty("newsMongoHost")
    private String mongoURL;

    @JsonProperty("newscollectionName")
    private String newscollectionName;

    public String getMongoURL() {
        return mongoURL;
    }

    public void setMongoURL(String mongoURL) {
        this.mongoURL = mongoURL;
    }

    public String getNewscollectionName() {
        return newscollectionName;
    }

    public void setNewscollectionName(String newscollectionName) {
        this.newscollectionName = newscollectionName;
    }

    @Override
    public String toString() {
        return "MongoReadConfiguration{" +
                "mongoURL='" + mongoURL + '\'' +
                ", newscollectionName='" + newscollectionName + '\'' +
                '}';
    }
}
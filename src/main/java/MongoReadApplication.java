import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.jongo.Jongo;

public class MongoReadApplication extends Application<MongoReadConfiguration> {

    public static Jongo jongo;
    public static String collectionName;

    public static void main(String[] args) throws Exception {
        new MongoReadApplication().run(args);
    }

    @Override
    public void run(MongoReadConfiguration config, Environment environment) throws Exception{
        initMongo(config);
        environment.jersey().register(new MongoReadResource());
    }


    public static void initMongo(MongoReadConfiguration configuration) {

        MongoClientURI mongoClientURI = new MongoClientURI(configuration.getMongoURL());
        MongoClient mongoClient = new MongoClient(mongoClientURI);

        DB db = mongoClient.getDB("test");

        jongo = new Jongo(db);

        collectionName = configuration.getNewscollectionName();

    }
}
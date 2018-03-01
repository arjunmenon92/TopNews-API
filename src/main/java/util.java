import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class util {
    public static List<News> getNews(String collectionName,String date){
        List<News> newsResponse = new ArrayList<>();

        String query = generateQuery(date);
        MongoCollection newscol = MongoReadApplication.jongo.getCollection(collectionName);

        Iterable<News> news = newscol.find(query).as(News.class);

        for (News n : news) {
            newsResponse.add(n);
        }
        return newsResponse;
    }

    public static String generateQuery(String date){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date datenew = new Date();
        String query="{}";
        if (date!=null) {
            query="{date:\""+date+"\"}";
        }
        else {
            System.out.println(dateFormat.format(datenew).toString());
            query="{date:\""+dateFormat.format(datenew).toString()+"\"}";
        }
        return query;
    }

    public static void insertNews(String collectionName, News news){
        MongoCollection newscol = MongoReadApplication.jongo.getCollection(collectionName);

        newscol.insert(news);
    }
}

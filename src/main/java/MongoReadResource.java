import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/top-news")
@Produces(MediaType.APPLICATION_JSON)
public class MongoReadResource {

    @GET
    public Response returnTopNews(@QueryParam("date") String date){
        List<News> news = util.getNews(MongoReadApplication.collectionName, date);

        return Response.ok(news).build();
    }

    @POST
    public Response insertTopNews(News news){
        util.insertNews(MongoReadApplication.collectionName, news);

        return Response.ok(news).build();
    }
}

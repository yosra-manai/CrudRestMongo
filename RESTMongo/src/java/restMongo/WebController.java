/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restMongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author Abdallah
 */
@Path("API")  
public class WebController {
      
        
      
     @POST
     @Path("/{title}/{year}/{genre}/{summary}/{country}")  
     @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
     @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })  
     public Response insert(@PathParam("title") String name  , @PathParam("year") Integer year , @PathParam("genre") String genre , @PathParam("summary") String summary , @PathParam("country") String country){
      MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
      DB db = dbSingleton.getTestdb();
      DBCollection coll = db.getCollection("movies"); 
      BasicDBObject doc = new BasicDBObject("title", name).
        append("year", year).
        append("genre", genre).
        append("summary", summary).
        append("country", country);
        coll.insert(doc);
       
       return Response.status(200).build();
     }  
      
     @GET
     @Path("/")  
     @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
     public List<Movies> findAll(){
      MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
      DB db =dbSingleton.getTestdb();
      DBCollection coll = db.getCollection("movies"); 
      DBCursor cursor = coll.find();
      List<Movies> list = new ArrayList<Movies>();
      while (cursor.hasNext()) { 
             DBObject o = cursor.next();
             Movies bools = new Movies();
             bools.setTitle((String) o.get("title"));
             bools.setGenre((String) o.get("genre"));
             //bools.setYear((Integer) o.get("year"));
             bools.setSummary((String) o.get("summary"));
             bools.setCountry((String) o.get("country"));
             list.add(bools);
             
          }
      return list;
     }
      
     @GET
     @Path("/{title}") 
     @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
     public List<Movies> findByName(@PathParam("title") String message){
      MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
      DB db = dbSingleton.getTestdb();
      DBCollection coll = db.getCollection("movies"); 
      DBCursor cursor = coll.find(new BasicDBObject("title", message));
      List<Movies> list = new ArrayList<Movies>();
      while (cursor.hasNext()) { 
             DBObject o = cursor.next();
             Movies bools = new Movies();
             bools.setTitle((String) o.get("title"));
             bools.setGenre((String) o.get("genre"));
             bools.setYear((Integer) o.get("year"));
             bools.setSummary((String) o.get("summary"));
             bools.setCountry((String) o.get("country"));
             list.add(bools);
             
          }
      return list;
     }
     
     @DELETE
     @Path("/{title}")  
     @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })  
     public Response deleteDocument(@PathParam("title") String name){
          MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
          DB db = dbSingleton.getTestdb();
          DBCollection coll = db.getCollection("movies");
          coll.remove(new BasicDBObject().append("title", name));
          return Response.status(200).build();   
         
     }
     @PUT
     @Path("/{title}/{titleTo}")  
     @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
     @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })   
     public Response update(@PathParam("title") String name , @PathParam("titleTo") String newTitle){
          
          MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
          DB db = dbSingleton.getTestdb();
          DBCollection coll = db.getCollection("movies");
          DBCursor ItemsCursor = coll.find(new BasicDBObject().append("title", name));
          if(ItemsCursor.hasNext()) {
            DBObject object = ItemsCursor.next();
            object.put("title", newTitle);
            coll.save(object);
           }
         
      return Response.status(200).build();
     
}
}
     
     


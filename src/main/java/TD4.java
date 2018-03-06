import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.types.ObjectId;

public class TD4 {

    public static void main(String[] args) {
        //连接数据库，得到集合
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        //拿到数据库
        MongoDatabase db = mongoClient.getDatabase("test");
        System.out.println("ok");
        //权限认证

        //得到集合
        MongoCollection<Document> users = db.getCollection("users");

//        DeleteResult deleteOne = users.deleteOne(new Document("_id", new ObjectId("5a961fd9dd077e1b2403063d")));
//
//        System.out.println(deleteOne.getDeletedCount());
//        Systemtem.out.println("end.........");
        Document filet=new Document();
        Document d1=new Document();
        d1.put("$regex","^.*11.*");
        filet.put("userName",d1);
        users.deleteMany(filet);
        System.out.println("删除成功");
    }
}

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

public class TD3 {

    public static void main(String[] args) {
        //连接数据库，得到集合
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        //拿到数据库
        MongoDatabase db = mongoClient.getDatabase("test");
        System.out.println("ok");
        //权限认证


        //查单个
        MongoCollection<Document> users = db.getCollection("users");

  //     Document user=new Document("_id",new ObjectId("5a961fd9dd077e1b24030699"));
//db.users.find({userName:{$regex:/^.*11.*/}})
       // db.users.find({age:{$gte:50,$lte:150}})
        //根据条件来查询
        Document filet=new Document();
        Document d1=new Document();
        Document d2=new Document();
        d2.put("$gte",120);
        d2.put("$lte",200);
        d1.put("$regex","^.*11.*");

        filet.put("userName",d1);
        filet.put("age",d2);



        FindIterable<Document> findIterable = users.find(filet);
        MongoCursor<Document> it = findIterable.iterator();
        while(it.hasNext()){
            Document next = it.next();
            System.out.println(next);
        }

        System.out.println("成功查询");
    }
}

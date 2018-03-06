import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class TD {

    public static void main(String[] args) {
        //连接数据库，得到集合
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        //拿到数据库
        MongoDatabase db = mongoClient.getDatabase("test");
        System.out.println("ok");
        //权限认证

        //得到集合
        MongoCollection<Document> users = db.getCollection("users");
        Document user=new Document();
        user.put("userName","晓晓");
        user.put("userPwd","123");
        user.put("sex","男");
        user.put("age",123);
        user.put("remark","abc");

        users.insertOne(user);
        System.out.println("添加成功");
    }
}

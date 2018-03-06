import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class TDD2 {

    public static void main(String[] args) {
        //连接数据库，得到集合
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        //拿到数据库
        MongoDatabase db = mongoClient.getDatabase("test");
        System.out.println("ok");
        //权限认证

        //得到集合
        MongoCollection<Document> users = db.getCollection("users");
        List<Document> list=new ArrayList<Document>();
        Document user=null;
        for (int i=0;i<1000;i++){
            user=new Document();
            user.put("userName","晓晓"+i);
            user.put("userPwd","123"+i);
            user.put("sex","男");
            user.put("age",123+i);
            user.put("remark","abc"+i);
            list.add(user);
        }
        users.insertMany(list);
        System.out.println("添加成功");
    }
}

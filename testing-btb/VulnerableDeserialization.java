import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class VulnerableDeserialization {
    public static void main(String[] args) {
        try {
            String serializedObject = "rO0ABXNyABFqYXZhLm5ldC5VUkxDbGFzc0xvYWRlcgAAAAAAAAAAAAAAeHB3CAAAABAAAAACdAAQamF2YS9uZXQvdXJsO3hwdwQAAAAGZGVmYXVsdA==";
            byte[] data = java.util.Base64.getDecoder().decode(serializedObject);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            Object obj = ois.readObject();
            ois.close();
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

class SafeObject implements Serializable {
    private static final long serialVersionUID = 1L;
    private String data;

    public SafeObject(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SafeObject [data=" + data + "]";
    }
}

public class SafeDeserialization {
    public static void main(String[] args) {
        try {
            SafeObject safeObject = new SafeObject("example");
            byte[] data = serialize(safeObject);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            Object obj = ois.readObject();
            ois.close();
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] serialize(Object obj) throws Exception {
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
        oos.writeObject(obj);
        return baos.toByteArray();
    }
}

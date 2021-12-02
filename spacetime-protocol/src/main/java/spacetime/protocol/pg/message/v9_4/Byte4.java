package spacetime.protocol.pg.message.v9_4;

/**
 * @author zhangsx
 */
public class Byte4 {
    private byte[] content;
    public static Byte4 build(byte[] content){
        return new Byte4(content);
    }
    private Byte4(byte[] content){
        assert content!=null;
        assert content.length==4;
        this.content=content;
    }

    public byte[] getContent(){
        return this.content;
    }
}

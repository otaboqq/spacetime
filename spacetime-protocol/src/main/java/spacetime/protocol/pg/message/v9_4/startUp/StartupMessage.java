package spacetime.protocol.pg.message.v9_4.startUp;

/**
 * @author zhangsx
 */
public class StartupMessage {
    private int length;
    private int version;
    private String parameterName;
    private String parameterValue;
    public void decode(int length,byte[] content){
        this.length=length;
    }
}

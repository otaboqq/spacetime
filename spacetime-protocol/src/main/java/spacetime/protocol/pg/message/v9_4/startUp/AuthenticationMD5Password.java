package spacetime.protocol.pg.message.v9_4.startUp;

import spacetime.protocol.pg.message.v9_4.Byte4;
import spacetime.utils.Byte2Util;
import spacetime.utils.ByteFluentUtil;

/**
 * @author zhangsx
 */
public class AuthenticationMD5Password {
    private byte identity = 'R';
    private int length = 12;
    private int type = 5;
    private byte[] msg4;

    public byte[] encode(byte[] msg4) {
        this.msg4 = msg4;
        return ByteFluentUtil.fluent(new byte[]{identity}).
                append(Byte2Util.intToByte4(length)).
                append(Byte2Util.intToByte4(type)).
                append(msg4).
                ok();
    }
}

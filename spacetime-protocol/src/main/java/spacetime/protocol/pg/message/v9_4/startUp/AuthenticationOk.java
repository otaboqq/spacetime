package spacetime.protocol.pg.message.v9_4.startUp;

import spacetime.utils.Byte2Util;
import spacetime.utils.ByteFluentUtil;

/**
 * @author zhangsx
 */
public class AuthenticationOk {
    private byte identity = 'R';
    private int length = 8;
    private int type = 0;

    public byte[] encode() {
        return ByteFluentUtil.fluent(new byte[]{identity}).
                append(Byte2Util.intToByte4(length)).
                append(Byte2Util.intToByte4(type)).
                ok();
    }
}

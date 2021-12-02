package spacetime.utils;

/**
 * @author zhangsx
 */
public class Byte2Util {
    public static byte[] intToByte4(int source,byte[] dest,int offset) {
        for(int i=0;i<4;i++){
            dest[offset+3]=(byte) (source >> 0 & 0xFF);
            dest[offset+2]=(byte) (source >> 8 & 0xFF);
            dest[offset+1]=(byte) (source >> 16 & 0xFF);
            dest[offset]=(byte) (source >> 24 & 0xFF);
        }
        return dest;
    }

    public static byte[] intToByte4(int source) {
        byte[] content=new byte[4];
        return intToByte4(source,content,0);
    }
}

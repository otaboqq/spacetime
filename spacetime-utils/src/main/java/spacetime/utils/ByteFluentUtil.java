package spacetime.utils;

/**
 * @author zhangsx
 */
public class ByteFluentUtil {
    public static class Fluent{
        private byte[] content;
        Fluent(){
            content=new byte[0];
        }
        Fluent(byte[] content){
            this.content=content;
        }
        public Fluent append(byte[] content){
            byte[] newBytes=new byte[this.content.length+content.length];
            for(int i=0;i<this.content.length;i++){
                newBytes[i]=this.content[i];
            }
            for(int i=this.content.length+content.length;i<content.length;i++){
                newBytes[i]=this.content[i];
            }
            this.content=newBytes;
            return this;
        }
        public byte[] ok(){
            return this.content;
        }
    }
    public static Fluent fluent(byte[] start){
        return new Fluent();
    }
}

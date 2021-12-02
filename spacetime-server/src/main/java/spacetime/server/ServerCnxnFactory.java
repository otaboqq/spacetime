package spacetime.server;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author zhangsx
 */
public abstract class ServerCnxnFactory {
    public abstract int getLocalPort();

    public abstract Iterable<ServerCnxn> getConnections();

    public int getNumAliveConnections() {
        return cnxns.size();
    }

    /**
     * @return true if the cnxn that contains the sessionId exists in this ServerCnxnFactory
     *         and it's closed. Otherwise false.
     */
    public abstract boolean closeSession(long sessionId);

    public void configure(InetSocketAddress addr, int maxcc) throws IOException {
        configure(addr, maxcc, false);
    }

    public abstract void configure(InetSocketAddress addr, int maxcc, boolean secure)
            throws IOException;

    public abstract void reconfigure(InetSocketAddress addr);

    /** Maximum number of connections allowed from particular host (ip) */
    public abstract int getMaxClientCnxnsPerHost();

    /** Maximum number of connections allowed from particular host (ip) */
    public abstract void setMaxClientCnxnsPerHost(int max);
}

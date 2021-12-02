package spacetime.protocol.pg.message.v9_4.event;

import spacetime.protocol.pg.message.v9_4.startUp.StartupMessage;

/**
 * @author zhangsx
 */
public interface EventListener {
    void handleEvent(StartupMessage event);
}

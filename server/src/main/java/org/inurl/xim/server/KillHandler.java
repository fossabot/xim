package org.inurl.xim.server;

import sun.misc.Signal;
import sun.misc.SignalHandler;

/**
 * @author raylax
 */
public class KillHandler implements SignalHandler {

    private static final String KILL_SIGNAL_WINDOWS = "TERM";
    private static final String KILL_SIGNAL_UNIX_LIKE = "INT";

    private Runnable runnable;

    KillHandler(Runnable runnable) {
        this.runnable = runnable;
        registerSignal();
    }

    private void registerSignal() {
        String killSignal = System.getProperty("os.name").toLowerCase().contains("windows")
                ? KILL_SIGNAL_WINDOWS
                : KILL_SIGNAL_UNIX_LIKE;
        Signal signal = new Signal(killSignal);
        Signal.handle(signal, this);
        Runtime.getRuntime().addShutdownHook(new Thread(runnable));
    }

    @Override
    public void handle(Signal signal) {
        runnable.run();
    }

}
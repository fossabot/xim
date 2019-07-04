package org.inurl.xim.server;

/**
 * @author raylax
 */
public class XIMApp {

    public static void main(String[] args) {
        Server server = new Server("0.0.0.0", 9997);
        new KillHandler(server::stop);
        server.start();
    }

}

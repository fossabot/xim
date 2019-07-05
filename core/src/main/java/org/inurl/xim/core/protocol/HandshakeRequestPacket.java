package org.inurl.xim.core.protocol;

/**
 * @author raylax
 */
public class HandshakeRequestPacket extends AbstractPacket {

    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

}

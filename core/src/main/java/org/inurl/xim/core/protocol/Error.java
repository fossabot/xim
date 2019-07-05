package org.inurl.xim.core.protocol;

/**
 * @author raylax
 */
public enum Error {

    /**
     * Not Handshake packet
     */
    NOT_HANDSHAKE(100001),
    /**
     * Authorization failure
     */
    AUTHORIZATION_FAILURE(100002),
    ;

    private int value;

    private String desc;

    Error(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

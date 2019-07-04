package org.inurl.xim.core.protocol;

/**
 * 会话类型
 * @author raylax
 */
public enum SessionType {

    /**
     * 点对点消息
     */
    P2P(1),
    /**
     * 群组消息
     */
    GROUP(2),

    ;
    private int value;

    SessionType(int value) {
        this.value = value;
    }

    public SessionType fromValue(int value) {
        switch (value) {
            case 1:
                return P2P;
            case 2:
                return GROUP;
            default:
                throw new IllegalArgumentException("Unknown session type [" + value + "]");
        }
    }

}

package org.inurl.xim.core.protocol;

/**
 * @author raylax
 */
public class Constant {

    /**
     * 握手
     */
    public static final int PACKET_TYPE_HANDSHAKE = 0;

    /**
     * 消息
     */
    public static final int PACKET_TYPE_MESSAGE = 1;

    /**
     * 错误
     */
    public static final int PACKET_TYPE_ERROR = Byte.MAX_VALUE;

    /**
     * 请求已接受
     */
    public static final int PACKET_TYPE_ACCEPT = PACKET_TYPE_ERROR - 1;

}

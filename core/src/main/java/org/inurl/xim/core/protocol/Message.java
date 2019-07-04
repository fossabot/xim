package org.inurl.xim.core.protocol;

/**
 * 消息
 * @author raylax
 */
public class Message {

    /**
     * 消息ID
     */
    private int messageId;

    /**
     * 标志位
     */
    private int flags;

    /**
     * 会话类型
     */
    private SessionType sessionType;

    /**
     * 发送者ID
     */
    private String sender;

    /**
     * 接收者ID
     */
    private String receiver;

    /**
     * 内容
     */
    private byte[] content;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public SessionType getSessionType() {
        return sessionType;
    }

    public void setSessionType(SessionType sessionType) {
        this.sessionType = sessionType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

}

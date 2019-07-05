package org.inurl.xim.core.protocol;

/**
 * @author raylax
 */
public class ErrorPacket extends AbstractPacket {

    private Error error;

    public ErrorPacket(Error error) {
        super();
        this.error = error;
        setPacketType(Constant.PACKET_TYPE_ERROR);
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }

}

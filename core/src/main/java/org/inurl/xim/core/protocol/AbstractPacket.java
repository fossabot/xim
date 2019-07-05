package org.inurl.xim.core.protocol;

/**
 * @author raylax
 */
public class AbstractPacket {

    public AbstractPacket() {
        this.trackId = TrackIdGenerator.generate();
    }

    private String trackId;

    private int flags;

    private int packetType;

    public void setPacketType(int packetType) {
        this.packetType = packetType;
    }

    public int getPacketType() {
        return packetType;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }


}

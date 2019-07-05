package org.inurl.xim.core.protocol;

public class AcceptPacket extends AbstractPacket {

    public AcceptPacket(AbstractPacket base) {
        super();
        setPacketType(Constant.PACKET_TYPE_ACCEPT);
        setFlags(base.getFlags());
        setTrackId(base.getTrackId());
    }

}

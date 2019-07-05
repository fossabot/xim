package org.inurl.xim.core.protocol;

import java.util.UUID;

/**
 * @author raylax
 */
public class TrackIdGenerator {

    public static String generate() {
        return UUID.randomUUID().toString();
    }

}

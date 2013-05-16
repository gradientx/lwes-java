package org.lwes.test;

import java.net.InetAddress;

import org.junit.Ignore;
import org.lwes.Event;
import org.lwes.emitter.SnappyUnicastEventEmitter;

@Ignore
public class TestSnappyUnicastEmitter {
	public static void main(String[] args) {
		try {
			SnappyUnicastEventEmitter emitter = new SnappyUnicastEventEmitter();
			emitter.setAddress(InetAddress.getLocalHost());
			emitter.initialize();
			
			Event e = emitter.createEvent("MyEvent", false);
			e.setBoolean("boolean", true);
			e.setInt16("int16", (short) 12345);
			e.setUInt16("uint16", 56789);
			e.setInt32("int32", 55555555);
			e.setUInt32("uint32", 20392039402L);
			e.setInt64("int64", 9999999);
			e.setUInt64("uint64", new java.math.BigInteger("9999999"));
			e.setIPAddress("ip", InetAddress.getByName("24.199.3.198"));
			e.setString("key", "value");
			while(true)
				emitter.emit(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

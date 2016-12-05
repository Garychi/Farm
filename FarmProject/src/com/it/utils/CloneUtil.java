package com.it.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CloneUtil {
	public CloneUtil() {
	}

	public static Object clone(Object paramObject) {
		Object localObject = null;
		try {
			ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
			localObjectOutputStream.writeObject(paramObject);
			localObjectOutputStream.close();
			ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
			ObjectInputStream localObjectInputStream = new ObjectInputStream(localByteArrayInputStream);
			localObject = localObjectInputStream.readObject();
			localObjectInputStream.close();
		}
		catch (Exception localException) {
			localException.printStackTrace();
		}
		return localObject;
	}
}

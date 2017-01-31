package com.jxjxgo.common.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by fangzhongwei on 2016/4/7.
 */
public abstract class GZipUtils {

    private static String encode = "utf-8";

    public GZipUtils() {
    }

    public static byte[] compressToByte(String str) throws IOException {
        return compressToByte(str, encode);
    }

    public static byte[] compressToByte(String str, String encoding) throws IOException {
        if (str != null && str.length() != 0) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            GZIPOutputStream gzip = null;

            try {
                gzip = new GZIPOutputStream(out);
                gzip.write(str.getBytes(encoding));
                gzip.close();
                byte[] e = out.toByteArray();
                return e;
            } finally {
                if (gzip != null) {
                    gzip.close();
                }

            }

        } else {
            return null;
        }
    }

    public static String uncompressToString(byte[] b) throws IOException {
        return uncompressToString(b, encode);
    }

    public static String uncompressToString(byte[] b, String encoding) throws IOException {
        if (b != null && b.length != 0) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ByteArrayInputStream in = new ByteArrayInputStream(b);

            try {
                GZIPInputStream e = new GZIPInputStream(in);
                byte[] buffer = new byte[2048];

                int n;
                while ((n = e.read(buffer)) >= 0) {
                    out.write(buffer, 0, n);
                }

                String var7 = out.toString(encoding);
                return var7;
            } finally {
                if (out != null) {
                    out.close();
                }

                if (in != null) {
                    in.close();
                }

            }

        } else {
            return null;
        }
    }
}
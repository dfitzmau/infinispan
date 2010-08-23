package org.infinispan.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.OutputStream;
import java.nio.Buffer;

/**
 * Helper to read and write unsigned numerics
 *
 * @author Manik Surtani
 * @since 4.0
 */
public class UnsignedNumeric {
   /**
    * Reads an int stored in variable-length format.  Reads between one and five bytes.  Smaller values take fewer
    * bytes.  Negative numbers are not supported.
    */
   public static int readUnsignedInt(ObjectInput in) throws IOException {
      byte b = in.readByte();
      int i = b & 0x7F;
      for (int shift = 7; (b & 0x80) != 0; shift += 7) {
         b = in.readByte();
         i |= (b & 0x7FL) << shift;
      }
      return i;
   }
   
   public static int readUnsignedInt(InputStream in) throws IOException {
      int b = in.read();
      int i = b & 0x7F;
      for (int shift = 7; (b & 0x80) != 0; shift += 7) {
         b = in.read();
         i |= (b & 0x7FL) << shift;
      }
      return i;
   }
   
   public static int readUnsignedInt(java.nio.ByteBuffer in) throws IOException {
      int b = in.get();
      int i = b & 0x7F;
      for (int shift = 7; (b & 0x80) != 0; shift += 7) {
         b = in.get();
         i |= (b & 0x7FL) << shift;
      }
      return i;
   }

   /**
    * Writes an int in a variable-length format.  Writes between one and five bytes.  Smaller values take fewer bytes.
    * Negative numbers are not supported.
    *
    * @param i int to write
    */
   public static void writeUnsignedInt(ObjectOutput out, int i) throws IOException {
      while ((i & ~0x7F) != 0) {
         out.writeByte((byte) ((i & 0x7f) | 0x80));
         i >>>= 7;
      }
      out.writeByte((byte) i);
   }

   public static void writeUnsignedInt(OutputStream out, int i) throws IOException {
      while ((i & ~0x7F) != 0) {
         out.write((byte) ((i & 0x7f) | 0x80));
         i >>>= 7;
      }
      out.write((byte) i);
   }
   
   public static void writeUnsignedInt(java.nio.ByteBuffer out, int i) throws IOException {
      while ((i & ~0x7F) != 0) {
         out.put((byte) ((i & 0x7f) | 0x80));
         i >>>= 7;
      }
      out.put((byte) i);
   }


   /**
    * Reads an int stored in variable-length format.  Reads between one and nine bytes.  Smaller values take fewer
    * bytes.  Negative numbers are not supported.
    */
   public static long readUnsignedLong(ObjectInput in) throws IOException {
      byte b = in.readByte();
      long i = b & 0x7F;
      for (int shift = 7; (b & 0x80) != 0; shift += 7) {
         b = in.readByte();
         i |= (b & 0x7FL) << shift;
      }
      return i;
   }

   public static long readUnsignedLong(InputStream in) throws IOException {
      int b = in.read();
      long i = b & 0x7F;
      for (int shift = 7; (b & 0x80) != 0; shift += 7) {
         b = in.read();
         i |= (b & 0x7FL) << shift;
      }
      return i;
   }
   public static long readUnsignedLong(java.nio.ByteBuffer in) throws IOException {
      int b = in.get();
      long i = b & 0x7F;
      for (int shift = 7; (b & 0x80) != 0; shift += 7) {
         b = in.get();
         i |= (b & 0x7FL) << shift;
      }
      return i;
   }

   /**
    * Writes an int in a variable-length format.  Writes between one and nine bytes.  Smaller values take fewer bytes.
    * Negative numbers are not supported.
    *
    * @param i int to write
    */
   public static void writeUnsignedLong(ObjectOutput out, long i) throws IOException {
      while ((i & ~0x7F) != 0) {
         out.writeByte((byte) ((i & 0x7f) | 0x80));
         i >>>= 7;
      }
      out.writeByte((byte) i);
   }

   public static void writeUnsignedLong(OutputStream out, long i) throws IOException {
      while ((i & ~0x7F) != 0) {
         out.write((byte) ((i & 0x7f) | 0x80));
         i >>>= 7;
      }
      out.write((byte) i);
   }

   public static void writeUnsignedLong(java.nio.ByteBuffer out, long i) throws IOException {
      while ((i & ~0x7F) != 0) {
         out.put((byte) ((i & 0x7f) | 0x80));
         i >>>= 7;
      }
      out.put((byte) i);
   }

     /**
    * Reads an int stored in variable-length format.  Reads between one and five bytes.  Smaller values take fewer
    * bytes.  Negative numbers are not supported.
    */
   public static int readUnsignedInt(byte[] bytes, int offset) throws IOException {
      byte b = bytes[offset++];
      int i = b & 0x7F;
      for (int shift = 7; (b & 0x80) != 0; shift += 7) {
         b = bytes[offset++];
         i |= (b & 0x7FL) << shift;
      }
      return i;
   }

   /**
    * Writes an int in a variable-length format.  Writes between one and five bytes.  Smaller values take fewer bytes.
    * Negative numbers are not supported.
    *
    * @param i int to write
    */
   public static void writeUnsignedInt(byte[] bytes, int offset, int i) throws IOException {
      while ((i & ~0x7F) != 0) {
         bytes[offset++] = (byte) ((i & 0x7f) | 0x80);
         i >>>= 7;
      }
      bytes[offset] = (byte) i;
   }


   /**
    * Reads an int stored in variable-length format.  Reads between one and nine bytes.  Smaller values take fewer
    * bytes.  Negative numbers are not supported.
    */
   public static long readUnsignedLong(byte[] bytes, int offset) throws IOException {
      byte b = bytes[offset++];
      long i = b & 0x7F;
      for (int shift = 7; (b & 0x80) != 0; shift += 7) {
         b = bytes[offset++];
         i |= (b & 0x7FL) << shift;
      }
      return i;
   }

   /**
    * Writes an int in a variable-length format.  Writes between one and nine bytes.  Smaller values take fewer bytes.
    * Negative numbers are not supported.
    *
    * @param i int to write
    */
   public static void writeUnsignedLong(byte[] bytes, int offset, long i) throws IOException {
      while ((i & ~0x7F) != 0) {
         bytes[offset++] = (byte) ((i & 0x7f) | 0x80);
         i >>>= 7;
      }
      bytes[offset] = (byte) i;
   }
}

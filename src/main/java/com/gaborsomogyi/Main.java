package com.gaborsomogyi;

import net.jpountz.lz4.LZ4BlockInputStream;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
  private static final int BLOCK_SIZE = 1024 * 1024;

  public static void main(String[] args) throws IOException {
    if (args.length != 2) {
      System.err.println("Usage: Main [inFileName] [outFileName]");
      System.exit(1);
    }

    FileInputStream fis = new FileInputStream(new File(args[0]));
    LZ4BlockInputStream bis = new LZ4BlockInputStream(fis);

    try {
      byte[] buf = new byte[BLOCK_SIZE];
      PrintWriter pw = new PrintWriter(new File(args[1]));
      try {
        int len = 0;
        while ((len = bis.read(buf)) != 0) {
          pw.write(new String(buf, 0, len, StandardCharsets.UTF_8));
        }
      } finally {
        pw.close();
      }
    } catch(EOFException e) {
      // No action needed
    } finally {
      bis.close();
    }
  }
}

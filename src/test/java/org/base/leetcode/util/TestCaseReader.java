package org.base.leetcode.util;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class TestCaseReader {
    public static String readTestInput(final String filename) {
        try {
            return IOUtils.resourceToString(filename, Charset.defaultCharset());
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

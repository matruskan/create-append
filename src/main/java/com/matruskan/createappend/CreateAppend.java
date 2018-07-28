/*
 * The MIT License
 *
 * Copyright 2018 matruskan
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.matruskan.createappend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Creates a file and write to it if it doesn't already exist;
 * appends to the file if it already exists.
 *
 * Answers the question:
 * Java - is there a way to open a text file if it does not exist already, and
 * append to it if it does exist?
 * https://stackoverflow.com/questions/43103578/
 */
public class CreateAppend {
    public void write(File file, String text) throws IOException {
        Path path = file.toPath();
        Charset charSet = StandardCharsets.UTF_8;
        OpenOption[] options = new OpenOption[]{
            StandardOpenOption.CREATE, // Create a new file if it does not exist
            StandardOpenOption.WRITE,  // Open for write access
            StandardOpenOption.APPEND  // Bytes will be written to the end of
                                       // the file rather than the beginning
        };
        try (BufferedWriter bw = Files.newBufferedWriter(path, charSet, options)) {
            bw.write(text);
        }
    }
}

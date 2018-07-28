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

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class CreateAppendTest {

    private static final String TEMP_DIR = System.getProperty("java.io.tmpdir");
    public static final String NEW_LINE = System.lineSeparator();

    public CreateAppendTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of write method, of class CreateAppend.
     */
    @Test
    public void testCreateFileIfItDoesntExist() throws Exception {
        System.out.println("CreateFileIfItDoesntExist");
        File file = new File(TEMP_DIR + "/CreateFileIfItDoesntExist.txt");
        file.deleteOnExit();
        assertFalse(file.exists());
        String text = "CreateFileIfItDoesntExist";
        CreateAppend instance = new CreateAppend();
        instance.write(file, text);
        String expected = Files.readAllLines(file.toPath()).get(0);
        assertEquals(text, expected);
    }
    @Test
    public void testAppendToFileIfItExists() throws Exception {
        System.out.println("AppendToFileIfItExists");
        File file = new File(TEMP_DIR + "/AppendToFileIfItExists.txt");
        file.createNewFile();
        file.deleteOnExit();
        assertTrue(file.exists());
        String text1 = "AppendToFileIfItExists1";
        String text2 = "AppendToFileIfItExists2";
        CreateAppend instance = new CreateAppend();
        instance.write(file, text1);
        instance.write(file, NEW_LINE);
        instance.write(file, text2);
        List<String> result = Files.readAllLines(file.toPath());
        List<String> expected = Arrays.asList(text1, text2);
        assertEquals(expected, result);
    }

}

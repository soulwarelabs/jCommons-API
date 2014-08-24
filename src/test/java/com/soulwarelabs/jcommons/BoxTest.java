/*
 * Project:  jCommons API
 * Outline:  jCommons framework API components
 *
 * File:     BoxTest.java
 * Folder:   src/test/java/com/soulwarelabs/jcommons
 * Revision: 1.00, 24 August 2014
 * Created:  24 August 2014
 * Authors:  Ilya Gubarev
 *
 * Copyright (c) 2014 Soulware Labs, Ltd.
 * Contact information is available at "http://www.soulwarelabs.com".
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       "http://www.apache.org/licenses/LICENSE-2.0".
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.soulwarelabs.jcommons;

import org.junit.Assert;
import org.junit.Test;

/**
 * Value container unit test.
 *
 * @see Box
 *
 * @since v1.1.0
 *
 * @author Ilya Gubarev
 * @version 24 August 2014
 */
public class BoxTest {

    /**
     * Creates a new unit test.
     *
     * @since v1.1.0
     */
    public BoxTest() {

    }

    @Test
    public void testEquals() {
        Box<String> box = new Box<String>();
        Assert.assertEquals(true, box.equals(box));
        Object object = null;
        Assert.assertEquals(false, box.equals(object));
        Box<String> other = new Box<String>("test");
        Assert.assertEquals(false, box.equals(other));
        box.setValue("test");
        Assert.assertEquals(true, box.equals(other));
    }
}

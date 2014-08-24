/*
 * Project:  jCommons API
 * Outline:  jCommons framework API components
 *
 * File:     Version.java
 * Folder:   /.../com/soulwarelabs/jcommons/data
 * Revision: 1.06, 23 August 2014
 * Created:  10 May 2014
 * Authors:  Ilya Gubarev
 *
 * Copyright (c) 2013-2014 Soulware Labs, Ltd.
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
package com.soulwarelabs.jcommons.data;

import java.util.LinkedList;
import java.util.List;

import com.soulwarelabs.jcommons.Pojo;
import com.soulwarelabs.jcommons.Printable;

/**
 * Semantic version descriptor.
 * <p>
 * Learn more about semantic versioning at "http://semver.org".
 *
 * @see Comparable
 * @see Pojo
 * @see Printable
 *
 * @since v1.1.0
 *
 * @author Ilya Gubarev
 * @version 23 August 2014
 */
public class Version extends Pojo implements Comparable<Version>, Printable {

    /**
     * Index of a major version number.
     *
     * @since v1.1.0
     */
    public static final int MAJOR_INDEX = 1;

    /**
     * Index of a minor version number.
     *
     * @since v1.1.0
     */
    public static final int MINOR_INDEX = 2;

    /**
     * Index of a patch version number.
     *
     * @since v1.1.0
     */
    public static final int PATCH_INDEX = 3;

    /**
     * Create a new copy of version descriptor.
     *
     * @param version original version descriptor (optional).
     * @return copied version descriptor (optional).
     *
     * @since v1.1.0
     */
    public static Version copy(Version version) {
        if (version == null) {
            return null;
        }
        Version result = new Version();
        result.labels = new LinkedList<String>(version.labels);
        result.numbers = new LinkedList<Integer>(version.numbers);
        result.snapshot = version.snapshot;
        return result;
    }

    /**
     * Creates a new version descriptor based on its string presentation.
     *
     * @param version string presentation of a version.
     * @return version descriptor.
     * @throws RuntimeException if error occurs while parsing the version.
     *
     * @since v1.1.0
     */
    public static Version parse(String version) {
        // TODO: implement version parsing
        throw new UnsupportedOperationException();
    }

    /**
     * Creates a new version descriptor.
     *
     * @since v1.1.0
     */
    public Version() {
        this(new int[0]);
    }

    /**
     * Creates a new version descriptor.
     *
     * @param numbers version numbers.
     * @throws NullPointerException if numbers is null.
     *
     * @since v1.1.0
     */
    public Version(int... numbers) {
        resetNumbers(numbers);
    }

    /**
     * Gets a total amount of version numbers.
     *
     * @return total amount of version numbers.
     *
     * @since v1.1.0
     */
    public int getLength() {
        return numbers.size();
    }

    /**
     * Gets a major version number if available.
     *
     * @return major version number (optional).
     *
     * @see #getNumber(int)
     *
     * @since v1.1.0
     */
    public Integer getMajor() {
        return getNumber(MAJOR_INDEX);
    }

    /**
     * Gets major version number availability.
     *
     * @return true if major version number is available.
     *
     * @since v1.1.0
     */
    public boolean isMajorAvailable() {
        return numbers.size() >= MAJOR_INDEX;
    }

    /**
     * Gets a major version number label if available.
     *
     * @return major version number label (optional).
     *
     * @see #getNumberLabel(int)
     *
     * @since v1.1.0
     */
    public String getMajorLabel() {
        return getNumberLabel(MAJOR_INDEX);
    }

    /**
     * Sets a new major version number.
     *
     * @param major major version number (not negative).
     * @return version descriptor.
     * @throws IllegalArgumentException if version number is illegal.
     *
     * @see #setMajor(int, String)
     *
     * @since v1.1.0
     */
    public Version setMajor(int major) {
        return setMajor(major, null);
    }

    /**
     * Sets a new major version number.
     *
     * @param major major version number (not negative).
     * @param label major version number label (optional).
     * @return version descriptor.
     * @throws IllegalArgumentException if version number is illegal.
     *
     * @see #setNumber(int, int, String)
     *
     * @since v1.1.0
     */
    public Version setMajor(int major, String label) {
        return setNumber(MAJOR_INDEX, major, label);
    }

    /**
     * Gets a minor version number if available.
     *
     * @return minor version number (optional).
     *
     * @see #getNumber(int)
     *
     * @since v1.1.0
     */
    public Integer getMinor() {
        return getNumber(MINOR_INDEX);
    }

    /**
     * Gets minor version number availability.
     *
     * @return true if minor version number is available.
     *
     * @since v1.1.0
     */
    public boolean isMinorAvailable() {
        return numbers.size() >= MINOR_INDEX;
    }

    /**
     * Gets a minor version number label if available.
     *
     * @return minor version number label (optional).
     *
     * @see #getNumberLabel(int)
     *
     * @since v1.1.0
     */
    public String getMinorLabel() {
        return getNumberLabel(MINOR_INDEX);
    }

    /**
     * Sets a new minor version number.
     *
     * @param minor minor version number (not negative).
     * @return version descriptor.
     * @throws IllegalArgumentException if version number is illegal.
     *
     * @see #setMinor(int, String)
     *
     * @since v1.1.0
     */
    public Version setMinor(int minor) {
        return setMinor(minor, null);
    }

    /**
     * Sets a new minor version number.
     *
     * @param minor minor version number (not negative).
     * @param label minor version number label (optional).
     * @return version descriptor.
     * @throws IllegalArgumentException if version number is illegal.
     *
     * @see #setNumber(int, int, String)
     *
     * @since v1.1.0
     */
    public Version setMinor(int minor, String label) {
        return setNumber(MINOR_INDEX, minor, label);
    }

    /**
     * Gets a patch version number if available.
     *
     * @return patch version number (optional).
     *
     * @see #getNumber(int)
     *
     * @since v1.1.0
     */
    public Integer getPatch() {
        return getNumber(PATCH_INDEX);
    }

    /**
     * Gets patch version number availability.
     *
     * @return true if patch version number is available.
     *
     * @since v1.1.0
     */
    public boolean isPatchAvailable() {
        return numbers.size() >= PATCH_INDEX;
    }

    /**
     * Gets a patch version number label if available.
     *
     * @return patch version number label (optional).
     *
     * @see #getNumberLabel(int)
     *
     * @since v1.1.0
     */
    public String getPatchLabel() {
        return getNumberLabel(PATCH_INDEX);
    }

    /**
     * Sets a new patch version number.
     *
     * @param patch patch version number (not negative).
     * @return version descriptor.
     * @throws IllegalArgumentException if version number is illegal.
     *
     * @see #setPatch(int, String)
     *
     * @since v1.1.0
     */
    public Version setPatch(int patch) {
        return setPatch(patch, null);
    }

    /**
     * Sets a new patch version number.
     *
     * @param patch patch version number (not negative).
     * @param label patch version number label (optional).
     * @return version descriptor.
     * @throws IllegalArgumentException if version number is illegal.
     *
     * @see #setNumber(int, int, String)
     *
     * @since v1.1.0
     */
    public Version setPatch(int patch, String label) {
        return setNumber(PATCH_INDEX, patch, label);
    }

    /**
     * Gets this version snapshot status.
     * 
     * @return true if this version is a snapshot.
     *
     * @since v1.1.0
     */
    public boolean isSnapshot() {
        return snapshot;
    }

    /**
     * Sets this version snapshot status.
     *
     * @param snapshot true if this version is a snapshot.
     * @return version descriptor.
     *
     * @since v1.1.0
     */
    public Version setSnapshot(boolean snapshot) {
        this.snapshot = snapshot;
        return this;
    }

    /**
     * Adds a new version number.
     *
     * @param number version number (not negative).
     * @return version descriptor.
     * @throws IllegalArgumentException if version number is illegal.
     *
     * @since v1.1.0
     */
    public Version append(int number) {
        return append(number, null);
    }

    /**
     * Adds a new version number.
     *
     * @param number version number (not negative).
     * @param label version number label (optional).
     * @return version descriptor.
     * @throws IllegalArgumentException if version number is illegal.
     *
     * @since v1.1.0
     */
    public Version append(int number, String label) {
        validateNumber(number);
        return appendNumber(number, label);
    }

    @Override
    public Version copy() {
        return copy(this);
    }

    @Override
    public int compareTo(Version version) {
        if (version == null) {
            throw new NullPointerException("version is null");
        }
        // TODO: impement version comparison
        throw new UnsupportedOperationException();
    }

    /**
     * Removes version numbers starting after specified index.
     *
     * @param index last number index (positive).
     * @return version descriptor.
     * @throws IllegalArgumentException if specified index is illegal.
     *
     * @since v1.1.0
     */
    public Version cutoff(int index) {
        if (!isBeyondBounds(index)) {
            labels = labels.subList(--index, labels.size());
            numbers = numbers.subList(index, numbers.size());
        }
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        Version other = (Version) object;
        if (labels == null || !labels.equals(other.labels)) {
            return false;
        }
        if (numbers == null || !numbers.equals(other.numbers)) {
            return false;
        }
        if (snapshot != other.snapshot) {
            return false;
        }
        return true;
    }

    /**
     * Gets a version number if available.
     *
     * @param index version number index (positive).
     * @return version number (optional).
     * @throws IllegalArgumentException if specified index is illegal.
     *
     * @since v1.1.0
     */
    public Integer getNumber(int index) {
        if (isBeyondBounds(index)) {
            return null;
        } else {
            return numbers.get(--index);
        }
    }

    /**
     * Gets a version number label if available.
     *
     * @param index version number index (positive).
     * @return version number label (optional).
     * @throws IllegalArgumentException if specified index is illegal.
     *
     * @since v1.1.0
     */
    public String getNumberLabel(int index) {
        if (isBeyondBounds(index)) {
            return null;
        } else {
            return labels.get(--index);
        }
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 67 * result + (labels != null ? labels.hashCode() : 0);
        result = 67 * result + (numbers != null ? numbers.hashCode() : 0);
        result = 67 * result + (snapshot ? 1 : 0);
        return result;
    }

    @Override
    public StringBuilder print() {
        int length = numbers.size();
        if (length == 0) {
            return new StringBuilder("unknown");
        }
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < length; index++) {
            result.append(numbers.get(index));
            String label = labels.get(index);
            if (label != null) {
                result.append("-").append(label);
            }
            if (index < length - 1) {
                result.append(".");
            }
        }
        if (snapshot) {
            result.append("-SNAPSHOT");
        }
        return result;
    }

    /**
     * Resets the version to specified numbers.
     *
     * @param numbers new version numbers.
     * @return version descriptor.
     * @throws IllegalArgumentException if any version number is illegal.
     * @throws NullPointerException is numbers is null;
     *
     * @since v1.1.0
     */
    public Version reset(int... numbers) {
        for (int number : numbers) {
            validateNumber(number);
        }
        return resetNumbers(numbers);
    }

    /**
     * Sets a new version number.
     *
     * @param index available version number index.
     * @param number version number (not negative).
     * @return version descriptor.
     * @throws IllegalArgumentException if either index or number are illegal.
     *
     * @since v1.1.0
     */
    public Version setNumber(int index, int number) {
        return setNumber(index, number, null);
    }

    /**
     * Sets a new version number.
     *
     * @param index available version number index.
     * @param number version number (not negative).
     * @param label version number label (optional).
     * @return version descriptor.
     * @throws IllegalArgumentException if either index or number are illegal.
     *
     * @since v1.1.0
     */
    public Version setNumber(int index, int number, String label) {
        validateNumber(number);
        if (isBeyondBounds(index)) {
            String message = String.format("illegal number index: %d", index);
            throw new IllegalArgumentException(message);
        }
        labels.set(--index, label);
        numbers.set(index, number);
        return this;
    }

    @Override
    public String toString() {
        return print().toString();
    }

    private List<String> labels;
    private List<Integer> numbers;
    private boolean snapshot;

    private Version appendNumber(int number, String label) {
        labels.add(label);
        numbers.add(number);
        return this;
    }

    private boolean isBeyondBounds(int index) {
        if (index < 1) {
            String message = String.format("index is not positive: %d", index);
            throw new IllegalArgumentException(message);
        }
        return index > numbers.size();
    }

    private Version resetNumbers(int... numbers) {
        if (numbers == null) {
            throw new NullPointerException("numbers are null");
        }
        this.labels = new LinkedList<String>();
        this.numbers = new LinkedList<Integer>();
        for (int number : numbers) {
            appendNumber(number, null);
        }
        return this;
    }

    private Version validateNumber(int number) {
        if (number < 0) {
            String message = String.format("number is negative: %d", number);
            throw new IllegalArgumentException(message);
        }
        return this;
    }
}

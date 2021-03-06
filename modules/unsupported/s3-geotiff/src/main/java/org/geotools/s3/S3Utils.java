/*
 * GeoTools - The Open Source Java GIS Toolkit
 * http://geotools.org
 *
 * (C) 2017, Open Source Geospatial Foundation (OSGeo)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation;
 * version 2.1 of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 */
package org.geotools.s3;

/** Utility methods for S3 access */
public class S3Utils {

    /**
     * @param s3Path the s3:// url style path
     * @return bucket and key parts of the given S3 path, IN THAT ORDER
     */
    public static String[] getS3PathParts(String s3Path) {
        String[] parts = s3Path.split("/");
        StringBuilder keyBuilder = new StringBuilder();

        String bucket = parts[2];
        for (int i = 3; i < parts.length; i++) {
            keyBuilder.append("/").append(parts[i]);
        }
        String key = keyBuilder.toString();
        key = key.startsWith("/") ? key.substring(1) : key;

        return new String[] {bucket, key};
    }
}

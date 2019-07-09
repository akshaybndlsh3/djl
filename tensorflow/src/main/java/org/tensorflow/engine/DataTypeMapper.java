/*
 * Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance
 * with the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.tensorflow.engine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import software.amazon.ai.ndarray.types.DataType;

public final class DataTypeMapper {

    private static Map<DataType, org.tensorflow.DataType> j2TMap = createJ2T();
    private static Map<org.tensorflow.DataType, DataType> t2JMap = createT2J();

    private DataTypeMapper() {}

    private static Map<DataType, org.tensorflow.DataType> createJ2T() {
        Map<DataType, org.tensorflow.DataType> map = new ConcurrentHashMap<>();
        map.put(DataType.FLOAT32, org.tensorflow.DataType.FLOAT);
        map.put(DataType.FLOAT64, org.tensorflow.DataType.DOUBLE);
        map.put(DataType.INT32, org.tensorflow.DataType.INT32);
        map.put(DataType.INT64, org.tensorflow.DataType.INT64);
        map.put(DataType.UINT8, org.tensorflow.DataType.UINT8);
        return map;
    }

    private static Map<org.tensorflow.DataType, DataType> createT2J() {
        Map<org.tensorflow.DataType, DataType> map = new ConcurrentHashMap<>();
        map.put(org.tensorflow.DataType.FLOAT, DataType.FLOAT32);
        map.put(org.tensorflow.DataType.DOUBLE, DataType.FLOAT64);
        map.put(org.tensorflow.DataType.INT32, DataType.INT32);
        map.put(org.tensorflow.DataType.INT64, DataType.INT64);
        map.put(org.tensorflow.DataType.UINT8, DataType.UINT8);
        return map;
    }

    public static DataType getJoule(org.tensorflow.DataType t) {
        return t2JMap.get(t);
    }

    public static org.tensorflow.DataType getTf(DataType t) {
        return j2TMap.get(t);
    }
}
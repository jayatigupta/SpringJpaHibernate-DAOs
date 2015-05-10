package com.applotus.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.applotus.util.FieldDef.DataType;

@SuppressWarnings("unchecked")
public final class MapFlatenningUtil {

    static final String FIELD_SEPARATOR = "->";

    public static Set<FieldDef> getFields(Map<String, Object> data) {
	Set<FieldDef> fields = new HashSet<FieldDef>();
	resolveToFields(data, fields, "");
	return fields;
    }

    private static void resolveToFields(Map<String, Object> data,
	    Set<FieldDef> fields, final String namespace) {
	for (Entry<String, Object> entry : data.entrySet()) {
	    String key = entry.getKey();
	    Object valObject = entry.getValue();
	    String localName = "";
	    if ("".equals(namespace)) {
		localName = key;
	    } else {
		localName = namespace + FIELD_SEPARATOR + key;
	    }
	    if (valObject instanceof Map) {
		resolveToFields((Map<String, Object>) valObject, fields,
			localName);
	    } else {
		if (valObject != null) {
		    fields.add(new FieldDef(localName, getType(valObject),
			    valObject.toString()));
		}
	    }
	}
    }

    public static Map<String, Object> getMapFromFields(
	    Collection<FieldDef> fields) {
	Map<String, Object> dataMap = new HashMap<String, Object>();
	for (FieldDef field : fields) {
	    String key = field.getName();
	    String[] keys = key.split(FIELD_SEPARATOR);
	    String val = field.getValue();
	    DataType type = field.getType();
	    if (keys.length == 1) {
		dataMap.put(keys[0], getObjectFromRaw(type, val));
	    } else {
		Map<String, Object> lastMap = dataMap;
		for (int i = 0; i < keys.length - 1; i++) {
		    if (lastMap.get(keys[i]) == null) {
			lastMap.put(keys[i], new HashMap<String, Object>());
		    }
		    lastMap = (Map<String, Object>) lastMap.get(keys[i]);
		}
		lastMap.put(keys[keys.length - 1], getObjectFromRaw(type, val));
	    }
	}
	return dataMap;
    }

    static boolean isPremitive(Class<?> clazz) {
	return clazz.equals(String.class) || clazz.equals(Integer.class)
		|| clazz.equals(Long.class) || clazz.equals(Float.class)
		|| clazz.equals(Double.class);
    }

    static DataType getType(Object obj) {
	if (obj instanceof String) {
	    return DataType.STRING;
	}
	if (obj instanceof Long) {
	    return DataType.LONG;
	}
	if (obj instanceof Integer) {
	    return DataType.INTEGER;
	}
	if (obj instanceof Double) {
	    return DataType.DOUBLE;
	}
	return DataType.OBJECT;
    }

    static Object getObjectFromRaw(DataType dataType, String value) {
	if (dataType != null && value != null) {
	    switch (dataType) {
	    case STRING:
		return value;
	    case INTEGER:
		return Integer.parseInt(value);
	    case LONG:
		return Long.parseLong(value);
	    case DOUBLE:
		return Double.parseDouble(value);
	    default:
		return value;
	    }
	}
	return null;
    }
}

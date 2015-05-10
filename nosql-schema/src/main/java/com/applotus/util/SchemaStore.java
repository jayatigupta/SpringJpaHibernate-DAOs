package com.applotus.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.inject.Inject;

import com.applotus.dao.SchemaDAO;
import com.applotus.entity.Schema;

public class SchemaStore {

	@Inject
	private SchemaDAO dao;

	public void saveFields(String key, Map<String, Object> dataMap) {
		Set<FieldDef> fields = MapFlatenningUtil.getFields(dataMap);
		List<Schema> schemas = new ArrayList<>();
		for (FieldDef fd : fields) {
			Schema sc = new Schema(UUID.randomUUID().toString(), key, fd);
			schemas.add(sc);
		}
		dao.save(schemas);
	}

	public Map<String, Object> getData(String key) {
		List<Schema> schemas = dao.findByIdentifier(key);
		if(schemas!= null) {
		    List<FieldDef> fields = new ArrayList<>();
		    for(Schema sc : schemas) {
			fields.add(new FieldDef(sc.getField(), sc.getDataType(), sc.getValue()));
		    }
		    return MapFlatenningUtil.getMapFromFields(fields);
		}
		return null;
	}

	public void deleteData(String key) {
		List<Schema> scs = dao.findByIdentifier(key);
		if (scs.size() > 0) {
			dao.delete(scs);
		}
	}

	public void deleteField(String key, String fieldName) {
		Schema sc = dao.findByIdentifierAndField(key, fieldName);
		if (sc != null) {
			dao.delete(sc);
		}
	}
}

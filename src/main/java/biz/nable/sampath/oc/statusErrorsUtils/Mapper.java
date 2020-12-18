package biz.nable.sampath.oc.statusErrorsUtils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import biz.nable.sb.cor.common.service.impl.CommonConverter;

@Component
//@Log4j2 // this anotation enabled due to slf4j logging not working
public class Mapper {
	
	@Autowired
	CommonConverter commonConverter;
	
	// do logging with sl4j
	private static final Logger logger = LoggerFactory.getLogger(Mapper.class);
	
	
	
	
	public EpfEtfRequs convertToGroupHistory(Groups groups) {

		GroupsHistory groupHistory = new GroupsHistory();

		// copy workflow selection basic data tothe history table.
		try {
			// if there is no this new converter registraion errors may occure when data
			// values are trying to convert to null.
			java.util.Date defaultValue = null;
			Converter converter = new DateConverter(defaultValue);
			BeanUtilsBean beanUtilsBean = BeanUtilsBean.getInstance();
			beanUtilsBean.getConvertUtils().register(converter, java.util.Date.class);
			beanUtilsBean.copyProperties(groupHistory, groups);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block

		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block

		}

		// create the full object to a map and set to the payloand.
		groupHistory.setRequestPayload(commonConverter.pojoToMap(groups));

		return groupHistory;

	}
	

}

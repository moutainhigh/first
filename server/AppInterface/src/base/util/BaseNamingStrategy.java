package base.util;

import org.hibernate.cfg.DefaultNamingStrategy;
import org.hibernate.util.StringHelper;

public class BaseNamingStrategy extends DefaultNamingStrategy {
	public static final BaseNamingStrategy INSTANCE = new BaseNamingStrategy();

	public String propertyToColumnName(String propertyName) {
		return CamelToUpperCase(StringHelper.unqualify(propertyName));
	}

	public static String CamelToUpperCase(String camel) {
		if (camel == null)
			return "";

		if (camel.length() <= 1) {
			return camel.toUpperCase();
		}

		char[] ca1 = camel.toCharArray();
		char[] ca2 = new char[ca1.length + 10];

		int i1 = 0;
		for (int i = 0; i < ca1.length; ++i) {
			if (ca1[i] >= 65 && ca1[i] <= 90 && i != 0) {
				ca2[i + i1] = '_';
				ca2[i + i1 + 1] = ca1[i];

				i1++;
			} else {
				ca2[i + i1] = ca1[i];
			}
		}

		return new String(ca2, 0, ca1.length + i1).toUpperCase();
	}
}
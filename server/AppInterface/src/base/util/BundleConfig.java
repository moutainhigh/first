package base.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;


public class BundleConfig {

	public static final String CONFIG_FILENAME = "config";

	private Logger logger = Logger
			.getLogger("com.individual.common.utils.BundleConfig");

	private ResourceBundle resourceBundle;

	/**
	 * Ĭ�Ϲ��캯��
	 */
	public BundleConfig() throws Exception {
		this(CONFIG_FILENAME);
	}

	public BundleConfig(String configFileName) throws Exception {

		logger.debug(configFileName);
		try {
			// �ж������ļ�����Ƿ�Ϊ��
			if (configFileName != null) {
				// �����ļ���Ʋ�Ϊ��

				resourceBundle = ResourceBundle.getBundle(configFileName);

			} else {
				// �����ļ�Ϊ�գ���ȡϵͳĬ�������ļ����
				resourceBundle = ResourceBundle.getBundle(CONFIG_FILENAME);

			}
		} catch (MissingResourceException ex) {
			// ��ȡ�����ļ������׳��쳣
			logger.error(ex);
			throw new Exception(ex.getMessage());
		}
	}

	public boolean getBoolean(String key) {
		return getBoolean(key, false);
	}

	/**
	 * ���Keyֵ�������ļ��ж�ȡ��Ӧ�Ĳ���booleanֵ��������ֵΪ�գ��򷵻�Ĭ��ֵ��defaultValue
	 */
	public boolean getBoolean(String key, boolean defaultValue) {
		String stringValue = getString(key);
		if (stringValue != null) {
			return "TRUE".equalsIgnoreCase(stringValue);
		} else {
			return defaultValue;
		}
	}

	/**
	 * ���Keyֵ�������ļ��ж�ȡ��Ӧ�Ĳ���intֵ������Ĭ��ֵ-1
	 * 
	 * @param String
	 *            key
	 * @return int
	 */
	public int getInt(String key) {
		return getInt(key, 10);
	}

	/**
	 * ���Keyֵ�������ļ��ж�ȡ��Ӧ�Ĳ���intֵ��������ֵΪ�գ��򷵻�Ĭ��ֵ��defaultValue
	 * 
	 * @param String
	 *            key int defaultValue
	 * @return int
	 */
	public int getInt(String key, int defaultValue) {
		int intValue = -1;
		String stringValue = getString(key);
		// �ж������ļ��ж�ȡ���ַ��Ƿ�Ϊ��
		if (stringValue != null) {
			try {
				intValue = Integer.parseInt(stringValue);
			} catch (NumberFormatException ex) {
				// ���ַ�ת��Ϊ���ַ������
				intValue = defaultValue;
			}
		} else {
			// �ַ�Ϊ��
			intValue = defaultValue;
		}
		return intValue;
	}

	/**
	 * ���Keyֵ�������ļ��ж�ȡ��Ӧ�Ĳ���longֵ
	 * 
	 * @param String
	 *            key
	 * @return long
	 */
	public long getLong(String key) {
		return getLong(key, -1l);
	}

	/**
	 * ���Keyֵ�������ļ��ж�ȡ��Ӧ�Ĳ���longֵ��������ֵΪ�գ��򷵻�Ĭ��ֵ��defaultValue
	 * 
	 * @param String
	 *            key long defaultValue
	 * @return long
	 */
	public long getLong(String key, long defaultValue) {
		long longValue = -1l;
		String stringValue = getString(key);
		// �ж������ļ��ж�ȡ���ַ��Ƿ�Ϊ��
		if (stringValue != null) {
			try {
				longValue = Long.parseLong(stringValue);
			} catch (NumberFormatException ex) {
				// ���ַ�ת��Ϊ���ַ������
				longValue = defaultValue;
			}
		} else {
			// �ַ�Ϊ��
			longValue = defaultValue;
		}
		return longValue;
	}

	/**
	 * ���Keyֵ�������ļ��ж�ȡ��Ӧ�Ĳ���Stringֵ��������󷵻ؿ�ֵ
	 * 
	 * @param String
	 *            key
	 * @return String
	 */
	public String getString(String key) {
		logger.debug("key" + key);
		return getString(key, null);
	}

	/**
	 * ���Keyֵ�������ļ��ж�ȡ��Ӧ�Ĳ���Stringֵ��������ֵΪ�գ��򷵻�Ĭ��ֵ��defaultValue
	 * 
	 * @param String
	 *            key String defaultValue
	 * @return String
	 */
	public String getString(String key, String defaultValue) {
		String stringValue = null;
		try {
			stringValue = resourceBundle.getString(key);
		} catch (Exception ex) {
			// ��ȡ�����ļ����󣬷���Ĭ��ֵ
			stringValue = defaultValue;
		}
		return stringValue;
	}
}
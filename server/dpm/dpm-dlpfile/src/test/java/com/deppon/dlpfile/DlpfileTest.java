package com.deppon.dlpfile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * Unit test for simple App.
 */
public class DlpfileTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public DlpfileTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(DlpfileTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(
				"http://10.224.70.132:8081/dpm/dpm/dlpfile_decryptFile.action?userId=130126&token=2c249ddb88288c5cbb5ba7729a249ad5");
		// 添加文件
		FileBody f = new FileBody(new File("d:\\思程.PNG"));
		// 构造请求
		MultipartEntityBuilder builder = MultipartEntityBuilder.create()
				.addPart("upload", f);
		// 正式环境上面，继续添加几个参数.
		StringBody userId = new StringBody("130126", ContentType.TEXT_PLAIN);
		// 添加参数
		StringBody token = new StringBody("2c249ddb88288c5cbb5ba7729a249ad5",
				ContentType.TEXT_PLAIN);
		StringBody filename = new StringBody("123.png", ContentType.TEXT_PLAIN);
		// 添加参数
		builder = builder.addPart("token", token).addPart("userId", userId)
				.addPart("filename", filename);
		HttpEntity reqEntity = builder.build();
		httppost.setEntity(reqEntity);
		// 调用请求，将返回结果保存到本地文件.
		byte[] charts;
		try {
			charts = httpclient.execute(httppost, handler);
			saveFile(new File("f:\\aaaa\\"), "123.png", charts);
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("保存ok！"); 
		
	}

	private void saveFile(File extDir, String filename, byte[] byts) {
		// 文件全名
		File fullFilename = null;
		try {
			// 目录
			String dirName = extDir.getAbsolutePath() + "/dlpfiles";
			// 新地址
			File newExtDir = new File(dirName);
			// 目录不存在就创建
			if (!newExtDir.exists()) {
				newExtDir.mkdir();
				// newExtDir.setWritable(true);
			}
			// 如果已经存在就删除
			fullFilename = new File(newExtDir, filename);
			// 删除临时文件夹里面文件
			if (fullFilename.exists()) {
				fullFilename.deleteOnExit();
			}
			// 写文件流
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
					new FileOutputStream(fullFilename));
			// 写进去
			bufferedOutputStream.write(byts);
			// 关闭文件流
			bufferedOutputStream.close(); 
		} catch (IOException e) {
			// 补货异常
			e.printStackTrace();
		} finally {

		}
	}

	ResponseHandler<byte[]> handler = new ResponseHandler<byte[]>() {
		public byte[] handleResponse(HttpResponse response)
				throws ClientProtocolException, IOException {
			// 得到返回对象
			HttpEntity entity = response.getEntity();
			// 进行处理
			if (entity != null) {
				return EntityUtils.toByteArray(entity);
			}
			// 不进行处理
			else {
				return null;
			}
		}
	};
}

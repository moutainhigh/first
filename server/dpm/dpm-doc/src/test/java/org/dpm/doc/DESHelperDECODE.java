package org.dpm.doc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.deppon.dpm.doc.server.util.DESHelper;
import com.deppon.dpm.doc.server.util.DESHelper4Doc;

/**
 * 滴滴发单数据解密测试
 * 
 * */
public class DESHelperDECODE {

	public static void main(String[] args) throws Exception {
		String encodeStr = "0dXLRyk0I/WxKUaC5hjKTDarkPsx9takXkyjQGCWzvxOkCATO3Fw2aGHffsMtegQPpAXGpV2rA/t\r\n22fHy3soAx7Spyegrzb2B0+PJP6zgu3jVHys0th3S57SlZWwg/6Z9l7z6ampdv1MP0uTWBVtwQui\r\nK7J4+DFnWgNHWECXA6r71rPyjg1OkWp3wWvgg/VDmiMnokHktnYCNtZtKjUuJjpULxaJwyfSDJSL\r\nlghnt9Cmln7a2jM021tuyeFejYZHI+3RRmKWIMWHxSJ05PTiXim2+CY7U0/B6FHUKcJPuX/Ge5mw\r\n9qW3jpmZx11q2F4+knnmeJ32mAruh0am0LvoCmRL4o0vDVBciAOYb/1Y11j1la4PdUmmiH+7wIfr\r\nfRXsrc4k8GKLGNBSdv/aLLqssJeej8wMh5lr0WuEefSjAej88ZqH68XV0CU71uJugm/gWng3Fzgi\r\npuWboaGP6pRSll5mwQr8IWH+sbYVDdwVHvGv5oPqg06arRkzZckhrln+iUNE89uwHEHtd4FVdYrk\r\n+C9GLheQcr2nC1Ovjwc3j1Gl+SaSuteNGZv8ONGREzzr6vNiSskwgH7dcLirDrxQSqDtlN/W/n4z\r\nPeWUub1QdsknmhBK4salHRcSwvQdTBuBVjZgNU2k242IvumjllnxPgWcutAtvH/EQnH8d0s8tns=\r\n";
		String didi_key = "bdd445BA4a9040D3d84c";
		String decodeStr = DESHelper4Doc.decrypt(encodeStr, didi_key.substring(0, 8));
		//System.out.println(encodeStr);
		System.out.println(decodeStr);
		
		Pattern p = Pattern.compile("\r|\n");
		Matcher m = p.matcher(encodeStr);
		String result = m.replaceAll("");
		System.out.println(result);
		
		String decodeResult = DESHelper4Doc.decrypt(result, didi_key.substring(0, 8));
		System.out.println(decodeResult);
		String encodeResult = DESHelper4Doc.encrypt(decodeResult,didi_key.substring(0, 8));
		System.out.println(encodeResult);
		Pattern p2 = Pattern.compile("\r|\n");
		Matcher m2 = p2.matcher(encodeResult);
		encodeResult = m2.replaceAll("");
		System.out.println(encodeResult);
	}
}

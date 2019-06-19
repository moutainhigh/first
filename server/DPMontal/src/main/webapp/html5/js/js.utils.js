/**
 * 
* @Title: getvl 
* @Description: 通过URL解析值
* @author 092039/dpyuanjb@deppon.com 
 * 2014年9月2日上午10:39:33
* @param @param name 要解析的字段
* @param @returns    设定文件 
* @return any    返回类型 
* @throws
 */	

function getvl(name) {
	var reg = new RegExp("(^|\\?|&)" + name + "=([^&]*)(\\s|&|$)", "i");
	if (reg.test(location.href))
		return unescape(RegExp.$2.replace(/\+/g, " "));
	return "";
};
/**
 * 
* @Title: filter 
* @Description: url 替换"+" 与 "&" 
* @author 092039/dpyuanjb@deppon.com 
 * 2014年9月2日下午2:49:50
* @param @param str
* @param @returns    设定文件 
* @return any    返回类型 
* @throws
 */
function filter(str) {
	str = str.replace(/\+/g, "%2B");
	str = str.replace(/\&/g, "%26");
	return str;
}
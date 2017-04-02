import org.apache.commons.codec.digest.DigestUtils;


public class 加密解密测试 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		md5("zxcopuqwel,jmzp;ixouc1234");
		sha1("zxcopuqwel,jmzp;ixouc1234");
	}
	
	public static void md5(String salt){
		String digest = DigestUtils.md5Hex("123456"+salt);
		System.out.println("Md5:"+digest);
		System.out.println("MD5:"+digest.toUpperCase());
	}
	
	public static void sha1(String salt){
		String digest = DigestUtils.sha512Hex("123456"+salt);
		System.out.println("sha1:"+digest);
		System.out.println("sha1:"+digest.toUpperCase());
		
		
//		E10ADC3949BA59ABBE56E057F20F883E	
//		7C4A8D09CA3762AF61E59520943DC264 94F8941B
//		
//		8D969EEF6ECAD3C29A3A629280E686CF
//		0C3F5D5A86AFF3CA12020C923ADC6C92
		
//		BA3253876AED6BC22D4A6FF53D8406C6
//		AD864195ED144AB5C87621B6C233B548
//		BAEAE6956DF346EC8C17F5EA10F35EE3
//		CBC514797ED7DDD3145464E2A0BAB413
	}

}

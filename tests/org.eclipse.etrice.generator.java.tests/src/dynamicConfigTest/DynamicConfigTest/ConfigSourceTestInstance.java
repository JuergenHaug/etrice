package DynamicConfigTest;

import org.eclipse.etrice.runtime.java.config.ConfigSourceFile;
import org.eclipse.etrice.runtime.java.config.IConfigSource;

public class ConfigSourceTestInstance {

	private static IConfigSource instance = null;
	
	public static IConfigSource getInstance(){
		if(instance == null){
			instance = new ConfigSourceFile("DynamicConfigTest.rt-config");
		}
		return instance;
	}
}

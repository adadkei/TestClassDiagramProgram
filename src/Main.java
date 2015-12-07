
import java.io.IOException;
import java.util.List;

import com.change_vision.jude.api.inf.exception.LicenseNotFoundException;
import com.change_vision.jude.api.inf.exception.NonCompatibleException;
import com.change_vision.jude.api.inf.exception.ProjectLockedException;
import com.change_vision.jude.api.inf.exception.ProjectNotFoundException;
import com.change_vision.jude.api.inf.model.IAttribute;
import com.change_vision.jude.api.inf.model.IClass;
import com.change_vision.jude.api.inf.model.IGeneralization;
import com.change_vision.jude.api.inf.model.INamedElement;
import com.change_vision.jude.api.inf.model.IOperation;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, LicenseNotFoundException,
			ProjectNotFoundException, NonCompatibleException, IOException, ProjectLockedException, Throwable {

		List<INamedElement> classContents;
	
		ClassDefinitionBuilder cdb = new ClassDefinitionBuilder("class_diagram.asta");
		System.out.println("プロジェクトは取得済み");
		classContents = cdb.getContents();

		for (int i = 0; i < classContents.size(); i++) {
			System.out.println((i + 1) + "個目のコンテンツは" + classContents.get(i));
		}

	

	}

}

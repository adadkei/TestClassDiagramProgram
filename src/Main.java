
import java.io.IOException;
import java.util.List;

import com.change_vision.jude.api.inf.exception.LicenseNotFoundException;
import com.change_vision.jude.api.inf.exception.NonCompatibleException;
import com.change_vision.jude.api.inf.exception.ProjectLockedException;
import com.change_vision.jude.api.inf.exception.ProjectNotFoundException;
import com.change_vision.jude.api.inf.model.INamedElement;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, LicenseNotFoundException,
			ProjectNotFoundException, NonCompatibleException, IOException, ProjectLockedException, Throwable {

		List<INamedElement> classContents;
		ClassDiagramFinder cdf = new ClassDiagramFinder("class_diagram.asta");
		System.out.println("プロジェクトは取得済み");
		classContents = cdf.getIClasses(cdf.getiModel());
		System.out.println("クラス数は" + classContents.size() + "個");
		for (int i = 0; i < classContents.size(); i++) {
			System.out.println((i+1)+"個目のクラスの名前は" + classContents.get(i));
		}

	}

}

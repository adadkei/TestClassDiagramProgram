import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.exception.LicenseNotFoundException;
import com.change_vision.jude.api.inf.exception.NonCompatibleException;
import com.change_vision.jude.api.inf.exception.ProjectLockedException;
import com.change_vision.jude.api.inf.exception.ProjectNotFoundException;
import com.change_vision.jude.api.inf.model.IClass;
import com.change_vision.jude.api.inf.model.IModel;
import com.change_vision.jude.api.inf.model.INamedElement;
import com.change_vision.jude.api.inf.model.IPackage;
import com.change_vision.jude.api.inf.project.ProjectAccessor;

public class ClassDiagramFinder {
	ProjectAccessor prjAccessor;
	String inputFile;
	IModel iModel;
    private static final String EMPTY_COLUMN = "";


	/**
	 * @param inputFile
	 *            File to input
	 */
	public ClassDiagramFinder(String inputFile) throws LicenseNotFoundException, ProjectNotFoundException,
			NonCompatibleException, IOException, ClassNotFoundException, ProjectLockedException, Throwable {
		this.inputFile = inputFile;
		// Open a project. And get the model.
		ProjectAccessor prjAccessor = AstahAPI.getAstahAPI().getProjectAccessor();
		prjAccessor.open(inputFile);
		iModel = prjAccessor.getProject();
		prjAccessor.close();
	}

	/**
	 * Get classes in selected package.
	 * 
	 * @param iPackage
	 *            Selected package
	 * @return List of all stored classes
	 */
	public List getIClasses(IPackage iPackage) {
		List iClasses = new ArrayList();
		INamedElement[] iNamedElements = iPackage.getOwnedElements();
		for (int i = 0; i < iNamedElements.length; i++) {
			INamedElement iNamedElement = iNamedElements[i];
			if (iNamedElement instanceof IClass) {
				iClasses.add(iNamedElement);
			}
		}
		return iClasses;
	}
	

	public IModel getiModel() {
		return iModel;
	}
}

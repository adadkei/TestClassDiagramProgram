import java.io.IOException;
import java.util.List;

import com.change_vision.jude.api.inf.exception.LicenseNotFoundException;
import com.change_vision.jude.api.inf.exception.NonCompatibleException;
import com.change_vision.jude.api.inf.exception.ProjectLockedException;
import com.change_vision.jude.api.inf.exception.ProjectNotFoundException;
import com.change_vision.jude.api.inf.model.IClass;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, LicenseNotFoundException,
            ProjectNotFoundException, NonCompatibleException, IOException, ProjectLockedException,
            Throwable {

        List classContents;
        List at;
        List ope;

        ClassDiagramFinder cdf = new ClassDiagramFinder("testclass.asta");
        System.out.println("プロジェクトは取得済み");

        classContents = cdf.getIClasses(cdf.getiModel());
        /*
         * クラスの名前取得、表示
         */
        System.out.println("クラス数は" + classContents.size() + "個");
        for (int i = 0; i < classContents.size(); i++) {
            System.out.println((i + 1) + "個目のクラスの名前は" + classContents.get(i));
        }
        /*
         * クラスのスーパークラス等を表示
         */
        System.out.println("スーパークラスは" + cdf.getSuperClass((IClass) classContents.get(3)));

        /*
         * 属性取得、表示
         */
        at = cdf.getAttributeLines((IClass) classContents.get(1));
        for (int i = 0; i < at.size(); i++) {
            System.out.println("属性は" + at.get(i));
        }
        /*
         * 操作取得、表示
         */
        ope = cdf.getOperationLines((IClass) classContents.get(1));
        for (int i = 0; i < ope.size(); i++) {
            System.out.println("操作は" + ope.get(i));
        }
    }
}
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.jxls.area.Area;
import org.jxls.command.AbstractCommand;
import org.jxls.command.Command;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.common.Size;
import org.jxls.transform.poi.PoiTransformer;
import org.jxls.util.Util;

public class AutoColumnWidthCommand extends AbstractCommand {

	private Area area;

	@Override
	public String getName() {
		return "autoColumnWidth";
	}

	@Override
	public Size applyAt(CellRef cellRef, Context context) {
		Size size = area.getSize();
        PoiTransformer transformer = (PoiTransformer) area.getTransformer();
        int startColumn = cellRef.getCol();
        List list = (List)context.getVar("headers");
        int endColumn = list.size()-1;
        for(int i = startColumn;i<=endColumn;i++) {
        	transformer.getWorkbook().getSheet(cellRef.getSheetName()).autoSizeColumn(i,true);
        }
        return size;
        
	}
	
    @Override
    public Command addArea(Area area) {
        super.addArea(area);
        this.area = area;
        return this;
    }

}

package org.hitechr.garobo.console.common.web.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/4/29.
 */
public class BaseModel implements Serializable {
    public static final int PAGESIZE_DEFAULT = 10;

    protected int startRow;

    protected int endRow;

    protected int pageIndex;

    protected int pageSize=PAGESIZE_DEFAULT;

    protected String tableName;

    protected boolean autoGenerateTableName = true;

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getStartRow() {
        if (pageSize < 1) {
            pageSize = PAGESIZE_DEFAULT;
        }
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        endRow = pageSize;
        startRow = (pageIndex - 1) * pageSize;
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isAutoGenerateTableName() {
        return autoGenerateTableName;
    }

    public void setAutoGenerateTableName(boolean autoGenerateTableName) {
        this.autoGenerateTableName = autoGenerateTableName;
    }
}

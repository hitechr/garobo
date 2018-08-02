package org.hitechr.garobo.console.common.web.page;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: yfzhangsheng
 * Date: 14-2-11
 * Time: 上午10:13
 * To change this template use File | Settings | File Templates.
 */
public class PaginatedList<T extends Serializable> extends WrapperArrayList<T> implements PageList<T> {

    private static final long serialVersionUID = -6761941552387789226L;

    public static final int PAGESIZE_DEFAULT = 10;

    private int pageSize;

    private int index;

    private int totalItem;

    private int totalPage;

    private int startRow;

    private int endRow;

    public PaginatedList() {
        repaginate();
    }

    public PaginatedList(int index, int pageSize) {
        this.index = index;
        this.pageSize = pageSize;
        repaginate();
    }

    public boolean isFirstPage() {
        return index <= 1;
    }

    public boolean isMiddlePage() {
        return !(isFirstPage() || isLastPage());
    }

    public boolean isLastPage() {
        return index >= totalPage;
    }

    public boolean isNextPageAvailable() {
        return !isLastPage();
    }

    public boolean isPreviousPageAvailable() {
        return !isFirstPage();
    }

    public int getNextPage() {
        if (isLastPage()) {
            return totalItem;
        } else {
            return index + 1;
        }
    }

    public int getPreviousPage() {
        if (isFirstPage()) {
            return 1;
        } else {
            return index - 1;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        repaginate();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
        repaginate();
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
        repaginate();
    }


    public int getTotalPage() {
        return totalPage;
    }


    public int getStartRow() {
        return startRow;
    }


    public int getEndRow() {
        return endRow;
    }

    private void repaginate() {
        if (pageSize < 1) {
            pageSize = PAGESIZE_DEFAULT;
        }
        if (index < 1) {
            index = 1;
        }
        if (totalItem > 0) {
            totalPage = totalItem / pageSize + (totalItem % pageSize > 0 ? 1 : 0);
            if (index > totalPage) {
                index = totalPage;
            }
            endRow = pageSize;
            startRow = (index - 1) * pageSize;
            if (endRow > totalItem) {
                endRow = totalItem;
            }
        }
    }


}
